package ic.util;

public class Message {

    public Boolean isValidInstance;
    private Message(){}
    private static class LazyLoader {
        static final Message INSTANCE = new Message();
    }
    public static Message getInstance(){
        return LazyLoader.INSTANCE;
    }
    private static String[] tLine;
    private static final int tsLen = ("[Thu Sep 19 10:30:44 2019]").length();
    private String player;
    private String text;
    private String content;

    public void load(String line) {
       // tLine = text.split(" auctions, ");
       tLine = line.split("((?<=]))");
    }

    public String getText(){
        String text;
        if(tLine[1].contains(",")){
           text = tLine[1].split(",",2)[1].trim();
           text = text.substring(1,text.length()-1);
           return text;
        } else {
            return tLine[1];
        }
    }
    
    public String getFull(){
        return tLine[1];
    }

    public String getTimestamp(){      
        return tLine[0].substring(1, tsLen-1);
    }
    
    public String getContent(){
        return content;
    }

    public boolean hasContent(String[] sArr){
        String line = tLine[1].trim();
        
        for(String s:sArr)
        {
            if(line.contains(s+","))
            {
                content = line.split(",",2)[1].trim();
                content = content.substring(1,content.length()-1);
                return true;
            }
        }
        return false;
    }

    // php equivalent class
    private String substr(String s,int start, int length) {
        if (length < 0)
            length = s.length()+length;
        if (start < 0)
            start = s.length()+start;

        s = s.substring(start,length);
        return s;
    }
    

    public String processLine(String name) {

        while(true)
        {
            String old = name;
            name = name.replaceAll("^(?i)((wtsell)|(wts)|(spell:)|wtt|wtb(uy)?|paying|"
                    + "buying|plat\\s|selling|full\\s|only|ea\\s|stack(s)?"
                    + "|(per)|(each)|(Ll ))","").trim();
            name = name.replaceAll("^(?i)(x|-)+","").trim();
            name = name.replaceAll("(\\s)(x|-)+$","").trim();
            name = name.replaceAll("^(?i)((\\'|-|:|_)+)","").trim();

            if(name.matches(old)){
                break;
            }
        }
        return name;
    }
}
