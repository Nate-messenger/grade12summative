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

    private Upgrade[] up;
    //Priavte variables
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
    //Start time of the game
    private long startTime;
    //Texture for backround
    private Texture Backround;
    //Resizable array of songs
    private ArrayList<Song> album;

    @Override
    public void create() {
        
        this.createUpgrades();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        // generate the furniture
        furniture = new Furniture();
        //Create a player
        this.p1 = new Player("curtis");
        this.camera = new OrthographicCamera(WIDTH, HEIGHT);
        this.camera.position.set(WIDTH / 2, HEIGHT / 2, 0);
        this.camera.update();
        //Create a song to start
        this.song = new Song("Song1");
        //Call image for backround
        Backround = new Texture(Gdx.files.internal("333950.jpg"));
        //Time the game starts
        startTime = TimeUtils.millis();
        //Resizabale array
        album = new ArrayList<Song>();
        //Add the first song to start the game with a song
        album.add(song);

    }

    @Override
    public void render() {
        BitmapFont font = new BitmapFont();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        //Batch to draw the backround
        batch.begin();
        batch.draw(Backround, 0, 0);
        batch.end();
        furniture.render(camera);
        camera.update();
        //Creae a string to read out the money
        String money = new Integer(p1.getMoney()).toString();

        batch.begin();
        //While loop to constantly give the player money every 10 seocnds
        while ((double) ((System.currentTimeMillis() - startTime) / 1000) % 10 == 5.0) {
            //Variable for the sales
            int sales = 0;
            //Add the sales of each song
            for (int i = 0; i < album.size(); i++) {
                sales = sales + (int)(album.get(i).sales());
            }
            //Add money earned by the album to the players money
            p1.earnMoney(sales/4);
            break;
        }
        //Method to buy the song
        canBuy(font, p1);
        //Upgrade the songs in the album
        for (int i = 0; i < album.size(); i++) {
            Upgrade(batch, font, album.get(i));
        }
        font.setColor(Color.BLACK);
        font.draw(batch, "Money: " + money, 200, 600);
        //Create variable for the spacing between the song info
        int space = 0;
        //Print out all the songs in the album's infomation
        for (int i = 0; i < album.size(); i++) {
            font.draw(batch, album.get(i).print(), 300 + space, 600);
            space = space + 100;
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

    /**
     * A method to see if the album can be upgraded and if so to upgrade the album, the songs in the album
     *
     * @param batch the sprite batch
     * @param font the font
     * @param x the song
     */
    public void Upgrade(SpriteBatch batch, BitmapFont font, Song x) {
        //Variabole for the cost 
        int cost = getUpgrade("Quality").cost();
        //Gather the total cost of the songs
        int sRate = 0;
                for (int i = 0; i < album.size(); i++) {
                    if (album.get(i).getRate() != 5.0 ) {
                        sRate++;
                    }else{
                        sRate--;
                    }
        }
                cost*= sRate;
                //Chack if it can be upgraded by position and the cost
        if (x.canUpgrade(p1) && p1.getMoney() >= cost) {
            font.setColor(Color.BLACK);
            font.draw(batch, "The upgrade cost is: " + cost, 200, 350);
            font.draw(batch, "Press space to upgrade", 200, 300);
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                p1.spendMoney(cost);
                //Go through each spot in the album and upgrade it
                for (int i = 0; i < album.size(); i++) {
                    album.get(i).upgrade(getUpgrade("Quality"));
                   
                }

            }
        }
    }

    /**
     * Method to see if the song can be bough and buy it
     *
     * @param x the player
     */
    public void canBuy(BitmapFont font, Player x) {
        //See if a song can be bough through position and through cost
        if ((x.getxPos() >= 580 && x.getxPos() <= 650) && (x.getyPos() >= 90 && x.getyPos() <= 110) && p1.getMoney() >= 50) {
            font.setColor(Color.BLACK);
            font.draw(batch, "Make a song for $50 ", 400, 350);
            font.draw(batch, "Press enter to buy", 400, 300);
            //When the enter key is pressed the song is bought
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                //Name the song
                Song a = new Song("name");
                //add the song to the ablum
                album.add(a);
                //Spend the money from the player
                p1.spendMoney(50);
            }
        }


}
    
    
    public void createUpgrades() {
        this.up = new Upgrade[12];
//for loop for creating speed upgrades 
        for (int i = 0; i < 4; i++) {
            up[i] = new Speed("lean_0" + i, .045, 100 * i, i);
        }
//for creating the quality upgrades 
        for (int i = 4; i < 8; i++) {
            up[i] = new Quality("mic_0" + (i - 4), .2, 500 , i - 4);
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
    public Upgrade getUpgrade( String looking) {

        if (looking.matches("Speed")) {
            return up[p1.getSpeedL() + 1];
        }
        if (looking.matches("Quality")) {
            
            return up[p1.getQualityL()+4];
            
        }
        if (looking.matches("Fame")) {
            return up[p1.getFameL()+9];
        }

        return up[0];

}
}
    