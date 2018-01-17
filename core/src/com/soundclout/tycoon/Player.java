/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

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
 private int dx;
 private int dy;
 private boolean facingLeft;
 private float elapsed;
 private TextureAtlas atlas;
 private AtlasRegion stand;
 private AtlasRegion standl;
 private AtlasRegion[] walk;
 private AtlasRegion[] walkl;


 public Player(String name){
     this.name = name;
     this.money = 50;
     this.fame = 0;
     this.xPos = 100;
     this.yPos = 100;
     this.icon = icon;
     speedUP = 0;
     qualUP = 0;
     fameUP = 0;
     elapsed = 0;
     this.atlas = new TextureAtlas("packed/player.atlas");
     this.stand = atlas.findRegion("standing.png");
     this.standl = this.stand;
     this.standl.flip(true, false);
     for (int i = 1; i < 4; i++) {
         walk[i] = this.atlas.findRegion("walk_"+i);
     }
     for (int i = 1; i < 4; i++) {
         AtlasRegion meme = walk[i];
         meme.flip(true, false);
         walkl[i]=meme;
     }
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
        this.xPos+=3;
        if (elapsed==4) {
            elapsed=1;
        }else{
            elapsed++;
        }
        this.facingLeft=false;
    }else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
        this.xPos-=3;
        if (elapsed==4) {
            elapsed=1;
        }else{
            elapsed++;
        }
        this.facingLeft=true;
    }else{
        elapsed=0;
    }
    
    
    
}
public void render(SpriteBatch batch){
    if(elapsed==0){
        if(facingLeft){
            batch.draw(standl, xPos, yPos);
        }else{
            batch.draw(stand, xPos, yPos);
        }
    }else if(elapsed==1){
        if(facingLeft){
            batch.draw(walkl[1], xPos, yPos);
        }else{
            batch.draw(walk[1], xPos, yPos);
        }
    }else if(elapsed==2){
        if(facingLeft){
            batch.draw(walkl[2], xPos, yPos);
        }else{
            batch.draw(walk[2], xPos, yPos);
        }
}else if(elapsed==3){
        if(facingLeft){
            batch.draw(walkl[3], xPos, yPos);
        }else{
            batch.draw(walk[3], xPos, yPos);
        }
}else if(elapsed==4){
        if(facingLeft){
            batch.draw(walkl[4], xPos, yPos);
        }else{
            batch.draw(walk[4], xPos, yPos);
        }
}
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
