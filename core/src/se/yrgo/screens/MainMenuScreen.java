package se.yrgo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.JumpyBirb;

public class MainMenuScreen implements Screen {

    final JumpyBirb game;

    OrthographicCamera camera;
    private Texture bg, playButton;

    //private Vector2 posPlay;



    //private Rectangle boundsPlay;


    public MainMenuScreen(final JumpyBirb game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 288,512);
        bg = new Texture("bg.png");
        //posPlay = new Vector2(JumpyBirb.WIDTH/2 - 50, JumpyBirb.HEIGHT/2);
        playButton = new Texture("playbtn.png");
        //boundsPlay = new Rectangle(posPlay.x, posPlay.y, playButton.getWidth(), playButton.getHeight());
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(Color.FOREST,true);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(bg, camera.position.x - (camera.viewportWidth/ 2), 0);
        game.batch.draw(playButton, JumpyBirb.WIDTH/2 - 50, JumpyBirb.HEIGHT/2);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }


    }

    @Override
    public void resize(int width, int height) {

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

    }


}
