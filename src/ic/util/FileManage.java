/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Thewbacca
 */
public class FileManage {
    
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
    
}
