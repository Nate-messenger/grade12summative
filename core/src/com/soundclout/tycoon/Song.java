/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

/**
 * A class for our "rapper"'s song
 * @author laveh2107
 */
public class Song {
    //Private variables
    private String name;
    private double rating;
    private double minCost;
    private double minSale;
    /**
     * Constructor for song
     * @param name name of song
     */
    public Song(String name){
        this.name = name;
        this.rating = 0;
        this.minCost = this.minSale = 50;
    }
    /**
     * Getter for the rate
     * @return the rate
     */
    public double getRate(){
        return this.rating;
    }
    /**
     * Getter for the name
     * @return the name
     */
    public String getName(){
        return this.name;
    }
    /**
     * Method to increase the rate of the song, based on a star system, five points of a star 
     * Before increasing by a whole star ie: 1.0, 1.2, 1.4 .... 2.0...5.0 
     * @return the new rate of the song
     */
    public double increaseRate(){
        return this.rating + 0.2;
    }
    /**
     * Method to find how much profit the song will receive based on the current rating of the song
     * @return the integer amount of credits to increase the total credits by
     */
    public int sales(){
        //multiply the min profit by the rate the song currently has, then turn it into a integer
        return (int)(this.minSale*this.rating);
    }
    public int upgradeCost(){
        //Start with a base cost of 50 then have the copst of the upgrade be in relation to the rating
        return (int)(this.minSale*this.rating)+50;
    }
}
