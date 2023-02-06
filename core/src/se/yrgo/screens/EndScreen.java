package se.yrgo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.JumpyBirb;

public class EndScreen implements Screen {
    final JumpyBirb game;
    OrthographicCamera camera;
    private Texture bg, gameOver;

    public EndScreen(final JumpyBirb game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 288,512);
        bg = new Texture("bg.png");
        gameOver = new Texture("gameOver.png");
    }

    @Override
    public void show() {

    }

    @Override
   public void render(float delta) {
        ScreenUtils.clear(Color.ORANGE);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(bg, camera.position.x - (camera.viewportWidth/ 2), 0);
        game.batch.draw(gameOver, JumpyBirb.WIDTH / 2 - 95 , JumpyBirb.HEIGHT/ 2);
        //game.font.draw(game.batch, "END SCREEN PRESS SPACE TO PLAY AGAIN", 200,200);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();

        }
        //else if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
         //   Gdx.app.exit();
        //}

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
