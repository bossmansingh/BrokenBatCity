package singh.saurabh.BBCHelpers;

import java.util.ArrayList;
import java.util.List;

import singh.saurabh.GameObjects.Batman;
import singh.saurabh.GameWorld.GameWorld;
import singh.saurabh.ui.SimpleButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor {

	private Batman myBatman;
	private GameWorld myWorld;
	
	private List<SimpleButton> menuButtons;

    private SimpleButton playButton;

    private float scaleFactorX;
    private float scaleFactorY;
    
    float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();  
    
	// Ask for a reference to the Batman when InputHandler is created.
	public InputHandler(GameWorld myWorld, float scaleFactorX,
            float scaleFactorY) {
		 // myBatman now represents the gameWorld's batman.
		this.myWorld = myWorld;	
		myBatman = myWorld.getBatman();
		
		int midPointY = myWorld.getMidPointY();

        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;

        menuButtons = new ArrayList<SimpleButton>();
        playButton = new SimpleButton((screenWidth / 2) - 200, 
        								(screenHeight / 2) - 100, 
        								AssetLoader.playButtonUp.getRegionWidth() * 2.5f, 
        								AssetLoader.playButtonUp.getRegionHeight()  * 2.3f, 
        								AssetLoader.playButtonUp,
        								AssetLoader.playButtonDown);
        menuButtons.add(playButton);
	}
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        
        if (myWorld.isMenu()) {
            playButton.isTouchDown(screenX, screenY);
        } else if (myWorld.isReady()) {
            myWorld.start();
        }

        myBatman.onClick();

        if (myWorld.isGameOver() || myWorld.isHighScore()) {
            myWorld.restart();
        }

        return true;
    }

	@Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if (myWorld.isMenu()) {
            if (playButton.isTouchUp(screenX, screenY)) {
                myWorld.ready();
                return true;
            }
        }

        return false;
    }

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		return false;
	}

	@Override
    public boolean scrolled(int amount) {
        return false;
    }

    private int scaleX(int screenX) {
        return (int) (screenX / scaleFactorX);
    }

    private int scaleY(int screenY) {
        return (int) (screenY / scaleFactorY);
    }

    public List<SimpleButton> getMenuButtons() {
        return menuButtons;
    }

}
