package ai.brace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static List<TextModel> orderTextArray(List<JSONModel> jsonModelList)
    {
        List<TextModel> joinedTextArray = new ArrayList();
        for (int i=0; i < jsonModelList.size(); i++) {
            joinedTextArray.addAll(jsonModelList.get(i).textArray);
        }

        Collections.sort(joinedTextArray);
        return joinedTextArray;
    }
}
