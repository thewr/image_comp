/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;


/**
 *
 * @author Thewbacca
 */
public class FileManage {
    static HashMap<String, String> players;
    BufferedReader reader;
    private static LinkedList<String[]> que = new LinkedList<>();
    
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
    
    public void purgeLogFiles(File logDir){
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
    
    public static void scanFile() throws IOException, ParseException, AWTException {
        // scan lines
        //String last = "";
        //String last = FizzBuzzProcessor.last;
        
    
        Time time = Time.getInstance();
        
        //System.out.println("------------ scanning file -------------");
        int tsLen = ("[Thu Sep 19 10:30:44 2019]").length();

        String current;
        while ((current = Constants.reader.readLine()) != null) {

            if (tsLen > current.length()+1) 
                continue;
            
            Message message = Message.getInstance();
            message.load(current); 
            String timestamp = message.getTimestamp();
          
            //if(!time.isNow(timestamp))
            //    continue;
            
            String line = message.get();

            if(time.isPast(timestamp, 1))
               continue;
            
            Robot robot = new Robot();

            if(Constants.bSeek){
                Seek.getInstance().direction(line, timestamp);
            }


            if(!(line.contains("tells")|line.contains("says")|line.contains("say"))){ continue;}

            //System.out.println(timestamp + "  " + message.getText());
            //String player = message.getPlayer();
            
            System.out.println(line);

            if(message.getText().matches(Constants.CHorder +"  NEXT")){
                Constants.clr.setStartChain(true);      
            }
            
           if(message.getText().matches("^(SHM SLOW).*$")){
               System.out.println("SLOWED!!");
          //     Constants.clr.setSlowed(true);      
            }
            
            
                        
            //Constants.clr.setStartChain(false);      
            
         //   Constants.lastLine = current;


        }
       // reader.close();
    }
    
    
    
    
    public static void direction(String line, String timestamp) throws AWTException, ParseException {
        
        Robot robot = new Robot();

        if(line.contains("Your Location is ")){
                String[] coords = (line.split("Your Location is ")[1])
                        .split(", ");
                //System.out.println(coords[0] + "  " + coords[1] + "  " + coords[2]);
                coords[2] = timestamp;
                que.add(coords);
                
                

                if(que.size()>2){
                        que.remove();
                        
                        String[] c0 =que.get(0); //previous
                        String[] c1 = que.get(1);  //recent
                        
                        double a = getAngle(c0,c1);
                        if (a < 0) a += 360;
                        
                        
                        //String[] desired_location ={"2324","-990"};
                        double c = getAngle(Constants.location,c1);
                        if (c < 0) c += 360;
                        
                        double desiredAngle = c - a;
                        // Compute its acute counterpart
                        if (desiredAngle > 180)
                            desiredAngle -= 360;
                        else if (desiredAngle < -180)
                            desiredAngle += 360;
                        
                        // Advance the monster towards player by a predefined value
                        a += Math.min(3, Math.abs(desiredAngle)) * Math.signum(desiredAngle);
                        
                        // Convert this angle back in the -180 to 180 degree range
                        if (a > 180) a -= 360;
                        else if (a < -180) a += 360;
                        //monster.setAngle(a);
                        
                        
                        //
                        //double distance = getDistance(c0,c1);
                       
                            
                        //long delta_t = Time.getInstance().getDiff(c0[2], c1[2]);
                       // double rate = distance/(double)(delta_t/1000);
                        
                        
                       // System.out.println("Distance: " + distance);
                        //
                        double distance1 = getDistance(Constants.location,c1);
                        double distance2 = getDistance(Constants.location, c0);
                        double diff = distance1-distance2;
                        
                        int x = 7* (int) Math.round(Math.abs(desiredAngle/6));
       
                        
                        if(distance1<50){
                            robot.keyPress(Character.toUpperCase('S'));
                            robot.keyRelease(Character.toUpperCase('S'));
                        }
                            
   
                        
                        System.out.println("\n"+"Distance: " + distance1);
                        System.out.println("Change Angle: " + x/7);
                        System.out.println("Desired Angle: " + desiredAngle);
                        System.out.println(String.format("Distance: %f \n, "
                                + "Changle Angle: %f", c1, x/7));
                        
                       // System.out.println("Delay: " + x);
                            // Convert this angle back in the -180 to 180 degree range
                            robot.keyPress(Character.toUpperCase('1'));
                            if(desiredAngle<0){
                                robot.keyPress(Character.toUpperCase('d'));
                                robot.delay(x);
                                robot.keyRelease(Character.toUpperCase('d'));
                            } else if (desiredAngle>0) {
                                robot.keyPress(Character.toUpperCase('a'));
                                robot.delay(x);
                                robot.keyRelease(Character.toUpperCase('a'));
                            }
                  
                            //System.out.println(a + "  " + c + "  " + desiredAngle);  
                }
        }           
    }
        public static double getAngle(String[] c0, String[] c1)
        {
            double[] prev = {Double.parseDouble(c0[0]),
                            Double.parseDouble(c0[1])};
            double[] curr = {Double.parseDouble(c1[0]),
                            Double.parseDouble(c1[1])};
            double[] diff = {curr[0]-prev[0], curr[1]-prev[1]};
            //System.out.println("Vector: " + "< " + diff[1] + ", " + diff[0] + " >");
            double ang = (180/Math.PI)*Math.atan2(diff[0],diff[1]);    
            //(x > 0 ? x : (2*PI + x)) * 360 / (2*PI)
           // ang = (ang + 360) % 360;  // +360 for implementations where mod returns negative numbers
            return ang;
      
        }
        
        public static double getDistance(String[] c0, String[] c1)
        {
            double[] prev = {Double.parseDouble(c0[0]),
                            Double.parseDouble(c0[1])};
            double[] curr = {Double.parseDouble(c1[0]),
                            Double.parseDouble(c1[1])};
            double distance = Math.sqrt(Math.pow(curr[0]-prev[0],2.0)+Math.pow(curr[1]-prev[1],2.0));
            return distance;

        }

}


           /*
                        if(line.contains("Your Location is ")){
                String[] coords = (line.split("Your Location is ")[1])
                        .split(", ");
                //System.out.println(coords[0] + "  " + coords[1] + "  " + coords[2]);
                que.add(coords);
                if(que.size()>=3){
                        que.remove();
                        String[] c0 =que.get(0); //previous
                        String[] c1 = que.get(1);  //recent

                        double[] prev = {Double.parseDouble(c0[0]),
                            Double.parseDouble(c0[1])};
                        double[] curr = {Double.parseDouble(c1[0]),
                            Double.parseDouble(c1[1])};
                        double[] diff = {curr[0]-prev[0], curr[1]-prev[1]};
                        double[] c_diff = {curr[0]+1044,curr[1]-135};

                        double ang = (180/Math.PI)*Math.atan(diff[1]/diff[0]);                         
                            if (ang < 0) ang += 360;
                        double c_ang = (180/Math.PI)*Math.atan(c_diff[1]/c_diff[0]);                         
                            if (c_ang < 0) c_ang += 360;
                        
                        double d_ang = c_ang-ang;
                        
                        // Compute its acute counterpart
                        
                        //*
                        if (d_ang > 180)
                            d_ang -= 360;
                        else if (d_ang < -180)
                            d_ang += 360;
                        /*
                        // Advance the monster towards player by a predefined value
                        ang += Math.min(3, Math.abs(d_ang)) * Math.signum(d_ang);
                        
                            // Convert this angle back in the -180 to 180 degree range

                            
                            System.out.println(ang);
                            


                            //monster.setAngle(a);
                        
                            /*
                            if (ang > 180){
                                ang -= 360;
                            } else if (ang < -180){
                            ang += 360;
                            }
                            
                            // Convert this angle back in the -180 to 180 degree range

                            
                            Robot robot = new Robot();
                            robot.keyPress(Character.toUpperCase('1'));
                            if(d_ang<0){
                                robot.keyPress(Character.toUpperCase('d'));
                                robot.delay(100);
                                robot.keyRelease(Character.toUpperCase('d'));
                            } else if (d_ang>0) {
                                robot.keyPress(Character.toUpperCase('a'));
                                robot.delay(100);
                                robot.keyRelease(Character.toUpperCase('a'));
                            }
                            

                        
                            System.out.println(ang + "  " + c_ang + "  " + d_ang);
                        */
                        
                        //-1044,135