/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
 private int speedUP;
 private int qualUP;
 private int fameUP;
 public Player(String name, Texture icon){
     this.name = name;
     this.money = 50;
     this.fame = 0;
     this.xPos = 0;
     this.yPos = 0;
     this.icon = icon;
     speedUP = 0;
     qualUP = 0;
     fameUP = 0;
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
 
 public Texture getIcon(){
     return this.icon;
 }



//logic stuff
public void earnMoney(int money){
    this.money+=money;
}

public void spendMoney(int money){
    this.money-=money;
}

public void move(){
    if (Gdx.input.isKeyPressed(Input.Keys.D)) {
        this.xPos++;
    }else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
        this.xPos--;
    }
    if (Gdx.input.isKeyPressed(Input.Keys.W)) {
        this.yPos++;
    }else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
        this.yPos--;
    }
    
}
public void render(SpriteBatch batch){
    batch.draw(icon, xPos, yPos);
}


public void upgrade(Upgrade u){
    if(u.getName() =="Speed"){
        this.speedUP++;
    }
    if(u.getName() =="Fame"){
        this.fameUP++;
    }
    if(u.getName() =="Quality"){
        this.qualUP++;
    }
}


}
