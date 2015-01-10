/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The FileTools.readFile() method accepts a String object for the file location
 * and returns a string with the data contained on the file.
 *
 *
 * @author Joon
 */
public class FileTools {

    public static String readFile(String fileName) throws IOException, FileNotFoundException {

        FileInputStream fis; // Object that obtains information from text file.
        InputStreamReader inStream; // Object that reads and decodes information from text file.
        BufferedReader reader; //  Object that reads the text from the InputStreamReader.
        String data = ""; // String that stores the information contained in the text file.

        try {
            fis = new FileInputStream(fileName);
            inStream = new InputStreamReader(fis);
            reader = new BufferedReader(inStream);

            String nextLine = reader.readLine();
            while (nextLine != null) {
                data = data + nextLine;
                data = data + "\n";
                nextLine = reader.readLine();
            }

            fis.close();
            inStream.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file with path: " + fileName + " exists.");
        }

        return data;

    }

    public static void deleteFile(String fileName) {

        File file = new File(fileName);
        file.delete();

//        if (file.delete()) {
//            System.out.println(file.getName() + " is deleted!");
//        } else {
//            System.out.println("Delete operation is failed.");
//        }
    }
    
    
}
