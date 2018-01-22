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
public class Fame extends Upgrade {

    private boolean purchased;

    /**
     * *
     * increase popularity gain per song
     *
     * @param name
     * @param upPercent
     * @param cost
     * @param level
     */
    public Fame(String name, double upPercent, double cost, int level) {
        super(name, upPercent, cost, level);
    }

    public String getName() {
        return "Fame";
    }

    public double getCost() {
        return this.cost;
    }

    public double getPer() {
        return super.getPercent();
    }

    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public boolean hasPurchased() {
        return purchased;
    }

    @Override
    public void Purchase() {
        purchased = true;
    }

}
