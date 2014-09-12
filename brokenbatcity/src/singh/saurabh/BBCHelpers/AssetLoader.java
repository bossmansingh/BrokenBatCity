package singh.saurabh.BBCHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {
	public static Texture texture, texture_1, logoTexture, batman_dead,
							b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18,
							bat1, bat2, bat3, bat4, bat5, bat6, bat7, l1, bg1,
							frame1, frame2, frame3, frame4, frame5,
							frame6, frame7, frame8, frame9, frame10,
							frame11, frame12, frame13, frame14, frame15,
							frame16, frame17, frame18, frame19, frame20,
							frame21, frame22, frame23, frame24, frame25,
							frame26, frame27, frame28, frame29, frame30,
							frame31, frame32, frame33, frame34, frame35,
							frame36, frame37, frame38, frame39, frame40,
							frame41, frame42, frame43, frame44, frame45,
							frame46;
	
    public static TextureRegion logo, playButtonUp, playButtonDown, ready, retry,
    							bgframe1, bgframe2, bgframe3, bgframe4, bgframe5,
    							bgframe6, bgframe7, bgframe8, bgframe9, bgframe10,
    							bgframe11, bgframe12, bgframe13, bgframe14, bgframe15,
    							bgframe16, bgframe17, bgframe18, bgframe19, bgframe20,
    							bgframe21, bgframe22, bgframe23, bgframe24, bgframe25,
    							bgframe26, bgframe27, bgframe28, bgframe29, bgframe30,
    							bgframe31, bgframe32, bgframe33, bgframe34, bgframe35,
    							bgframe36, bgframe37, bgframe38, bgframe39, bgframe40,
    							gameOver, scoreboard, star, noStar, highScore, grass;

    public static Animation batmanAnimation, bgAnimation, batAnimation;
    public static TextureRegion batman_dead1, batman1, batman2, batman3, batman4, batman5, batman6, batman7, batman8, batman9, batman10, 
    							batman11, batman12, batman13, batman14, batman15, batman16, batman17, batman18,
    							bat11, bat22, bat33, bat44, bat55, bat66, bat77;

    public static TextureRegion building_top_Up, building_top_Down, building_bar;
    
    public static Sound dead, flap, coin, fall, lightning;
    
    public static BitmapFont font, shadow, whiteFont;
    
    private static Preferences prefs;

    public static void load() {
    	
    	logoTexture = new Texture(Gdx.files.internal("data/splash_screen.jpg"));
        logoTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        texture = new Texture(Gdx.files.internal("data/texture.png"));		
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        texture_1 = new Texture(Gdx.files.internal("data/texture_1.png"));		
        texture_1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        l1 = new Texture(Gdx.files.internal("data/logo.png"));		
        l1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        logo = new TextureRegion(l1);
        logo.flip(false, true);
        
        playButtonDown = new TextureRegion(texture_1, 29, 83, 29, 16);
		playButtonUp = new TextureRegion(texture_1, 0, 83, 29, 16);
		playButtonUp.flip(false, true);
		playButtonDown.flip(false, true);

		ready = new TextureRegion(texture_1, 59, 83, 34, 7);
		ready.flip(false, true);

		retry = new TextureRegion(texture_1, 59, 110, 33, 7);
		retry.flip(false, true);
		
		gameOver = new TextureRegion(texture_1, 59, 92, 46, 7);
		gameOver.flip(false, true);

		scoreboard = new TextureRegion(texture_1, 111, 83, 97, 37);
		scoreboard.flip(false, true);

		star = new TextureRegion(texture_1, 152, 70, 10, 10);
		noStar = new TextureRegion(texture_1, 165, 70, 10, 10);

		star.flip(false, true);
		noStar.flip(false, true);

		highScore = new TextureRegion(texture_1, 59, 101, 48, 7);
		highScore.flip(false, true);

		//bg frames
		frame1 = new Texture(Gdx.files.internal("data/frames/1.jpg"));
		frame1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe1 = new TextureRegion(frame1);
        bgframe1.flip(false, true);
        
        frame2 = new Texture(Gdx.files.internal("data/frames/2.jpg"));
		frame2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe2 = new TextureRegion(frame2);
        bgframe2.flip(false, true);
        
        frame3 = new Texture(Gdx.files.internal("data/frames/3.jpg"));
		frame3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe3 = new TextureRegion(frame3);
        bgframe3.flip(false, true);
        
        frame4 = new Texture(Gdx.files.internal("data/frames/4.jpg"));
		frame4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe4 = new TextureRegion(frame4);
        bgframe4.flip(false, true);
        
        frame5 = new Texture(Gdx.files.internal("data/frames/5.jpg"));
		frame5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe5 = new TextureRegion(frame5);
        bgframe5.flip(false, true);
        
        frame6 = new Texture(Gdx.files.internal("data/frames/6.jpg"));
		frame6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe6 = new TextureRegion(frame6);
        bgframe6.flip(false, true);
        
        frame7 = new Texture(Gdx.files.internal("data/frames/7.jpg"));
		frame7.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe7 = new TextureRegion(frame7);
        bgframe7.flip(false, true);
        
        frame8 = new Texture(Gdx.files.internal("data/frames/8.jpg"));
		frame8.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe8 = new TextureRegion(frame8);
        bgframe8.flip(false, true);
        
        frame9 = new Texture(Gdx.files.internal("data/frames/9.jpg"));
		frame9.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe9 = new TextureRegion(frame9);
        bgframe9.flip(false, true);
        
        frame10 = new Texture(Gdx.files.internal("data/frames/10.jpg"));
		frame10.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe10 = new TextureRegion(frame10);
        bgframe10.flip(false, true);
        
        frame11 = new Texture(Gdx.files.internal("data/frames/11.jpg"));
		frame11.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe11 = new TextureRegion(frame11);
        bgframe11.flip(false, true);
        
        frame12 = new Texture(Gdx.files.internal("data/frames/12.jpg"));
		frame12.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe12 = new TextureRegion(frame12);
        bgframe12.flip(false, true);
        
        frame13 = new Texture(Gdx.files.internal("data/frames/13.jpg"));
		frame13.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe13 = new TextureRegion(frame13);
        bgframe13.flip(false, true);
        
        frame14 = new Texture(Gdx.files.internal("data/frames/14.jpg"));
		frame14.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe14 = new TextureRegion(frame14);
        bgframe14.flip(false, true);
        
        frame15 = new Texture(Gdx.files.internal("data/frames/15.jpg"));
		frame15.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe15 = new TextureRegion(frame15);
        bgframe15.flip(false, true);
        
        frame16 = new Texture(Gdx.files.internal("data/frames/16.jpg"));
		frame16.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe16 = new TextureRegion(frame16);
        bgframe16.flip(false, true);
        
        frame17 = new Texture(Gdx.files.internal("data/frames/17.jpg"));
		frame17.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe17 = new TextureRegion(frame17);
        bgframe17.flip(false, true);
        
        frame18 = new Texture(Gdx.files.internal("data/frames/18.jpg"));
		frame18.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe18 = new TextureRegion(frame18);
        bgframe18.flip(false, true);
        
        frame19 = new Texture(Gdx.files.internal("data/frames/19.jpg"));
		frame19.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe19 = new TextureRegion(frame19);
        bgframe19.flip(false, true);

        frame20 = new Texture(Gdx.files.internal("data/frames/20.jpg"));
		frame20.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe20 = new TextureRegion(frame20);
        bgframe20.flip(false, true);
        
        frame21 = new Texture(Gdx.files.internal("data/frames/21.jpg"));
		frame21.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe21 = new TextureRegion(frame21);
        bgframe21.flip(false, true);
        
        frame22 = new Texture(Gdx.files.internal("data/frames/22.jpg"));
		frame22.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe22 = new TextureRegion(frame22);
        bgframe22.flip(false, true);
        
        frame23 = new Texture(Gdx.files.internal("data/frames/23.jpg"));
		frame23.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe23 = new TextureRegion(frame23);
        bgframe23.flip(false, true);
        
        frame24 = new Texture(Gdx.files.internal("data/frames/24.jpg"));
		frame24.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe24 = new TextureRegion(frame24);
        bgframe24.flip(false, true);
        
        frame25 = new Texture(Gdx.files.internal("data/frames/25.jpg"));
		frame25.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe25 = new TextureRegion(frame25);
        bgframe25.flip(false, true);
        
        frame26 = new Texture(Gdx.files.internal("data/frames/16.jpg"));
		frame26.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe26 = new TextureRegion(frame16);
        bgframe26.flip(false, true);
        
        frame27 = new Texture(Gdx.files.internal("data/frames/27.jpg"));
		frame27.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe27 = new TextureRegion(frame27);
        bgframe27.flip(false, true);
        
        frame28 = new Texture(Gdx.files.internal("data/frames/28.jpg"));
		frame28.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe28 = new TextureRegion(frame28);
        bgframe28.flip(false, true);
        
        frame29 = new Texture(Gdx.files.internal("data/frames/29.jpg"));
		frame29.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe29 = new TextureRegion(frame29);
        bgframe29.flip(false, true);

        frame30 = new Texture(Gdx.files.internal("data/frames/30.jpg"));
		frame30.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe30 = new TextureRegion(frame30);
        bgframe30.flip(false, true);
        
        frame31 = new Texture(Gdx.files.internal("data/frames/31.jpg"));
		frame31.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe31 = new TextureRegion(frame31);
        bgframe31.flip(false, true);
        
        frame32 = new Texture(Gdx.files.internal("data/frames/32.jpg"));
		frame32.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe32 = new TextureRegion(frame32);
        bgframe32.flip(false, true);
        
        frame33 = new Texture(Gdx.files.internal("data/frames/33.jpg"));
		frame33.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe33 = new TextureRegion(frame33);
        bgframe33.flip(false, true);
        
        frame34 = new Texture(Gdx.files.internal("data/frames/34.jpg"));
		frame34.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe34 = new TextureRegion(frame34);
        bgframe34.flip(false, true);
        
        frame35 = new Texture(Gdx.files.internal("data/frames/35.jpg"));
		frame35.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe35 = new TextureRegion(frame35);
        bgframe35.flip(false, true);
        
        frame36 = new Texture(Gdx.files.internal("data/frames/36.jpg"));
		frame36.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe36 = new TextureRegion(frame36);
        bgframe36.flip(false, true);
        
        frame37 = new Texture(Gdx.files.internal("data/frames/37.jpg"));
		frame37.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe37 = new TextureRegion(frame37);
        bgframe37.flip(false, true);
        
        frame38 = new Texture(Gdx.files.internal("data/frames/38.jpg"));
		frame38.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe38 = new TextureRegion(frame38);
        bgframe38.flip(false, true);
        
        frame39 = new Texture(Gdx.files.internal("data/frames/39.jpg"));
		frame39.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe39 = new TextureRegion(frame39);
        bgframe39.flip(false, true);

        frame40 = new Texture(Gdx.files.internal("data/frames/40.jpg"));
		frame40.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        bgframe40 = new TextureRegion(frame40);
        bgframe40.flip(false, true);
        

        
        //frame end
        TextureRegion[] bgs = { bgframe1, bgframe2, bgframe3, bgframe4, bgframe5,
				bgframe6, bgframe7, bgframe8, bgframe9, bgframe10,
				bgframe11, bgframe12, bgframe13, bgframe14, bgframe15,
				bgframe16, bgframe17, bgframe18, bgframe19, bgframe20,
				bgframe21, bgframe22, bgframe23, bgframe24, bgframe25,
				bgframe26, bgframe27, bgframe28, bgframe29, bgframe30,
				bgframe31, bgframe32, bgframe33, bgframe34, bgframe35,
				bgframe36, bgframe37, bgframe38, bgframe39, bgframe40
				 };
        bgAnimation = new Animation(0.09f, bgs);
        bgAnimation.setPlayMode(Animation.LOOP);
        
        grass = new TextureRegion(texture, 0, 392, 997, 19);
        grass.flip(false, true);
        
        b1 = new Texture(Gdx.files.internal("data/batman_running/batman_running_1.png"));
        b1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b2 = new Texture(Gdx.files.internal("data/batman_running/batman_running_2.png"));
        b2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b3 = new Texture(Gdx.files.internal("data/batman_running/batman_running_3.png"));
        b3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b4 = new Texture(Gdx.files.internal("data/batman_running/batman_running_4.png"));
        b4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        b5 = new Texture(Gdx.files.internal("data/batman_running/batman_running_5.png"));
        b5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b6 = new Texture(Gdx.files.internal("data/batman_running/batman_running_6.png"));
        b6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b7 = new Texture(Gdx.files.internal("data/batman_running/batman_running_7.png"));
        b7.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        b8 = new Texture(Gdx.files.internal("data/batman_running/batman_running_8.png"));
        b8.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b9 = new Texture(Gdx.files.internal("data/batman_running/batman_running_9.png"));
        b9.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b10 = new Texture(Gdx.files.internal("data/batman_running/batman_running_10.png"));
        b10.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b11 = new Texture(Gdx.files.internal("data/batman_running/batman_running_11.png"));
        b11.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b12 = new Texture(Gdx.files.internal("data/batman_running/batman_running_12.png"));
        b12.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b13 = new Texture(Gdx.files.internal("data/batman_running/batman_running_13.png"));
        b13.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b14 = new Texture(Gdx.files.internal("data/batman_running/batman_running_14.png"));
        b14.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b15 = new Texture(Gdx.files.internal("data/batman_running/batman_running_15.png"));
        b15.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b16 = new Texture(Gdx.files.internal("data/batman_running/batman_running_16.png"));
        b16.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b17 = new Texture(Gdx.files.internal("data/batman_running/batman_running_17.png"));
        b17.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        b18 = new Texture(Gdx.files.internal("data/batman_running/batman_running_18.png"));
        b18.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        batman1 = new TextureRegion(b1);
        batman1.flip(false, true);
        
        batman2 = new TextureRegion(b2);
        batman2.flip(false, true);
        
        batman3 = new TextureRegion(b3);
        batman3.flip(false, true);
        
        batman4 = new TextureRegion(b4);
        batman4.flip(false, true);
        
        batman5 = new TextureRegion(b5);
        batman5.flip(false, true);
        
        batman6 = new TextureRegion(b6);
        batman6.flip(false, true);
        
        batman7 = new TextureRegion(b7);
        batman7.flip(false, true);
        
        batman8 = new TextureRegion(b8);
        batman8.flip(false, true);
        
        batman9 = new TextureRegion(b9);
        batman9.flip(false, true);
        
        batman10 = new TextureRegion(b10);
        batman10.flip(false, true);
        
        batman11 = new TextureRegion(b11);
        batman11.flip(false, true);
        
        batman12 = new TextureRegion(b12);
        batman12.flip(false, true);
        
        batman13 = new TextureRegion(b13);
        batman13.flip(false, true);
        
        batman14 = new TextureRegion(b14);
        batman14.flip(false, true);
        
        batman15 = new TextureRegion(b15);
        batman15.flip(false, true);
        
        batman16 = new TextureRegion(b16);
        batman16.flip(false, true);
        
        batman17 = new TextureRegion(b17);
        batman17.flip(false, true);
        
        batman18 = new TextureRegion(b18);
        batman18.flip(false, true);
        
        batman_dead = new Texture(Gdx.files.internal("data/batman_dead.png"));
        batman_dead.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        batman_dead1 = new TextureRegion(batman_dead);
        batman_dead1.flip(false, true);
        
        //bat loader
        bat1 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_1.png"));
        bat1.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        bat2 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_2.png"));
        bat2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        bat3 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_3.png"));
        bat3.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        bat4 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_4.png"));
        bat4.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

        bat5 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_5.png"));
        bat5.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        bat6 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_6.png"));
        bat6.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        bat7 = new Texture(Gdx.files.internal("data/bat_flying/Bat_flying_7.png"));
        bat7.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        
        bat11 = new TextureRegion(bat1);
        bat11.flip(false, true);
        
        bat22 = new TextureRegion(bat2);
        bat22.flip(false, true);
        
        bat33 = new TextureRegion(bat3);
        bat33.flip(false, true);
        
        bat44 = new TextureRegion(bat4);
        bat44.flip(false, true);
        
        bat55 = new TextureRegion(bat5);
        bat55.flip(false, true);
        
        bat66 = new TextureRegion(bat6);
        bat66.flip(false, true);
        
        bat77 = new TextureRegion(bat7);
        bat77.flip(false, true);
        
        
        TextureRegion[] batmans = { batman1, batman2, batman3, batman4, batman5, batman6, batman7, batman8, batman9, batman10, 
				batman11, batman12, batman13, batman14, batman15, batman16, batman17, batman18 };
        batmanAnimation = new Animation(0.04f, batmans);
        batmanAnimation.setPlayMode(Animation.LOOP);
        
        TextureRegion[] bats = { bat11, bat22, bat33, bat44, bat55, bat66 };
        batAnimation = new Animation(0.09f, bats);
        batAnimation.setPlayMode(Animation.LOOP);

        building_top_Up = new TextureRegion(texture_1, 192, 0, 24, 14);
        // Create by flipping existing skullUp
        building_top_Down = new TextureRegion(building_top_Up);
        building_top_Down.flip(false, true);

        building_bar = new TextureRegion(texture_1, 136, 16, 22, 3);
        building_bar.flip(false, true);
        
        dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
        flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
        coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
        fall = Gdx.audio.newSound(Gdx.files.internal("data/fall.wav"));
        lightning = Gdx.audio.newSound(Gdx.files.internal("data/lightning.wav"));
        
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.setScale(1, -1);
        font.setColor(Color.RED);
        
        whiteFont = new BitmapFont(Gdx.files.internal("data/whitetext.fnt"));
		whiteFont.setScale(1f, -1f);

		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.setScale(1f, -1f);
		
        // Create (or retrieve existing) preferences file
     		prefs = Gdx.app.getPreferences("Broken BatCity");

     		if (!prefs.contains("highScore")) {
     			prefs.putInteger("highScore", 0);
     		}

    }
    
    public static void setHighScore(int val) {
		prefs.putInteger("highScore", val);
		prefs.flush();
	}

	public static int getHighScore() {
		return prefs.getInteger("highScore");
	}
	
    public static void dispose() {
        // We must dispose of the texture when we are finished.
        texture.dispose();
        dead.dispose();
        flap.dispose();
        coin.dispose();
        
        font.dispose();
        shadow.dispose();
    }

    
}
