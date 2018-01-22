/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

/**
 *
 * @author nate
 */
public abstract class Upgrade {

    private double upPercent;
    private String name;
    public double cost;
    private int level;

    public Upgrade(String name, double upPercent, double cost, int level) {
        this.cost = cost;
        this.name = name;
        this.upPercent = upPercent;
        this.level = level;
    }

    public double cost() {
        return this.cost;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    /**
     * *
     *
     * @return the percent that the upgrade increases the stat by
     */
    public double getPercent() {
        return upPercent;
    }

    public String toString() {
        String output = "--------" + "\n";
        output += this.name + "\n";
        output += this.upPercent + "\n";
        output += this.cost + "\n";
        output += this.level + "\n";
        return output;
    }

    /**
     * *
     * takes away money and says the upgrade has been purchased
     */
    public abstract void Purchase();

    public abstract boolean hasPurchased();

}
