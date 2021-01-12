
import ic.util.Message;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thewbacca
 */
public class Combat {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\Documents\\COURSES\\Software\\ImageComparison\\testlog.txt"));
        
        String current;
        HashMap<String, Integer> map = new HashMap<>();
        while ((current = reader.readLine()) != null) {
            Message message = Message.getInstance();
            message.load(current); 
            String timestamp = message.getTimestamp();
            String line = message.getFull();
            if(line.matches(".* for ([1-9][0-9]+) .*$")){ 
                //System.out.println(line);
                      
                Matcher m = Pattern.compile( "([-_`\\'\\sa-zA-Z:]+)(\\s(kicks|bites|crushes|hits|slashes|slash|bash|bashes)\\s.*\\sfor\\s)([0-9]+)( points of damage.)")
                    .matcher(line);

                while(m.find()) {
                    // get match result object
                    MatchResult result = m.toMatchResult();
                    String name = result.group(1);
                    if(map.containsKey(name)){
                        Integer value = map.get(name) + Integer.parseInt(result.group(4));
                        map.replace(name, value);
                    } else {
                        Integer value = Integer.parseInt(result.group(4));
                        map.put(name, value);
                    }
                }
            }
        }
        
        for (String name: map.keySet()){
            String key = name.toString();
            String value = map.get(name).toString();  
            System.out.println(key + " -- " + value);  
        } 
    }
            
    
}
