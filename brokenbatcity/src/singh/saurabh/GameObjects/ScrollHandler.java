package singh.saurabh.GameObjects;

import java.util.Random;

import singh.saurabh.BBCHelpers.AssetLoader;
import singh.saurabh.GameWorld.GameWorld;

public class ScrollHandler {

    // ScrollHandler will create all five objects that we need.
    private Grass frontGrass, backGrass;
    private Pipe pipe1, pipe2, pipe3, pipe4, pipe5;
	private GameWorld gameWorld;
	
	private Random p, r;
	int n, q = 0;
	
    // ScrollHandler will use the constants below to determine
    // how fast we need to scroll and also determine
    // the size of the gap between each pair of pipes.

    // Capital letters are used by convention when naming constants.
    
    public static final int PIPE_GAP = 260;
    public static final int BLOCK_GAP = PIPE_GAP + 150;

    // Constructor receives a float that tells us where we need to create our 
    // Grass and Pipe objects.
    public ScrollHandler(GameWorld gameWorld, float yPos) {
    	r = new Random();
    	p = new Random();
    	n = (int) (yPos - 170);
    	this.gameWorld = gameWorld;
    	frontGrass = new Grass(0, yPos, 1000, 35, gameWorld.SCROLL_SPEED);
        backGrass = new Grass(frontGrass.getTailX(), yPos, 1000, 35, gameWorld.SCROLL_SPEED);
        
        pipe1 = new Pipe(1500, 0, 90, 120+r.nextInt(100), gameWorld.SCROLL_SPEED, yPos);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, 0, 90, 280+r.nextInt(100), gameWorld.SCROLL_SPEED, yPos);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, 0, 90, 10+r.nextInt(100), gameWorld.SCROLL_SPEED, yPos);
        pipe4 = new Pipe(pipe3.getTailX() + PIPE_GAP, 0, 90, 80+r.nextInt(100), gameWorld.SCROLL_SPEED, yPos);
        pipe5 = new Pipe(pipe4.getTailX() + PIPE_GAP, 0, 90, 200+r.nextInt(100), gameWorld.SCROLL_SPEED, yPos);
        
    }
    
    public void updateReady(float delta) {
    	//to make grass scrolling at startup
//		frontGrass.update(delta);
//		backGrass.update(delta);

//		// Same with grass
//		if (frontGrass.isScrolledLeft()) {
//			frontGrass.reset(backGrass.getTailX());
//
//		} else if (backGrass.isScrolledLeft()) {
//			backGrass.reset(frontGrass.getTailX());
//
//		}

	}
    
    public void update(float delta) {
    	// Update our objects
    	
        frontGrass.update(delta);
        backGrass.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);
        pipe4.update(delta);
        pipe5.update(delta);
        
        // Same with grass
        if (frontGrass.isScrolledLeft()) {
            frontGrass.reset(backGrass.getTailX());

        } else if (backGrass.isScrolledLeft()) {
            backGrass.reset(frontGrass.getTailX());
        }
        
        // Check if any of the pipes or blocks are scrolled left,
        // and reset accordingly
        if (pipe1.isScrolledLeft()) {
        	pipe1.reset(pipe5.getTailX() + PIPE_GAP);
        	
        } else if (pipe2.isScrolledLeft()) {
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);
            
        } else if (pipe3.isScrolledLeft()) {
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
            
        } else if (pipe4.isScrolledLeft()) {
            pipe4.reset(pipe3.getTailX() + PIPE_GAP);
            
        } else if (pipe5.isScrolledLeft()) {
            pipe5.reset(pipe4.getTailX() + PIPE_GAP);
            
        }
        
    }
    
    public void onRestart() {
    	gameWorld.SCROLL_SPEED = -330;
        frontGrass.onRestart(0, gameWorld.SCROLL_SPEED);
        backGrass.onRestart(frontGrass.getTailX(), gameWorld.SCROLL_SPEED);
        
        pipe1.onRestart(1500, gameWorld.SCROLL_SPEED);
        pipe2.onRestart(pipe1.getTailX() + PIPE_GAP, gameWorld.SCROLL_SPEED);
        pipe3.onRestart(pipe2.getTailX() + PIPE_GAP, gameWorld.SCROLL_SPEED);
        pipe4.onRestart(pipe3.getTailX() + PIPE_GAP, gameWorld.SCROLL_SPEED);
        pipe5.onRestart(pipe4.getTailX() + PIPE_GAP, gameWorld.SCROLL_SPEED);
        
    }
    
    public void stop() {
        frontGrass.stop();
        backGrass.stop();
        pipe1.stop();
        pipe2.stop();
        pipe3.stop();
        pipe4.stop();
        pipe5.stop();
        
    }

    public boolean collides(Batman batman) {
    	
    	if (!pipe1.isScored()
                && pipe1.getX() + (pipe1.getWidth() / 2) < batman.getX()
                        + batman.getWidth()) {
            addScore(1);
            pipe1.setScored(true);
            AssetLoader.coin.play();
        } else if (!pipe2.isScored()
                && pipe2.getX() + (pipe2.getWidth() / 2) < batman.getX()
                        + batman.getWidth()) {
            addScore(1);
            pipe2.setScored(true);
            AssetLoader.coin.play();

        } else if (!pipe3.isScored()
                && pipe3.getX() + (pipe3.getWidth() / 2) < batman.getX()
                        + batman.getWidth()) {
            addScore(1);
            pipe3.setScored(true);
            AssetLoader.coin.play();

        } else if (!pipe4.isScored()
                && pipe4.getX() + (pipe4.getWidth() / 2) < batman.getX()
                + batman.getWidth()) {
        	addScore(1);
        	pipe4.setScored(true);
        	AssetLoader.coin.play();

        } else if (!pipe5.isScored()
                && pipe5.getX() + (pipe5.getWidth() / 2) < batman.getX()
                + batman.getWidth()) {
        	addScore(1);
        	pipe5.setScored(true);
        	AssetLoader.coin.play();
        	gameWorld.SCROLL_SPEED-=100;
        } 
        return (pipe1.collides(batman) || pipe2.collides(batman) || pipe3.collides(batman) || pipe4.collides(batman) || pipe5.collides(batman));
    }

    
    private void addScore(int increment) {
    	 gameWorld.addScore(increment);
	}

	// The getters for our five instance variables
    public Grass getFrontGrass() {
        return frontGrass;
    }

    public Grass getBackGrass() {
        return backGrass;
    }

    public Pipe getPipe1() {
        return pipe1;
    }

    public Pipe getPipe2() {
        return pipe2;
    }

    public Pipe getPipe3() {
        return pipe3;
    }
    
    public Pipe getPipe4() {
        return pipe4;
    }
    
    public Pipe getPipe5() {
        return pipe5;
    }
    
}
