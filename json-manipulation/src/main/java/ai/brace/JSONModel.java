package ai.brace;

import java.util.List;

public class JSONModel implements Cloneable{
    public String version;
    public String uuid;
    public Integer lastModified;
    public String title;
    public String author;
    public String translator;
    public String releaseDate;
    public String language;
    public List<TextModel> textArray;
}
