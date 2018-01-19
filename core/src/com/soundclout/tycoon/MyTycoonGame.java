package com.soundclout.tycoon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Scanner;

public class MyTycoonGame extends ApplicationAdapter {

    private SpriteBatch batch;
    private Texture img;
    private Furniture furniture;
    private Player p1;
    // camera and viewport
    private OrthographicCamera camera;
    private Song song;
    
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
        this.song = new Song("Song1");
        
    }

    @Override
    public void render() {
        BitmapFont font = new BitmapFont();
        Scanner input = new Scanner(System.in);
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        furniture.render(camera);
        camera.update();
        
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        Stirng money = (String)()
        font.draw(batch, , 100, 500);
        font.draw(batch, song.print(), 100, 600);
        this.p1.render(batch);
        song.print();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
