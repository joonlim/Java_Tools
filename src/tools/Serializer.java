/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Joon
 */
public class Serializer implements Serializable {

    /**
     * Stores the Object as a binary file onto the current working directory.
     *
     * @param filename The name of the binary file.
     *
     * @throws FileNotFoundException Indicates that the binary file being
     * searched for was not found.
     *
     * @throws IOException Indicates that an I/O operation has failed or been
     * interrupted.
     */
    public static void serialize(Object t, String fileName) throws FileNotFoundException, IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName + ".obj");
            ObjectOutputStream os = new ObjectOutputStream(fileOut);
            os.writeObject(t); // write object
            
            fileOut.close();
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println("\"" + fileName + ".obj\" not found.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File saved.");
    }

    /**
     * Retrieves an Object from a binary file in the current working directory and
     * stores it as a generic type.
     *
     * @param filename The name of the binary file.
     *
     * @return A TrafficTree containing the tree given in the binary file.
     *
     * @throws FileNotFoundException Indicates that the binary file being
     * searched for was not found.
     *
     * @throws IOException Indicates that an I/O operation has failed or been
     * interrupted.
     *
     * @throws ClassNotFoundException Indicates a specific class could not be
     * found.
     */
    public static <T> T deserialize(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        T t = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName + ".obj");
            ObjectInputStream is = new ObjectInputStream(fileIn);
            t = (T)is.readObject(); // read object
            System.out.println("Loaded file from \"" + fileName + ".obj\"");

            fileIn.close();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("\"" + fileName + ".obj\" not found. Using new file.\n");
            t = (T) new Object();
            
        } catch (IOException e) {
            e.printStackTrace();
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
        return (T) t;
    }

}
