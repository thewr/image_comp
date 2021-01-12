/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thewbacca
 */
public class Time {
    private static Time instance;
    private Time(){
    System.out.println("Time Constructor Called");}
    public static Time getInstance(){
        if(instance==null)
            instance = new Time();
        return instance;
    }
    Date current = new Date();//dateFormat.format(datecurr));
    Date recorded;
    DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss yyyy");
    
    
    static private long diff = 0;
    
    long getMinutes(Date current, Date recorded){
        diff = current.getTime() - recorded.getTime(); 
        return diff /1000/60;
    }
    long getHours(Date current, Date recorded){
        diff = current.getTime() - recorded.getTime(); 
        return diff / (60 * 60 * 1000) % 24;
    }
    long getDays(Date current, Date recorded){
        diff = current.getTime() - recorded.getTime(); 
        return diff / (24 * 60 * 60 * 1000);      
    }
    
    public void setTime(String time) throws ParseException{
        recorded = dateFormat.parse(time);
        diff = current.getTime() - recorded.getTime(); 
    }
    
    boolean isNow(String timestamp) throws ParseException
    {
        Date recorded = dateFormat.parse(timestamp);
        Date current = new Date();
        diff = current.getTime() - recorded.getTime(); 
        //System.out.println("Recorded: " + timestamp + " Current: " + dateFormat.format(current));

        if(diff<1500)
        {
            //System.out.println(diff);
           // System.out.println("Recorded: " + timestamp + " Current: " + dateFormat.format(current));
            return true;
        }
        else
        {
            return false;
        }
    }
    
    boolean isPast(String timestamp, long mins) throws ParseException{
        Date recorded = dateFormat.parse(timestamp);
        Date current = new Date();
       
        long tMins = getMinutes(current, recorded);
        long tSeconds = tMins*60;
        if ((tSeconds > mins)){
            return true;
        }
        else{ 
            return false;      
        }
    }
    
    long getDiff(String t1, String t2) throws ParseException
    {
        Date d1 = dateFormat.parse(t1);
        Date d2 = dateFormat.parse(t2);
        Date current = new Date();
        
        return Math.abs((current.getTime()-d1.getTime()) - (current.getTime()-d2.getTime())); 
    }
}
