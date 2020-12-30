package ic.util;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.BufferedReader;
import javax.swing.JCheckBox;



public final class Constants {
    private Constants(){
        throw new AssertionError();
    }
    
    public static Cleric clr = Cleric.getInstance();
    public static Bard brd = Bard.getInstance();
    public static String lastLine = ""; 
    public static boolean bSeek = false;
    public static String[] location = {"0","0","0"};
    public static String charname = "Leuke";
    public static String filename = "K:\\p99\\EQLITE\\Logs\\eqlog_"+ Constants.charname +"_project1999.txt";
    public static BufferedReader reader;
    public static Rectangle capture = new Rectangle(77,93,110,12);
    public static final Color colorSELECTED = Color.decode("#3bb6f4");
    public static final Color colorNOTSELECTED = Color.decode("#f2f2fa");
    public static String CHorder = "";
    public static JCheckBox jSlowed;
    public static double sliderval = 70.0;

    public final static void updateFilename(){
        filename = "K:\\p99\\EQLITE\\Logs\\eqlog_"+ Constants.charname +"_project1999.txt";
    }

    
}
