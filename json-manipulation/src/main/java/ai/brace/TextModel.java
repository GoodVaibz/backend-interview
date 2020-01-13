package ai.brace;

import org.w3c.dom.Text;

public class TextModel implements Comparable<TextModel>{
    public Integer id;
    public String textdata;

    public int compareTo(TextModel t)
    {
        return this.id.compareTo(t.id);
    }
}
