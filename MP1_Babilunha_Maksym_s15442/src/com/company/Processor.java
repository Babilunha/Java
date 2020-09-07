package com.company;

import java.io.Serializable;

/**
 * complex attribute for the Smartphone class
 */
public class Processor implements Serializable {
    private String name;
    private int frequency;
    private int numberOfCores;

    public Processor(String name, int frequency, int numberOfCores) {
        nameCheck(name);
        this.name = name;
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void nameCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null!");
        }
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", frequency=" + frequency +
                ", numberOfCores=" + numberOfCores;
    }
}
