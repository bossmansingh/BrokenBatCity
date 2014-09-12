package singh.saurabh.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import singh.saurabh.BBCHelpers.AssetLoader;
import singh.saurabh.GameObjects.Batman;
import singh.saurabh.GameObjects.Grass;
import singh.saurabh.GameObjects.ScrollHandler;

public class GameWorld {
	
	private Batman batman;

	private ScrollHandler scroller; 
	float screenHeight = Gdx.graphics.getHeight(); 
	private Rectangle ground;
	private Grass grass;
	
	private int score = 0;
	private float runTime = 0;
	private int midPointY;
	private GameRenderer renderer;
	private GameState currentState;
	
	public int i = 2;
	public int SCROLL_SPEED = -330;
	
    public enum GameState {
    	MENU, READY, RUNNING, GAMEOVER, HIGHSCORE
    }
    
    public GameWorld(int midPointY) {
    	currentState = GameState.MENU;
        this.midPointY = midPointY;
        
        // Initialize batman here
    	batman = new Batman(33, midPointY - 5, 100, 100);
    	
    	scroller = new ScrollHandler(this, (screenHeight-75));
    	
    	ground = new Rectangle(0, (screenHeight - 75), 136, 11);
    	
    	AssetLoader.lightning.loop(1);
    }

    public void update(float delta) {
    	runTime += delta;
    	
    	switch (currentState) {
        case READY:
        case MENU:
            updateReady(delta);
            break;

        case RUNNING:
        	updateRunning(delta);
            break;
        default:
            break;
        }
    }
    

    
    private void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        batman.update(delta);
        scroller.update(delta);

        if (scroller.collides(batman) && batman.isAlive()) {
            scroller.stop();
            batman.die();
            AssetLoader.dead.play();
            renderer.prepareTransition(255, 255, 255, .3f);
            
        }
        
        if (Intersector.overlaps(batman.getBoundingCircle(), ground) && !batman.isAlive()) {
            
        	currentState = GameState.GAMEOVER;
            
            if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }
        
        if (Intersector.overlaps(batman.getBoundingCircle(), ground) && batman.isAlive()) {

        	batman.decelerate();
        }
		
	}

	private void updateReady(float delta) {
		batman.updateReady(runTime);
        scroller.updateReady(delta);
	}

	public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }
    
    public Batman getBatman() {
        return batman;

    }
    
    public int getMidPointY() {
		return midPointY;
	}

    
    public ScrollHandler getScroller() {
        return scroller;
    }
    
    public void ready() {
        currentState = GameState.READY;
        renderer.prepareTransition(0, 0, 0, 1f);
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        score = 0;
        batman.onRestart(midPointY - 5);
        scroller.onRestart();
        ready();
    }
    
    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public boolean isMenu() {
        return currentState == GameState.MENU;
    }

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }
    
    public void setRenderer(GameRenderer renderer) {
		this.renderer = renderer;
	}
}
