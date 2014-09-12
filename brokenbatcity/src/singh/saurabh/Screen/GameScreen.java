package singh.saurabh.Screen;

import singh.saurabh.BBCHelpers.InputHandler;
import singh.saurabh.GameWorld.GameRenderer;
import singh.saurabh.GameWorld.GameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
	private GameWorld world;
	private GameRenderer renderer;
	
	private float runTime = 0;
	
	public GameScreen() {
		float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();      
        float gameWidth = screenWidth;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        
        int midPointY = (int) (gameHeight / 2);
		
		world = new GameWorld(midPointY); // initialize world
		Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));
        renderer = new GameRenderer(world, (int) gameHeight, midPointY);
        world.setRenderer(renderer);
    }

    @Override
    public void render(float delta) {
    	runTime += delta;
    	world.update(delta); // GameWorld updates 
    	renderer.render(runTime); // GameRenderer renders
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        // Leave blank
    }


}
