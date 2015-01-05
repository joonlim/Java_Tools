/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import static tools.FileReader.readFile;
import static tools.Serializer.deserialize;
import static tools.Serializer.serialize;

/**
 *
 * make sure any class that calls this package implments
 * <code>Serializable</code>.
 *
 * @author Joon
 */
public class Tools implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
////////////////////////////////////////////////////////////////////////////////
//        // FileReader test
//        Scanner input = new Scanner(System.in);
//
//        // example path: ./src/tools/res/sample.txt
//        System.out.println("Enter name of record file: ");
//        String fileName = input.next();
//
//        System.out.println(readFile(fileName));

////////////////////////////////////////////////////////////////////////////////
        // Serializer test
        Rectangle test = new Rectangle(5, 2);

        // example path: tools/res/testfile.obj
        serialize(test, "testfile");

        Rectangle test2 = deserialize("testfile");

        System.out.println(test2);



    }

}

class Rectangle implements Serializable {

    double height;
    double width;

    public Rectangle() {
        height = 10;
        width = 10;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public String toString() {
        return "Rectangle height: " + height + ", width: " + width;
    }

}
