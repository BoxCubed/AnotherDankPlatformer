package com.simplyballistic.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.simplyballistic.game.PlatformerMain;
import com.simplyballistic.game.scenes.HUD;

/**
 * Created by ryan9 on 3/02/2017.
 */
public class PlayScreen implements Screen{
    private PlatformerMain game;

    //val dec
    private OrthographicCamera gamecam;
    private Viewport vport;
    private HUD hud;
    private OrthogonalTiledMapRenderer mrenderer;


    float h = PlatformerMain.V_HEIGHT;
    float w = PlatformerMain.V_WIDTH;

    //const
    public PlayScreen(){
    game=PlatformerMain.getInstance();
    gamecam=new OrthographicCamera();
    vport=new FitViewport(200 * (w / h),200,gamecam);

    hud=new HUD(game.batch);

    mrenderer=new OrthogonalTiledMapRenderer(new TmxMapLoader().load("worlds/world1.tmx"));

    gamecam.position.set(vport.getWorldWidth()/2,vport.getWorldHeight()/2,0);


    }




    @Override
    public void show() {

    }
    void checkInput(float delta){
    if(Gdx.input.isTouched())gamecam.position.x+=100*delta;
    }
    void update(float delta){
        checkInput(delta);
        gamecam.update();
        hud.update(delta);

        mrenderer.setView(gamecam);
    }
    @Override
    public void render(float delta) {
        update(delta);
game.batch.begin();
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(gamecam.combined);

        mrenderer.render();
        game.batch.end();
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();




    }


    @Override
    public void resize(int width, int height) {
       vport.update(500*width/height,500);

       hud.hudvp.update(width, height);
    }


    @Override
    public void pause() {

    }


    @Override
    public void resume() {

    }


    @Override
    public void hide() {

    }


    @Override
    public void dispose() {

    game.batch.dispose();
    mrenderer.dispose();
    hud.dispose();


    }
}
