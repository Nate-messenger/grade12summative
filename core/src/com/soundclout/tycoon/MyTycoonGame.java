package com.soundclout.tycoon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import java.util.ArrayList;

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
    private Texture Backround;
    private ArrayList<Song> album;
    
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
        Backround = new Texture(Gdx.files.internal("333950.jpg"));
        startTime = TimeUtils.millis();
        album = new ArrayList<Song>();
        album.add(song);
        
    }

    @Override
    public void render() {
        BitmapFont font = new BitmapFont();
        
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(Backround, 0, 0);
        batch.end();
        furniture.render(camera);
        camera.update();
        String money =  new Integer(p1.getMoney()).toString();
        
        batch.begin();
            while((double)((System.currentTimeMillis() - startTime) / 1000)%10 == 5.0){
                p1.earnMoney(((int)(song.sales()))/20);
                break;
            }
        if(canBuy(p1) == true){
            font.setColor(Color.BLACK);
            font.draw(batch, "Make asong for $50 ", 400, 350);
            font.draw(batch, "Press enter to buy", 400, 300);
            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            Song a = new Song("name");
            album.add(a);
            p1.spendMoney(50);
        }}
        for (int i = 0; i < album.size(); i++) {
           Upgrade(batch,font,album.get(i)); 
        }
        font.setColor(Color.BLACK);
        font.draw(batch, "Money: "+money, 200, 600);
        //font.draw(batch, song.print(), 100, 600);
        int space = 0;
        for (int i = 0; i < album.size(); i++) {
            font.draw(batch, album.get(i).print(), 300+space, 600);
            space = space+100;
        }
        this.p1.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        Backround.dispose();
    }
    
    public void Upgrade(SpriteBatch batch,BitmapFont font, Song x){
    if(x.canUpgrade(p1) && p1.getMoney()>= x.upgradeCost()){
        font.setColor(Color.BLACK);
        font.draw(batch, "The upgrade cost is: "+(int)x.upgradeCost(), 200, 350);
        font.draw(batch, "Press space to upgrade", 200, 300);
//        System.out.println("The upgrade cost is: "+song.upgradeCost());
//        System.out.println("Do you want to upgrade?");
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
        p1.spendMoney((int)(x.upgradeCost()));
        x.upgrade();
        x.upgradeCost();
        
    }}
}
    
    public Boolean canBuy(Player x){
        if((x.getxPos() >= 580 && x.getxPos() <= 650) && (x.getyPos() >= 90 && x.getyPos() <= 110) && p1.getMoney()>= 50){
        return true;
    }else{
            return false;
        }
    }
}
