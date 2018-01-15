package com.soundclout.tycoon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyTycoonGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;
    private Furniture furniture;
    
    // create a player
    private Player p1;
    
    // camera 
    private OrthographicCamera camera;
    
    // game units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        
        // create player at a position
        p1 = new Player("player",img);
        
        // generate the furniture
        furniture = new Furniture();
        
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH/2, HEIGHT/2, 0);
        this.camera.update();
        
    }

    @Override
    public void render() {
        
        // update player
        p1.move();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        furniture.render(camera);
        
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        // have player draw themself
        p1.render(batch);
        
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
