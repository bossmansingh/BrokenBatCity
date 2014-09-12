package singh.saurabh.GameWorld;

import java.util.List;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import singh.saurabh.BBCHelpers.AssetLoader;
import singh.saurabh.BBCHelpers.InputHandler;
import singh.saurabh.GameObjects.Batman;
import singh.saurabh.GameObjects.Grass;
import singh.saurabh.GameObjects.Pipe;
import singh.saurabh.GameObjects.ScrollHandler;
import singh.saurabh.TweenAccessors.Value;
import singh.saurabh.TweenAccessors.ValueAccessor;
import singh.saurabh.ui.SimpleButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    
    private SpriteBatch batcher;

    public static final int VERTICAL_GAP = 170;
    
    private int gameHeight;
    private int midPointY;
    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();  
    
    // Game Objects
    private Batman batman;
    private ScrollHandler scroller;
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3, pipe4, pipe5;
    
    // Game Assets
    private TextureRegion grass;
    private Animation batmanAnimation, bgAnimation, batAnimation;
    private TextureRegion batman_dead1;
    private TextureRegion Building_top_Up, Building_top_Down, Building_bar, ready, logo, gameOver, highScore, scoreboard, star, noStar, retry;
	
	// Tween stuff
    private TweenManager manager;
    private Value alpha = new Value();

    // Buttons
    private SimpleButton button;
    private List<SimpleButton> menuButtons;
    private Color transitionColor;
    
    public GameRenderer(GameWorld world, int gameHeight, int midPointY) {
        myWorld = world;

        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameHeight = (int) (screenHeight-75);
        this.midPointY = midPointY;
        
        this.menuButtons = ((InputHandler) Gdx.input.getInputProcessor()).getMenuButtons();
        
        cam = new OrthographicCamera();
        cam.setToOrtho(true, screenWidth, gameHeight);

        batcher = new SpriteBatch();
        // Attach batcher to camera
        batcher.setProjectionMatrix(cam.combined);
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        
        // Call helper methods to initialize instance variables
        initGameObjects();
        initAssets();
        //setupTweens();
        
        transitionColor = new Color();
		prepareTransition(255, 255, 255, .5f);
    }
    
//    private void setupTweens() {
//        Tween.registerAccessor(Value.class, new ValueAccessor());
//        manager = new TweenManager();
//        Tween.to(alpha, -1, .5f).target(0).ease(TweenEquations.easeOutQuad)
//                .start(manager);
//    }
    
    private void initGameObjects() {
        batman = myWorld.getBatman();
        scroller = myWorld.getScroller();
        frontGrass = scroller.getFrontGrass();
        backGrass = scroller.getBackGrass();
        pipe1 = scroller.getPipe1();
        pipe2 = scroller.getPipe2();
        pipe3 = scroller.getPipe3();
        pipe4 = scroller.getPipe4();
        pipe5 = scroller.getPipe5();
        
    }

    private void initAssets() {
        //bg = AssetLoader.bg;
    	batAnimation = AssetLoader.batAnimation;
    	bgAnimation = AssetLoader.bgAnimation;
        grass = AssetLoader.grass;
        batmanAnimation = AssetLoader.batmanAnimation;
        batman_dead1 = AssetLoader.batman_dead1;
        Building_top_Up = AssetLoader.building_top_Up;
        Building_top_Down = AssetLoader.building_top_Down;
        Building_bar = AssetLoader.building_bar;
        ready = AssetLoader.ready;
		logo = AssetLoader.logo;
		gameOver = AssetLoader.gameOver;
		highScore = AssetLoader.highScore;
		scoreboard = AssetLoader.scoreboard;
		retry = AssetLoader.retry;
		star = AssetLoader.star;
		noStar = AssetLoader.noStar;
    }
    
    private void drawGrass() {
        // Draw the grass
        batcher.draw(grass, frontGrass.getX(), frontGrass.getY(),
        		screenWidth+100, frontGrass.getHeight());
        batcher.draw(grass, backGrass.getX(), backGrass.getY(),
        		screenWidth+100, backGrass.getHeight());
    }

    private void drawSkulls() {

    	batcher.draw(Building_top_Up, pipe1.getX() - 1,
                pipe1.getY() + pipe1.getHeight() - 64, 
                94, 64);
        batcher.draw(Building_top_Down, pipe1.getX(),
                pipe1.getY() + pipe1.getHeight() + VERTICAL_GAP, 
                94, 64);

        batcher.draw(Building_top_Up, pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() - 64, 
                94, 64);
        batcher.draw(Building_top_Down, 
        		pipe2.getX() - 1,
                pipe2.getY() + pipe2.getHeight() + VERTICAL_GAP, 
                94, 64);

        batcher.draw(Building_top_Up, 
        		pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() - 64, 
                94, 64);
        batcher.draw(Building_top_Down, 
        		pipe3.getX() - 1,
                pipe3.getY() + pipe3.getHeight() + VERTICAL_GAP, 
                94, 64);
        
        batcher.draw(Building_top_Up, 
        		pipe4.getX() - 1,
                pipe4.getY() + pipe4.getHeight() - 64, 
                94, 64);
        batcher.draw(Building_top_Down, 
        		pipe4.getX() - 1,
                pipe4.getY() + pipe4.getHeight() + VERTICAL_GAP, 
                94, 64);
        
        batcher.draw(Building_top_Up, 
        		pipe5.getX() - 1,
                pipe5.getY() + pipe5.getHeight() - 64, 
                94, 64);
        batcher.draw(Building_top_Down, 
        		pipe5.getX() - 1,
                pipe5.getY() + pipe5.getHeight() + VERTICAL_GAP, 
                94, 64);
    }
    
    private void drawPipes() {
    	
        batcher.draw(Building_bar, 
        			pipe1.getX(), 
        			pipe1.getY(), 
        			pipe1.getWidth(), 
        			pipe1.getHeight());
        	batcher.draw(Building_bar, 
        			pipe1.getX(), 
        			pipe1.getY() + pipe1.getHeight() + VERTICAL_GAP, 
        			pipe1.getWidth(),
        			frontGrass.getY() - (pipe1.getHeight() + VERTICAL_GAP));

        batcher.draw(Building_bar, 
        			pipe2.getX(), 
        			pipe2.getY(), 
        			pipe2.getWidth(),
        			pipe2.getHeight());
        batcher.draw(Building_bar, 
        			pipe2.getX(), 
        			pipe2.getY() + pipe2.getHeight() + VERTICAL_GAP,
        			pipe2.getWidth(),
        			frontGrass.getY() - (pipe2.getHeight() + VERTICAL_GAP));

        batcher.draw(Building_bar, 
        			pipe3.getX(), 
        			pipe3.getY(), 
        			pipe3.getWidth(),
        			pipe3.getHeight());
        batcher.draw(Building_bar, 
        			pipe3.getX(), 
        			pipe3.getY() + pipe3.getHeight() + VERTICAL_GAP,
        			pipe3.getWidth(),
        			frontGrass.getY() - (pipe3.getHeight() + VERTICAL_GAP));
        
        batcher.draw(Building_bar, 
    				pipe4.getX(), 
    				pipe4.getY(), 
    				pipe4.getWidth(),
    				pipe4.getHeight());
        batcher.draw(Building_bar, 
    				pipe4.getX(), 
    				pipe4.getY() + pipe4.getHeight() + VERTICAL_GAP,
    				pipe4.getWidth(),
    				frontGrass.getY() - (pipe4.getHeight() + VERTICAL_GAP));
        
        batcher.draw(Building_bar, 
    				pipe5.getX(), 
    				pipe5.getY(), 
    				pipe5.getWidth(),
    				pipe5.getHeight());
        batcher.draw(Building_bar, 
    				pipe5.getX(), 
    				pipe5.getY() + pipe5.getHeight() + VERTICAL_GAP,
    				pipe5.getWidth(),
    				frontGrass.getY() - (pipe5.getHeight() + VERTICAL_GAP));
    
    
    }
    
    private void drawBatmanCentered(float runTime) {
    	batcher.draw(batAnimation.getKeyFrame(runTime), batman.getX(), batman.getY(),
                batman.getWidth() / 2.0f, batman.getHeight() / 2.0f,
                batman.getWidth(), batman.getHeight(), 1, 1, batman.getRotation());
    }

    private void drawBatman(float runTime) {
    	if (batman.isAlive()) {
    		if (batman.isFalling()) {
            	batcher.draw(batAnimation.getKeyFrame(runTime), batman.getX(),
                        batman.getY(), batman.getWidth() / 2.0f,
                        batman.getHeight() / 2.0f, batman.getWidth() *1.1f, batman.getHeight() *1.1f,
                        1, 1, batman.getRotation());
            } else {
            	
            	batcher.draw(batmanAnimation.getKeyFrame(runTime), batman.getX() - 30, batman.getY() - 35, batman.getWidth() / 2.0f, 
                		batman.getHeight() / 2.0f, batman.getWidth() * 1.6f, batman.getHeight() * 1.8f,
                        1, 1, batman.getRotation());
            }
    		
    		if (batman.onDragged()) {
        		batcher.draw(batman_dead1, batman.getX() - 30, batman.getY() - 35, batman.getWidth() * 1.6f, batman.getHeight() * 1.8f);
        	}
    	} else {
    		
    		batcher.draw(batman_dead1, batman.getX() - 30, batman.getY() - 35, batman.getWidth() * 1.6f, batman.getHeight() * 1.8f);
    	}
    }
    

    private void drawMenuUI() {
        batcher.draw(AssetLoader.logo, screenWidth / 2 - 460, midPointY - 280,
                AssetLoader.logo.getRegionWidth() * .8f,
                AssetLoader.logo.getRegionHeight() * .8f);

        for (SimpleButton button : menuButtons) {
            button.draw(batcher);
        }

    }
    
    private void drawScoreboard() {
		batcher.draw(AssetLoader.scoreboard, (screenWidth / 4), midPointY / 2, AssetLoader.scoreboard.getRegionWidth() * 7, AssetLoader.scoreboard.getRegionHeight() * 7);

		batcher.draw(AssetLoader.noStar, (screenWidth / 4) + 3 + 67, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		batcher.draw(AssetLoader.noStar, (screenWidth / 4) + 15 + 117, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		batcher.draw(AssetLoader.noStar, (screenWidth / 4) + 27 + 167, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		batcher.draw(AssetLoader.noStar, (screenWidth / 4) + 39 + 217, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		batcher.draw(AssetLoader.noStar, (screenWidth / 4) + 51 + 267, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);

		if (myWorld.getScore() > 2) {
			batcher.draw(AssetLoader.star, (screenWidth / 4) + 51 + 267, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		}

		if (myWorld.getScore() > 17) {
			batcher.draw(AssetLoader.star, (screenWidth / 4) + 39 + 217, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		}

		if (myWorld.getScore() > 50) {
			batcher.draw(AssetLoader.star, (screenWidth / 4) + 27 + 167, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		}

		if (myWorld.getScore() > 80) {
			batcher.draw(AssetLoader.star, (screenWidth / 4) + 15 + 117, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		}

		if (myWorld.getScore() > 120) {
			batcher.draw(AssetLoader.star, (screenWidth / 4) + 3 + 67, midPointY - 50, AssetLoader.noStar.getRegionWidth() * 4.5f, AssetLoader.noStar.getRegionHeight() * 4.5f);
		}

		int length = ("" + myWorld.getScore()).length();

		AssetLoader.whiteFont.draw(batcher, "" + myWorld.getScore(),
				(screenWidth / 2) + 227 , midPointY - 110);

		int length2 = ("" + AssetLoader.getHighScore()).length();
		AssetLoader.whiteFont.draw(batcher, "" + AssetLoader.getHighScore(),
				(screenWidth / 2) + 227 - (2.5f * length2), midPointY);

	}

	private void drawRetry() {
		batcher.draw(AssetLoader.retry, (screenWidth / 4) + ((AssetLoader.scoreboard.getRegionWidth() * 7) / 4) + (AssetLoader.gameOver.getRegionWidth() * 8) / 8 , midPointY + (AssetLoader.scoreboard.getRegionHeight() * 7) / 2.5f, AssetLoader.retry.getRegionWidth() * 8, AssetLoader.retry.getRegionHeight() * 8);
	}

	private void drawReady() {
		batcher.draw(AssetLoader.ready, (screenWidth / 2) - (AssetLoader.ready.getRegionWidth() * 8) / 2, midPointY / 2, AssetLoader.ready.getRegionWidth() * 8, AssetLoader.ready.getRegionHeight() * 8);
	}

	private void drawGameOver() {
		batcher.draw(AssetLoader.gameOver, (screenWidth / 4) + (AssetLoader.scoreboard.getRegionWidth() * 7) / 4, midPointY - (AssetLoader.scoreboard.getRegionHeight() * 7) , AssetLoader.gameOver.getRegionWidth() * 8, AssetLoader.gameOver.getRegionHeight() * 8);
	}
	
    private void drawScore() {
    	// Convert integer into String
        String score = myWorld.getScore() + "";

        // Draw shadow first
        AssetLoader.shadow.draw(batcher, "" + myWorld.getScore(), (Gdx.graphics.getWidth() / 2) - (3 * score.length()), 101);
        // Draw text
        AssetLoader.font.draw(batcher, "" + myWorld.getScore(), (Gdx.graphics.getWidth() / 2) - (3 * score.length() - 1), 100);
    	
    }
    
    private void drawHighScore() {
		batcher.draw(AssetLoader.highScore, (screenWidth / 4) + (AssetLoader.scoreboard.getRegionWidth() * 7) / 4, midPointY - (AssetLoader.scoreboard.getRegionHeight() * 7), AssetLoader.highScore.getRegionWidth() * 8, AssetLoader.highScore.getRegionHeight() * 8);
	}
    
    public void render(float delta, float runTime) {

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeType.Filled);
        
        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, screenWidth, screenHeight);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 66, screenWidth, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, midPointY + 77, screenWidth, 52);
        
        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency 
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        batcher.draw(bgAnimation.getKeyFrame(runTime), 0, 0, screenWidth, screenHeight);
        //AssetLoader.lightning.play();
        // 1. Draw Grass
        drawGrass();
        
        // 2. Draw Pipes
        drawPipes();
        
        // The batman needs transparency, so we enable that again.
        batcher.enableBlending();
        
        // 3. Draw Skulls (requires transparency)
        drawSkulls();
        
        // Draw batman at its coordinates. Retrieve the Animation object from AssetLoader
        // Pass in the runTime variable to get the current frame.
        if (myWorld.isRunning()) {
            drawBatman(runTime);
            drawScore();
        } else if (myWorld.isReady()) {
        	drawBatman(runTime);
        	drawReady();
        } else if (myWorld.isMenu()) {
            drawBatmanCentered(runTime);
            drawMenuUI();
        } else if (myWorld.isGameOver()) {
        	drawScoreboard();
			drawBatman(runTime);
			drawGameOver();
			drawRetry();
        } else if (myWorld.isHighScore()) {
        	drawScoreboard();
			drawBatman(runTime);
			drawHighScore();
			drawRetry();
        }
        
        batcher.end();
        drawTransition(delta);
//        shapeRenderer.begin(ShapeType.Filled);
//        shapeRenderer.setColor(Color.RED);
//        shapeRenderer.circle(batman.getBoundingCircle().x, batman.getBoundingCircle().y, batman.getBoundingCircle().radius);
//        shapeRenderer.rect(pipe1.getGroundBar().x, pipe1.getGroundBar().y, pipe1.getGroundBar().width, pipe1.getGroundBar().height);
//        /*
//        * Excuse the mess below. Temporary code for testing bounding
//        * rectangles.
//        */
//        // Bar up for pipes 1 2 3 4 and 5
//        
//        shapeRenderer.rect(block1.getBlock().x, block1.getBlock().y, block1.getBlock().width, block1.getBlock().height);
//        shapeRenderer.rect(block1.getBlock().x, block2.getBlock().y, block2.getBlock().width, block2.getBlock().height);
//        shapeRenderer.rect(block1.getBlock().x, block3.getBlock().y, block3.getBlock().width, block3.getBlock().height);
//        shapeRenderer.rect(block1.getBlock().x, block4.getBlock().y, block4.getBlock().width, block4.getBlock().height);
//        shapeRenderer.rect(block1.getBlock().x, block5.getBlock().y, block5.getBlock().width, block5.getBlock().height);
//        
//      shapeRenderer.rect(pipe1.getBarUp().x, pipe1.getBarUp().y,
//                pipe1.getBarUp().width, pipe1.getBarUp().height);
//      shapeRenderer.rect(pipe2.getBarUp().x, pipe2.getBarUp().y,
//                pipe2.getBarUp().width, pipe2.getBarUp().height);
//      shapeRenderer.rect(pipe3.getBarUp().x, pipe3.getBarUp().y,
//                pipe3.getBarUp().width, pipe3.getBarUp().height);
//      shapeRenderer.rect(pipe4.getBarUp().x, pipe4.getBarUp().y,
//                pipe4.getBarUp().width, pipe4.getBarUp().height);
//      shapeRenderer.rect(pipe5.getBarUp().x, pipe5.getBarUp().y,
//                pipe5.getBarUp().width, pipe5.getBarUp().height);
//
//        // Bar down for pipes 1 2 3 4 and 5
//        shapeRenderer.rect(pipe1.getBarDown().x, pipe1.getBarDown().y,
//                pipe1.getBarDown().width, pipe1.getBarDown().height);
//        shapeRenderer.rect(pipe2.getBarDown().x, pipe2.getBarDown().y,
//                pipe2.getBarDown().width, pipe2.getBarDown().height);
//        shapeRenderer.rect(pipe3.getBarDown().x, pipe3.getBarDown().y,
//                pipe3.getBarDown().width, pipe3.getBarDown().height);
//        shapeRenderer.rect(pipe4.getBarDown().x, pipe4.getBarDown().y,
//                pipe4.getBarDown().width, pipe4.getBarDown().height);
//        shapeRenderer.rect(pipe5.getBarDown().x, pipe5.getBarDown().y,
//                pipe5.getBarDown().width, pipe5.getBarDown().height);
//
//        // Skull up for Pipes 1 2 3 4 and 5
//        shapeRenderer.rect(pipe1.getSkullUp().x, pipe1.getSkullUp().y,
//                pipe1.getSkullUp().width, pipe1.getSkullUp().height);
//        shapeRenderer.rect(pipe2.getSkullUp().x, pipe2.getSkullUp().y,
//                pipe2.getSkullUp().width, pipe2.getSkullUp().height);
//        shapeRenderer.rect(pipe3.getSkullUp().x, pipe3.getSkullUp().y,
//                pipe3.getSkullUp().width, pipe3.getSkullUp().height);
//        shapeRenderer.rect(pipe4.getSkullUp().x, pipe4.getSkullUp().y,
//                pipe4.getSkullUp().width, pipe4.getSkullUp().height);
//        shapeRenderer.rect(pipe5.getSkullUp().x, pipe5.getSkullUp().y,
//                pipe5.getSkullUp().width, pipe5.getSkullUp().height);
//
//        // Skull down for Pipes 1 2 3 4 and 5
//        shapeRenderer.rect(pipe1.getSkullDown().x, pipe1.getSkullDown().y,
//                pipe1.getSkullDown().width, pipe1.getSkullDown().height);
//        shapeRenderer.rect(pipe2.getSkullDown().x, pipe2.getSkullDown().y,
//                pipe2.getSkullDown().width, pipe2.getSkullDown().height);
//        shapeRenderer.rect(pipe3.getSkullDown().x, pipe3.getSkullDown().y,
//                pipe3.getSkullDown().width, pipe3.getSkullDown().height);
//        shapeRenderer.rect(pipe4.getSkullDown().x, pipe4.getSkullDown().y,
//                pipe4.getSkullDown().width, pipe4.getSkullDown().height);
//        shapeRenderer.rect(pipe5.getSkullDown().x, pipe5.getSkullDown().y,
//                pipe5.getSkullDown().width, pipe5.getSkullDown().height);
//
//        shapeRenderer.end();
    }
    
    public void prepareTransition(int r, int g, int b, float duration) {
		transitionColor.set(r / 255.0f, g / 255.0f, b / 255.0f, 1);
		alpha.setValue(1);
		Tween.registerAccessor(Value.class, new ValueAccessor());
		manager = new TweenManager();
		Tween.to(alpha, -1, duration).target(0)
				.ease(TweenEquations.easeOutQuad).start(manager);
	}
    
    private void drawTransition(float delta) {
        if (alpha.getValue() > 0) {
            manager.update(delta);
            Gdx.gl.glEnable(GL10.GL_BLEND);
            Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.begin(ShapeType.Filled);
            shapeRenderer.setColor(transitionColor.r, transitionColor.g,
					transitionColor.b, alpha.getValue());
            shapeRenderer.rect(0, 0, screenWidth, screenHeight);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL10.GL_BLEND);

        }
    }

}