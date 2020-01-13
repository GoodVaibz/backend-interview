package ai.brace;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Task4 {
    public static void mergeJSONModel(JSONModel model1, JSONModel model2)
    {
        final JSONModel baseModel;
        final JSONModel updatingModel;

        if(model1.lastModified < model2.lastModified)
        {
            baseModel = model1;
            updatingModel = model2;
        } else {
            baseModel =  model2;
            updatingModel = model1;
        }

        baseModel.uuid = UUID.randomUUID().toString();
        ArrayList<JSONModel> models = new ArrayList();
        models.add(model1);
        models.add(model2);

        baseModel.textArray = Task1.orderTextArray(models);
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("./src/main/resources/output.json"))
        {
            gson.toJson(baseModel, writer);
        } catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
