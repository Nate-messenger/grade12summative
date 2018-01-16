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
    
    // camera and viewport
    private OrthographicCamera camera;
    
    // game units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        // generate the furniture
        furniture = new Furniture();
        
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH/2, HEIGHT/2, 0);
        this.camera.update();
        
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        furniture.render(camera);
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
