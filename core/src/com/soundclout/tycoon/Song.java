/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    private Texture image;

    /**
     * Constructor for song, with a name, and a min cost/sale both equal 50
     * credits, a base rating of one star, a base time for upgrade of 30sec
     *
     * @param name name of song
     */
    public Song(String name) {
        this.name = name;
        this.rating = 1;
        this.minCost = this.minSale = 50;
        this.time = 30;
        image = new Texture("Coda.jpg");
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
     * Method to find the upgrade time of the song, with the lowest time being 0
     *
     * @param percent the percentage from the speed.
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

    /**
     * Method to check if the player on the chair to be able to upgrade the
     * song, based on the player coordinates
     *
     * @param x The player being passed in to access the x and y coordinates of
     * the rapper
     * @return A boolean to send to the main game
     */
    public boolean canUpgrade(Player x) {
        //Check if the player is inbetween the x coordinate limits of the chair
        //Check if the character is on the same y coordinate of the chair, give of take 10 y positions just incase the of a lag
        if ((x.getxPos() >= 580 && x.getxPos() <= 650) && (x.getyPos() >= 90 && x.getyPos() <= 110)) {
            //When the chaeracter meets the requirements, it can upgrade
            return true;
        }
        //The player doesn't meet the requirement of the chair
        return false;
    }

    /**
     * Method to print out a record to show that a song has been purchased
     *
     * @param batch a sprite batch for the textures
     */
    public void render(SpriteBatch batch) {
        batch.draw(image, 200, 500);
    }
}