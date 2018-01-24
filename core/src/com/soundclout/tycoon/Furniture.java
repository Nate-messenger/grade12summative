/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soundclout.tycoon;

import com.badlogic.gdx.graphics.Color;
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

    public Furniture() {
        // initialize shaperenderer
        shape = new ShapeRenderer();
        // create a few rectangles to take the shape of furniture
        furniture = new Rectangle[9];
        //set the rectangles position
        //Set the colour
        shape.setColor(Color.BLACK);
        //create the bed
        furniture[0] = new Rectangle(270, 150, 180, 35);
        furniture[1] = new Rectangle(420, 100, 30, 80);
        furniture[2] = new Rectangle(240, 100, 30, 145);
        // create the door
        furniture[3] = new Rectangle(0, 100, 90, 230);
        //create computer chair
        furniture[4] = new Rectangle(550, 160, 110, 20);
        furniture[5] = new Rectangle(550, 100, 20, 160);
        furniture[6] = new Rectangle(640, 100, 20, 80);
        //create music making equipment
        furniture[7] = new Rectangle(720, 200, 60, 60);
        furniture[8] = new Rectangle(680, 100, 100, 100);
        //wallpaper if needed

        

    }

    public void render(OrthographicCamera camera) {

        shape.setProjectionMatrix(camera.combined);

        // tell shaperenderer that we want it as a filled shape
        shape.begin(ShapeRenderer.ShapeType.Filled);
        //go through the the furniture
        for (int i = 0; i < furniture.length; i++) {
            // draw the furniture
            shape.rect(furniture[i].x, furniture[i].y, furniture[i].width, furniture[i].height);
        }
        // tell the shaperenderer to stop drawing the shapes
        shape.end();
    }

    // return the furniture from the furniture class
    public Rectangle[] getFurniture() {
        return furniture;
    }
}

