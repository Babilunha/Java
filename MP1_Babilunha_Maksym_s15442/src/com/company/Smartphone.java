package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Smartphone class represents a smartphone from the point of
 * producer of the phones and not a seller.
 */
public class Smartphone implements Serializable {

    private static List<Smartphone> extent = new ArrayList<>(); //Collection of all Smartphones (Extent)
    private static int warrantyMonths = 12; // class attribute (may be changed due to policy changes)
    private String name; //mandatory attribute
    private int screenDiagonal; //mandatory attribute (in inches)
    private int screenWidth; //mandatory attribute (in pixels)
    private int screenHeight; //mandatory attribute (in pixels)
    private Processor processor; //complex attribute
    private Integer numberOfMegapixels; //optional attribute (since some smartphones may not have a camera)
    private ArrayList<String> producedColors = new ArrayList<>(); //multi-valued attribute


    public Smartphone(String name, Processor processor, Integer numberOfMegapixels, int screenDiagonal,
                      int screenWidth, int screenHeight, String color) {
        nameNullCheck(name);
        processorNullCheck(processor);
        colorNullCheck(color);

        this.name = name;
        this.screenDiagonal = screenDiagonal;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.processor = processor;
        this.numberOfMegapixels = numberOfMegapixels;
        producedColors.add(color);

        addSmartphone(this);  //Adding to the Collection (Extent)
    }

    /**
     * class method
     *
     * @return
     */
    public static Smartphone biggestScreenPhone() {
        if (extent.isEmpty()) {
            throw new NullPointerException("No phones were created yet");
        }
        Smartphone smartphoneTemp = extent.get(0);
        for (Smartphone smartphone : extent) {
            if (smartphone.getScreenDiagonal() > smartphoneTemp.getScreenDiagonal())
                smartphoneTemp = smartphone;
        }
        return smartphoneTemp;
    }

    /**
     * Overloaded method which finds the biggest screen with PPI greater or equal than specified value.
     *
     * @param PPI
     * @return
     */
    public static Smartphone biggestScreenPhone(int PPI) {

        if (extent.isEmpty()) {
            throw new NullPointerException("No phones were created yet");
        }
        Smartphone smartphoneTemp = extent.get(0);
        for (Smartphone smartphone : extent) {
            if (smartphone.getScreenDiagonal() >= smartphoneTemp.getScreenDiagonal() && smartphone.getPPI() > PPI)
                smartphoneTemp = smartphone;
        }

        if (smartphoneTemp.getPPI() >= PPI) {
            return smartphoneTemp;
        } else {
            throw new IllegalArgumentException("there are no phones with such PPI");
        }

    }

    /**
     * printing out the extent
     */
    public static void showExtent() {
        System.out.println("Extent of the class: " + Smartphone.class.getName());

        for (Smartphone smartphone : extent) {
            System.out.println(smartphone);
        }
    }

    /**
     * writing the extent to the file
     *
     * @param stream
     * @throws IOException
     */
    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    /**
     * Reading the extent from the file
     *
     * @param stream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Smartphone>) stream.readObject();
    }

    /**
     * getter for the list returns a copy, so that the extent can't
     * be modified
     *
     * @return
     */
    public static ArrayList<Smartphone> getExtent() {
        ArrayList<Smartphone> newList = new ArrayList<>(extent);
        return newList;
    }

    /**
     * Derived attribute getter
     * (just in case, PPI is pixels per inch)
     *
     * @return
     */
    public int getPPI() {
        double diagonalSQRD = screenWidth * screenWidth + screenHeight * screenHeight;
        double diagonal = Math.sqrt(diagonalSQRD);
        return (int) (diagonal / screenDiagonal);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "name='" + name + '\'' +
                ", screenDiagonal=" + screenDiagonal +
                ", screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                ", processor=" + processor +
                ", numberOfMegapixels=" + numberOfMegapixels +
                ", producedColors=" + producedColors +
                ", warranty in months=" + warrantyMonths +
                '}';
    }

    /**
     * Adding a smartphone to the collection (extent)
     */
    private void addSmartphone(Smartphone smartphone) {
        extent.add(smartphone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        nameNullCheck(name);
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        processorNullCheck(processor);
        this.processor = processor;
    }

    public Integer getNumberOfMegapixels() {
        return numberOfMegapixels;
    }

    public void setNumberOfMegapixels(Integer numberOfMegapixels) {
        this.numberOfMegapixels = numberOfMegapixels;
    }

    public static int getWarrantyMonths() {
        return warrantyMonths;
    }

    public static void setWarrantyMonths(int warrantyMonths) {
        Smartphone.warrantyMonths = warrantyMonths;
    }

    public int getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(int screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public ArrayList<String> getProducedColors() {
        ArrayList<String> newList = new ArrayList<>(producedColors);
        return producedColors;
    }

    public void removeProducedColor(String color) {
        if (!producedColors.contains(color)) {
            throw new IllegalArgumentException("there's no such color for this smartphone!");
        }
        producedColors.remove(color);
    }

    public void addProducedColors(String color) {
        colorNullCheck(color);
        producedColors.add(color);
    }

    public void nameNullCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null!");
        }
    }

    public void processorNullCheck(Processor processor) {
        if (processor == null) {
            throw new IllegalArgumentException("processor cannot be null!");
        }
    }

    public void colorNullCheck(String color) {
        if (color == null) {
            throw new IllegalArgumentException("color cannot be null!");
        }
    }


}
