package ai.brace;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main
{
    public static Path getPathForResource(final String path)
    {
        try
        {
            return Paths.get(ClassLoader.getSystemResource(path).toURI());
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException(e);
        }
    }


    public static JSONModel parseJSONFile(final String path){
        Gson gson = new Gson();
        File currentDir = new File("");
        System.out.println(currentDir.getAbsolutePath());
        try(BufferedReader br = new BufferedReader(new FileReader(new File(path))))
        {
            Type type = new TypeToken<JSONModel>(){}.getType();
            JSONModel jsonModel = gson.fromJson(br, type);
            return jsonModel;
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public static void printInOrder(List<TextModel> textModelList)
    {
        Collections.sort(textModelList);
        for(int i=0; i < textModelList.size(); i++)
        {
            System.out.println(textModelList.get(i).textdata);
        }
    }

    public static HashMap<String, Integer> generateCounter(List<TextModel> textModelList)
    {
        final HashMap<String, Integer> wordCount = new HashMap<>();

        for(int i=0; i < textModelList.size(); i++)
        {
            String[] words = textModelList.get(i).textdata.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
            for(int j=0; j < words.length; j++)
            {
                wordCount.put(words[j], wordCount.getOrDefault(words[j], 0) + 1);
            }
        }
        return wordCount;
    }

    public static void main(String[] args)
    {
        JSONModel a1 = parseJSONFile("./src/main/resources/a1.json");
        JSONModel a2 = parseJSONFile("./src/main/resources/a2.json");

        // Task 1
        System.out.println("Task 1 Executing");
        printInOrder(a1.textArray);

        // Task 2
        System.out.println("\nTask 2 Executing");
        List<TextModel> joinedTextArray = new ArrayList(a1.textArray);
        joinedTextArray.addAll(a2.textArray);
        printInOrder(joinedTextArray);

        // Task 3
        System.out.println("\nTask 3 Executing");
        Map<String, Integer> wordFrequencies = generateCounter(joinedTextArray);
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
