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
public class Speed extends Upgrade {

    private boolean purchased;

    /**
     * *
     * speeds up songs
     *
     * @param name name of the Item
     * @param upPercent percentage it gets increased by
     * @param cost cost of the upgrade
     * @param level level of the upgrade from 1 - 10
     */
    public Speed(String name, double upPercent, double cost, int level) {
        super(name, upPercent, cost, level);
    }

    public String getName() {
        return "Speed";
    }

    public int getLevel() {
        return super.getLevel();
    }

    public double getCost() {
        return this.cost;

    }

    public double getPer() {
        return super.getPercent();
    }

    @Override
    public void Purchase() {
        purchased = true;
        //lets the next upgrade be purchaseable 
        super.getLevel();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean hasPurchased() {
        return purchased;
    }

}
