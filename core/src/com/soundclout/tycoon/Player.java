/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

/**
 *
 * @author millc9988
 */
public class Player {
    //storing startup stuff
 private int money;
 private int xPos;
 private int yPos;
 private String name;
 private int fame;
 //storing upgrades
 private int speedUP;
 private int qualUP;
 private int fameUP;
 //animation things
 private boolean facingLeft;
 private float elapsed;
 //storing the frames for animations
 private TextureAtlas atlas;
 private AtlasRegion stand;
 private AtlasRegion standl;
 private AtlasRegion[] walk;
 private AtlasRegion[] walkl;


 public Player(String name){
     //filling the initial variables
     facingLeft = false;
     this.name = name;
     this.money = 50;
     this.fame = 0;
     this.xPos = 100;
     this.yPos = 99;
     speedUP = 0;
     qualUP = 0;
     fameUP = 0;
     elapsed = 0;
     
     //setting up the animation textures
     this.atlas = new TextureAtlas("packed/player.atlas");
     this.stand = atlas.findRegion("standing");
     AtlasRegion hold = this.stand;
     hold.flip(true, false);
     this.standl = hold;
     AtlasRegion[] arrayHold = new AtlasRegion[5];
     for (int i = 1; i <= 4; i++) {
         System.out.println(i);
         arrayHold[i] = this.atlas.findRegion("walk",i);
     }
     
     this.walk = arrayHold;
     
     for (int i = 1; i <= 4; i++) {
         System.out.println(i);
         arrayHold[i].flip(true, false);
     }
     walkl = arrayHold;
     stand.flip(true, false);
     walk[1].flip(true, false);
     walk[2].flip(true, false);
     walk[3].flip(true, false);
     walk[4].flip(true, false);
     //animation things finished
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
//moving left if a is pressed and right if d is pressed and instructing the animation accordingly
public void move(){
    if (Gdx.input.isKeyPressed(Input.Keys.D)&&this.xPos<720) {
        this.xPos+=4;
        if (elapsed==40) {
            elapsed=1;
        }else{
            elapsed++;
        }
        this.facingLeft=false;

    }else if (Gdx.input.isKeyPressed(Input.Keys.A)&&this.xPos>0) {
        this.xPos-=4;
        if (elapsed==40) {
            elapsed=1;
        }else{
            elapsed++;
        }
        this.facingLeft=true;

    }else{
        elapsed=0;
    }
    
    
    
}
//animations!
public void render(SpriteBatch batch){
    move();
    
    //if they arent moving stand
    if(elapsed==0){
        if(facingLeft){
            stand.flip(true, false);
            batch.draw(standl, xPos, yPos);
            stand.flip(true, false);
        }else{
            batch.draw(stand, xPos, yPos);
        }
        //drawing different run animations 
    }else if(elapsed>=1&&elapsed<=10){
        if(facingLeft){
            walk[1].flip(true, false);
            batch.draw(walkl[1], xPos, yPos);
            walk[1].flip(true, false);
        }else{
            batch.draw(walk[1], xPos, yPos);
        }
    }else if(elapsed>=11&&elapsed<=20){
        if(facingLeft){
            walk[2].flip(true, false);
            batch.draw(walkl[2], xPos, yPos);
            walk[2].flip(true, false);
        }else{
            batch.draw(walk[2], xPos, yPos);
        }
}else if(elapsed>=21&&elapsed<=30){
        if(facingLeft){
            stand.flip(true, false);
            batch.draw(standl, xPos, yPos);
            stand.flip(true, false);
        }else{
            batch.draw(stand, xPos, yPos);
        }
}else if(elapsed>=31&&elapsed<=40){
        if(facingLeft){
            walk[3].flip(true, false);
            batch.draw(walkl[3], xPos, yPos);
            walk[3].flip(true, false);
        }else{
            batch.draw(walk[3], xPos, yPos);
        }
}
}

//letting the upgrades be usable
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
public int getSpeedL(){
    return this.speedUP;
}
public int getFameL(){
    return this.fameUP;
}
public int getQualityL(){
    return this.qualUP;
}

}



