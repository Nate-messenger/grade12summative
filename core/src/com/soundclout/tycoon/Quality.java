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
public class Quality extends Upgrade {

    private boolean purchased;
   /***
    * makes songs better
    * @param name
    * @param upPercent
    * @param cost
    * @param level 
    */
    public Quality(String name, double upPercent, double cost, int level) {
        super(name, upPercent, cost, level);
    }

    
    public String getName(){
        return "Quality";
    }
    @Override
    public void Purchase() {
        
        purchased = true;
    }

    @Override
    public boolean hasPurchased() {
        return purchased;
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
}
