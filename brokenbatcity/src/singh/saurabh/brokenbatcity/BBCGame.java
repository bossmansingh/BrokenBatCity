package singh.saurabh.brokenbatcity;

import singh.saurabh.BBCHelpers.AssetLoader;
import singh.saurabh.Screen.SplashScreen;

import com.badlogic.gdx.Game;


public class BBCGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}
	
	@Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
