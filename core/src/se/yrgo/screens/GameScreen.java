package se.yrgo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.JumpyBirb;

public class GameScreen implements Screen {

    final JumpyBirb game;

    OrthographicCamera camera;

    public GameScreen(JumpyBirb game) {
        this.game = game;
        camera = new OrthographicCamera();


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();
        game.font.draw(game.batch, "GAME SCREEN - PRESS MOUSE TO END", JumpyBirb.WIDTH/2.0f, JumpyBirb.HEIGHT/2.0f);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new EndScreen(game));
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
