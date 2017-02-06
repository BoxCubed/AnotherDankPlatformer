package com.simplyballistic.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.simplyballistic.game.screens.PlayScreen;

public class PlatformerMain extends Game {
    public static final int V_WIDTH=1920;
    public static final int V_HEIGHT=1080;
	public static SpriteBatch batch;
    private static PlatformerMain instance;


	@Override
	public void create () {
        batch = new SpriteBatch();
        instance=this;
        setScreen(new PlayScreen());
	}

	@Override
	public void render () {
	    super.render();
    }

	
	@Override
	public void dispose () {
		super.dispose();

			}



    public static PlatformerMain getInstance(){
	    return instance;
            }
}
