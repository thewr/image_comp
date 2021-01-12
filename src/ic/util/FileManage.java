/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


/**
 *
 * @author Thewbacca
 */
public class FileManage {
    static HashMap<String, String> players;
    BufferedReader reader;
    Vehicle vehicle;
    public FileManage(){
    }

    public static File getLastModifiedDir(String directoryPath)
    {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        File dir_current = Arrays.stream(files).filter(File::isDirectory).max(Comparator.comparing(File::lastModified)).orElse(null);
        return dir_current;
    }
    
    public static File getLastModifiedFile(String directoryFilePath)
    {
    File directory = new File(directoryFilePath);
    File[] files = directory.listFiles(File::isFile);
    long lastModifiedTime = Long.MIN_VALUE;
    File chosenFile = null;

    if (files != null)
    {
        for (File file : files)
        {
            if ((!file.toString().contains("mp4"))&&(file.lastModified() > lastModifiedTime))
            {
                chosenFile = file;
                lastModifiedTime = file.lastModified();
            }
        }
    }
    return chosenFile;
    }
    
    public void purgeLogFiles(String path){
        File logDir = getLastModifiedDir(path);

        File[] logFiles = logDir.listFiles();
        
        long oldestDate = Long.MAX_VALUE;
        File oldestFile = null;
        if( logFiles != null && logFiles.length >10){
            //delete oldest files after theres more than 500 log files
            for(File f: logFiles){
                if(f.lastModified() < oldestDate){
                    oldestDate = f.lastModified();
                    oldestFile = f;
                }               
            }

            if(oldestFile != null){
                oldestFile.delete();
            }
        }
    }
    
    public File[] getFiles(String path){
        File[] files = {null,null};
        File dir_current = getLastModifiedDir(path);

        // Populates the array with names of files and directories
        String[] captured = (new File(dir_current.toString())).list();
        files[1] = getLastModifiedFile(dir_current.toString());
        for(String cap:captured)
        {                    
            String comp = dir_current.toString()+"\\"+cap;
            if ((files[0] != null)&&(comp.equals(files[1].toString())))
                break;
                
                if(!cap.contains("mp4"))
                {
                    files[0] = new File(dir_current.toString()+"\\"+cap); 
                }
        }
        return files;    
    }
    
    public static void scanFile() throws IOException, ParseException, AWTException {
        
        Time time = Time.getInstance();
        
        //System.out.println("------------ scanning file -------------");
        int tsLen = ("[Thu Sep 19 10:30:44 2019]").length();

        String current;
        while ((current = Constants.reader.readLine()) != null) {

            //bad timestamp ~ log issue
            if (tsLen > current.length()+1) 
                continue;
            
            String line = null;
/*
            if (Constants._fileLen < Constants._filePointer) {
                Constants._filePointer = Constants._fileLen;
            } else if (Constants._fileLen > Constants._filePointer) {
                RandomAccessFile raf = new RandomAccessFile(Constants.filename, "r");   
                raf.seek(Constants._filePointer);
                while ((line = raf.readLine()) != null){}
                Constants._filePointer = raf.getFilePointer();
                raf.close();  
            }
            */

            Message message = Message.getInstance();
            message.load(current); 
            String timestamp = message.getTimestamp();
          
            //if(!time.isNow(timestamp))
            //    continue;

            if(time.isPast(timestamp, 5)) continue;
            
            line = message.getText();

            if(Constants.bSeek) {
                //System.out.println("Seeking target ... " + line);
                Seek.getInstance().direction(message.getFull(), timestamp);
            }
            
           // testing regex ........ //
           /* String regex = "111 NExt";
              String regex3 = "^(\\d)\\1{2}\\b";
              System.out.println("Current order set: " + Constants.CHorder);
              System.out.println(regex.toUpperCase());
           */
            //line = line.trim();
            System.out.println(line);

            /*
            if(line.matches("You have entered [A-Z][a-z]+.*\\."))
            {
                System.out.println(line.split("entered",2)[1].trim());
            }
            */

            String[] keys = {"shouts", "tells","says","character","say","auctions"};
            if(message.hasContent(keys)){ 
                line = message.getContent();
            } else {
                continue;
            }
            

            
            //System.out.println(line);
            //line = line.trim();
            
            if((line.startsWith(Constants.CHorder) && line.toUpperCase().endsWith("NEXT"))
                    ||(line.toUpperCase().startsWith("NEXT") && line.endsWith(Constants.CHorder)))
            {
                Constants.clr.setStartChain(true);      
                System.out.println(Constants.clr.isCHAIN() + " | " + Constants.clr.bStart + " | " + Constants.clr.bSlowed);
            }
            
        }
       // reader.close();
    }
}
    
    
    
    
 