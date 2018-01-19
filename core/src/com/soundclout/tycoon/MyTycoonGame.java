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
    private Player p1;
    // camera and viewport
    private OrthographicCamera camera;
    
    //create a texture so we can load in the background image
    private Texture Background;
    
    // game units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        
        // create player at a position
        p1 = new Player("player");
        
        // generate the furniture
        furniture = new Furniture();
        this.p1 = new Player("curtis");
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH/2, HEIGHT/2, 0);
        this.camera.update();
        //File from assets folder
        Background = new Texture(Gdx.files.internal("Background.jpg"));

    }

    @Override
    public void render() {
        
        // update player
        p1.move();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        //render in the background
        batch.draw(Background,0,0);
        batch.end();
        
        //render in the furniture
        furniture.render(camera);
        camera.update();
        
        batch.begin();
        //render in the player
        this.p1.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        Background.dispose();
    }
}
