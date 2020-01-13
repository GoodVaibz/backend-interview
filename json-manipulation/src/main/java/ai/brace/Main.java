package ai.brace;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class Main
{
    public static JSONModel parseJSONFile(final String path){
        Gson gson = new Gson();

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
        List<JSONModel> modelList = new ArrayList();
        modelList.add(a1);
        List<TextModel> task1 = Task1.orderTextArray(modelList);
        for(int i=0; i < task1.size(); i++)
        {
            System.out.println(task1.get(i).textdata);
        }

        // Task 2
        System.out.println("\nTask 2 Executing");
        modelList.add(a2);
        List<TextModel> task2 = Task1.orderTextArray(modelList);
        for(int i=0; i < task2.size(); i++)
        {
            System.out.println(task2.get(i).textdata);
        }

        // Task 3
        System.out.println("\nTask 3 Executing");
        Map<String, Integer> wordFrequencies = generateCounter(task2);
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet())
        {
            System.out.println("(" + entry.getKey() + ") : " + entry.getValue());
        }

        // Task 4
        System.out.println("\nTask 4 Executing");
        Task4.mergeJSONModel(a1, a2);
    }
}
