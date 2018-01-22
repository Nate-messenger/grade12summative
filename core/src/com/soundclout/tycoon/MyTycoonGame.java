package com.soundclout.tycoon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
    
    
    
    private Upgrade up[];
    // game units
    private final int HEIGHT = 600;
    private final int WIDTH = 800;
    
    private Song song;
    
    //create a texture so we can load in the background image
    private Texture Background;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        this.song = new Song("Song1");
        // create player at a position
        p1 = new Player("player");
        this.createUpgrades();
        // generate the furniture
        furniture = new Furniture();
        this.p1 = new Player("curtis");
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH/2, HEIGHT/2, 0);
        this.camera.update();
         Background = new Texture(Gdx.files.internal("Background.jpg"));
        
    }

    @Override
    public void render() {
        BitmapFont font = new BitmapFont();
        
        // update player
        p1.move();
        
        String money = new Integer(p1.getMoney()).toString();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        
        
        
        batch.setProjectionMatrix(camera.combined);
        //background
        batch.begin();
        batch.draw(Background, 0,0);
        batch.end();
        
        furniture.render(camera);
        camera.update();
        batch.begin();
        font.draw(batch, "Money: " + money, 200, 550);
        font.draw(batch, song.print(), 100, 550);
        song.print();
        this.p1.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
    
    public void createUpgrades() {
        this.up = new Upgrade[12];
//for loop for creating speed upgrades 
        for (int i = 0; i < 4; i++) {
            up[i] = new Speed("lean_0" + i, .045, 100 * i, i);
        }
//for creating the quality upgrades 
        for (int i = 4; i < 8; i++) {
            up[i] = new Quality("mic_0" + (i - 4), .025, 500 * (i - 4), i - 4);
        }
//for creating fame upgrades
        for (int i = 8; i < up.length; i++) {
            up[i] = new Fame("producer_0" + (i - 8), .015, 700 * (i - 8), i - 8);
        }
    }

    /**
     * *
     * finds the upgrade that we need
     *
     * @param p1 the level of upgrade we are looking for
     * @param looking the upgrade name ex.Speed
     * @return the upgrade we are looking for
     */
    public Upgrade getUpgrade(Player p1, String looking) {

        if (looking.matches("Speed")) {
            return up[p1.getSpeedL() + 1];
        }
        if (looking.matches("Quality")) {

            return up[p1.getQualityL() + 5];
        }
        if (looking.matches("Fame")) {
            return up[p1.getFameL()+9];
        }

        return up[0];
    }
}
