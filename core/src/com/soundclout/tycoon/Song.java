/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

/**
 * A class for our "rapper"'s song
 *
 * @author laveh2107
 */
public class Song {
    //Private variables

    private String name;
    private double rating;
    private double minCost;
    private double minSale;
    private double time;

    /**
     * Constructor for song
     *
     * @param name name of song
     */
    public Song(String name) {
        this.name = name;
        this.rating = 0;
        this.minCost = this.minSale = 50;
        this.time = 30;
    }

    /**
     * Getter for the rate
     *
     * @return the rate
     */
    public double getRate() {
        return this.rating;
    }

    /**
     * Getter for the name
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to upgrading the rate of the song, based on a star system, five
     * points of a star Before increasing by a whole star ie: 1.0, 1.2, 1.4 ....
     * 2.0...5.0
     *
     * @return the new rate of the song
     */
    public double upgrade() {
        return this.rating + 0.2;
    }

    /**
     * Method to find how much profit the song will receive based on the current
     * rating of the song
     *
     * @return the amount of credits to increase the total credits by
     */
    public double sales() {
        //multiply the min profit by the rate the song currently has, then turn it into a integer
        return this.minSale * this.rating;
    }

    /**
     * Method to get the coast to upgrade the song, with a base cost of 50 then
     * being directly related to the rating
     *
     * @return the new upgrade cost
     */
    public double upgradeCost() {
        //Start with a base cost of 50 then have the copst of the upgrade be in relation to the rating
        return (this.minSale * this.rating) + 50;
    }

    /**
     * Method to find the upgrade time of the song, with the lowest time being 0;
     * 
     * @param percent the percentage from the pharm.
     * @return and integer time it takes, in seconds
     */
    public double upgradeTime(double percent) {
        //Check if the value will be greater than zero
        if (2 * (Math.sqrt(percent) - 15) > 0) {
            //Return the time based on the percent
            return Math.round(2 * (Math.sqrt(percent) - 15));
        } else {
            //Return a zero always when the time isn't less than zero
            return 0;
        }
    }
}