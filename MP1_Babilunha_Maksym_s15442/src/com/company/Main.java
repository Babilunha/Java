package com.company;

import java.io.*;

public class Main {


    public static void main(String[] args) {

        /*
        some of the elements of the MP1 are not present in the main,
        because they did not require a demonstration.

        Optional attribute is numberOfMegapixels in Smartphone
        Class attribute is warrantyMonths in Smartphone
        Override: toString for Smartphone and Processor
         */


        //Complex attribute
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Processor processor1 = new Processor("A1", 500, 1);


        //Class Extent
        System.out.println("\n" + "//Class Extent" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Smartphone smartphone1 = new Smartphone("phone1", processor1, 1, 4, 480, 720, "black"); //object creation
        Smartphone smartphone2 = new Smartphone("phone2", processor1, null, 4, 480, 720, "black"); //object creation

        Smartphone.showExtent();


        //Extent - persistency (Using serialization)
        System.out.println("\n" + "//Extent - persistency (Using serialization)" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final String extentFileDirectory = "./extentFile.ser";

        Smartphone smartphone3 = new Smartphone("phone3", processor1, 1, 4, 480, 720, "black"); //object creation
        Smartphone smartphone4 = new Smartphone("phone4", processor1, 1, 5, 480, 720, "black"); //object creation

        //Serialization
        try {
            // Saving an extant to the file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(extentFileDirectory));
            Smartphone.writeExtent(out);
            out.close();

            // Reading an extent from the File
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(extentFileDirectory));
            Smartphone.readExtent(in);
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Smartphone.showExtent();


        //Multi-valued attribute
        System.out.println("\n" + "//Multi-valued attribute" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        smartphone1.addProducedColors("white"); //adding new color to the list
        System.out.println(smartphone1);
        smartphone1.removeProducedColor("white"); // removing the color from the list
        System.out.println(smartphone1);


        //Derived attribute
        System.out.println("\n" + "//Derived attribute" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("PPI is: " + smartphone1.getPPI());


        //Class method
        System.out.println("\n" + "//Class method" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(Smartphone.biggestScreenPhone());
        //then creating a new smartphone with a larger screen
        Smartphone smartphone5 = new Smartphone("phone5", processor1, 1, 6, 1920, 1080, "black"); //object creation
        //and now we the biggest display is on phone5
        System.out.println(Smartphone.biggestScreenPhone());


        //Overload
        System.out.println("\n" + "//Overload" + "\n");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println(Smartphone.biggestScreenPhone(300));
        //then creating a new smartphone with a larger screen, but lower PPI
        Smartphone smartphone6 = new Smartphone("phone5", processor1, 1, 7, 480, 720, "black"); //object creation
        //and now we the biggest display is still phone5, even tho phone6 has larger display
        System.out.println(Smartphone.biggestScreenPhone(300));


    }


}
