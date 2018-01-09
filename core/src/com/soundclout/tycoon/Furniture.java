/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author keyew7019
 */
public class Furniture {
    
    //create basic look of the level
    private Rectangle[] furniture;
    //use a shaperenderer to draw the basic shapes
    private ShapeRenderer shape;
    
    public Furniture(){
        // create a few rectangles to take the shape of furniture
        furniture = new Rectangle[9];
        //set the rectangles position
        furniture[0] = new Rectangle(600, 400, 100, 40);
        // initialize shaperenderer
        shape = new ShapeRenderer();
        
    }
    
    public void render(OrthographicCamera camera){
        
        shape.setProjectionMatrix(camera.combined);
        
        // tell shaperenderer that we want it as a filled shape
        shape.begin(ShapeRenderer.ShapeType.Filled);
        //go through the the furniture
        for (int i = 0; i < furniture.length; i++) {
            // draw the furniture
            shape.rect(furniture[i].x, furniture[i].y, furniture[i].width, furniture[i].height);
        }
        // tell the shaperenderer that we are done drawing the shapes
        shape.end();
    }
    
    // return the furniture from the furniture class
    public Rectangle[] getFurniture(){
        return furniture;
    }
}
