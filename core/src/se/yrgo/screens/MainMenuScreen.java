package se.yrgo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.JumpyBirb;

public class MainMenuScreen implements Screen {

    final JumpyBirb game;

    OrthographicCamera camera;
    private Texture bg;
    private Texture playButton;

    public MainMenuScreen(final JumpyBirb game) {
        this.game = game;
        camera = new OrthographicCamera();
        bg = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(Color.FOREST,true);


        game.batch.begin();
        game.batch.draw(bg, camera.position.x - (camera.viewportWidth/ 2), 0);
        game.batch.draw(playButton, JumpyBirb.WIDTH/2 - 50, JumpyBirb.HEIGHT/2);
        game.font.draw(game.batch, "MAIN MENU SCREEN", JumpyBirb.WIDTH/2.0f - 50, JumpyBirb.HEIGHT/2.0f);
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
