package com.soundclout.tycoon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

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
    private double rating;
    private long startTime;
    
    @Override
    public void create() {;
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        // generate the furniture
        furniture = new Furniture();
        this.p1 = new Player("curtis");
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH/2, HEIGHT/2, 0);
        this.camera.update();
        this.song = new Song("Song1");
        rating = song.getRate();
        startTime = TimeUtils.millis();
        
        
    }

    @Override
    public void render() {
        BitmapFont font = new BitmapFont();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
int[] T  =  new int[1000000];
        for (int i = 0; i < T.length; i++) {
            T[i] = i+1;
        }
        furniture.render(camera);
        camera.update();
        String money =  new Integer(p1.getMoney()).toString();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
            while((double)((System.currentTimeMillis() - startTime) / 1000)%10 == 5.0){
                p1.earnMoney((int)song.sales());
                break;
            }
        Upgrade();
        font.draw(batch, "Money: "+money, 200, 600);
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
    
    public void Upgrade(){
    if(song.canUpgrade(p1) && p1.getMoney()>= song.upgradeCost()){
        System.out.println("The upgrade cost is: "+song.upgradeCost());
        System.out.println("Do you want to update");
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
        p1.spendMoney((int)(song.upgradeCost()));
        song.upgrade();
        song.upgradeCost();
    }}
}
}
