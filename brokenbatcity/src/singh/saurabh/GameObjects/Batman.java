package singh.saurabh.GameObjects;

import singh.saurabh.BBCHelpers.AssetLoader;
import singh.saurabh.BBCHelpers.InputHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Batman {
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;

	private float rotation; // For handling player rotation
	private int width;
	private int height;
	float screenWidth = Gdx.graphics.getWidth();
    float screenHeight = Gdx.graphics.getHeight();
    
    private float originalY;
    
    private Circle boundingCircle;
    private Polygon poly;

    private boolean isAlive;
    
    private InputHandler input;
    
	public Batman(float x, float y, int width, int height) {
		this.width = width;
        this.height = height;
        this.originalY = y;
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 750);
        
        boundingCircle = new Circle();
        poly = new Polygon();
        
        isAlive = true;
    }
	
	public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 150) {
            velocity.y = 370;
        }
        
        // CEILING CHECK
     		if (position.y < -10) {
     			position.y = -10;
     			velocity.y = 0;
     		}
     		
        position.add(velocity.cpy().scl(delta));
        boundingCircle.set(position.x + 30, position.y + 60, 38);
        poly.setPosition(position.x + 30, position.y + 60);
        
    }
	
	public void updateReady(float runTime) {
        position.y = 2 * (float) Math.sin(7 * runTime) + originalY;
    }
	
	public boolean isFalling() {
		//velocity.y = -50;
	    return position.y < screenHeight/2 && isAlive;
		//return !(velocity.y > 110);
	}

	public boolean shouldntRun() {
	    return velocity.y > 70 || !isAlive;
	}

    public void onClick() {
    	if (isAlive()) {
    		AssetLoader.flap.play(3.5f);
    		velocity.y = -300;
    	}
    }
    
    public boolean onDragged() {

    	return false;
    }
    public void die() {
	    isAlive = false;
	    velocity.y = 0;
	}
	
	public void decelerate() {
	    velocity.y = -30;
	}
	
	public void onRestart(int y) {
        rotation = 0;
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 750;
        isAlive = true;
    }
	
    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return rotation;
    }
    
    public Circle getBoundingCircle() {
        return boundingCircle;
    }
    
    public Polygon getPolygon() {
    	return poly;
    }

    public boolean isAlive() {
		return isAlive;
	}
}
