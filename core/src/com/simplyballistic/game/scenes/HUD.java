package com.simplyballistic.game.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.simplyballistic.game.PlatformerMain;

/**
 * Created by ryan9 on 3/02/2017.
 */
public class HUD {
    public Stage stage;
    public Viewport hudvp;
    private int score;
    private int timer;
    private float timelimit;
    private Label scorelab;
    private Label timelab;
    //Label timestrlab;
    float h = PlatformerMain.V_HEIGHT;
    float w = PlatformerMain.V_WIDTH;
    public HUD(SpriteBatch sb){

        score=0;
        timer=0;
        timelimit=300;
        hudvp=new FitViewport(w,h,new OrthographicCamera());
        stage=new Stage(hudvp,sb);
        Table tb=new Table();
        tb.top();
        tb.setFillParent(true);
        scorelab=new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        timelab=new Label(Float.toString(timelimit),new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        //timestrlab=new Label("Time: ",new Label.LabelStyle(new BitmapFont(),Color.WHITE));
        tb.add(scorelab).expandX().padTop(10);
       // tb.add(timestrlab).expandX().padTop(10);
        tb.add(timelab).expandX().padTop(10);
        stage.addActor(tb);



    }
    public void update(float delta){
        if(timelimit>0){
        timelimit-=delta;
        timelab.setText(Float.toString(timelimit).substring(0,3));
        } else {timelab.setText("Time's Up!");}



    }
    public void dispose(){
        stage.dispose();

    }
}
