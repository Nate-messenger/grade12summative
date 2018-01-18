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

    public Furniture() {
        // create a few rectangles to take the shape of furniture
        furniture = new Rectangle[10];
        //set the rectangles position
        //create the bed
        furniture[0] = new Rectangle(260, 130, 140, 20);
        furniture[1] = new Rectangle(380, 100, 20, 50);
        furniture[2] = new Rectangle(240, 100, 20, 90);
        // create the door
        furniture[3] = new Rectangle(30, 100, 60, 150);
        //create computer chair
        furniture[4] = new Rectangle(580, 140, 15, 70);
        furniture[5] = new Rectangle(580, 140, 70, 15);
        furniture[6] = new Rectangle(580, 100, 15, 40);
        furniture[7] = new Rectangle(635, 100, 15, 40);
        //create music making equipment
        furniture[8] = new Rectangle(720, 180, 40, 40);
        furniture[9] = new Rectangle(680, 100, 80, 80);
        //wallpaper if needed

        // initialize shaperenderer
        shape = new ShapeRenderer();

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
