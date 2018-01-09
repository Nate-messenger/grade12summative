/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.graphics.Texture;

/**
 *
 * @author millc9988
 */
public class Player {
 private int money;
 private int xPos;
 private int yPos;
 private String name;
 private int fame;
 private Texture icon;
 public Player(String name, Texture icon){
     this.name = name;
     this.money = 50;
     this.fame = 0;
     this.xPos = 0;
     this.yPos = 0;
     this.icon = icon;
 }
//getters
 public int getMoney(){
     return this.money;
 }
 
 private int getFame(){
     return this.fame;
 }
 
 public int getxPos(){
     return this.xPos;
 }
 
 public int getyPos(){
     return this.yPos;
 }
 
 public String getName(){
     return this.name;
 }
 



//logic stuff
public void earnMoney(int money){
    this.money+=money;
}

public void spendMoney(int money){
    this.money-=money;
}

public void move(int xMove,int yMove){
    if (xMove==2) {
        this.xPos++;
    }else if (xMove==0) {
        this.xPos--;
    }else if(xMove ==1){   
    }
    if (yMove==2) {
        this.yPos++;
    }else if (yMove==0) {
        this.yPos--;
    }else if(yMove ==1){   
    }
}


}
