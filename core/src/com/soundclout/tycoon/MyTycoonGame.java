package com.soundclout.tycoon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyTycoonGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;
    private Furniture furniture;
    private Player p1;
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
        this.p1 = new Player("curtis");
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH/2, HEIGHT/2, 0);
        this.camera.update();
        
    }

    @Override
    public void render() {
        BitmapFont font = new BitmapFont();
        if((p1.getxPos() >= 580 && p1.getxPos() <= 650) && (p1.getyPos() >= 90 && p1.getyPos() <= 110)){
            font.draw(batch, "DO U WANT TO BUY A SONG?", WIDTH/2, HEIGHT/2);
            if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
               
                font.draw(batch, "Want do you want your name to be called", WIDTH/2, HEIGHT/2);
                
                Song song = new Song(name);
            }
        }
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        furniture.render(camera);
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        this.p1.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
