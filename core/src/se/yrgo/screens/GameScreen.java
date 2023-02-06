package se.yrgo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.JumpyBirb;
import se.yrgo.sprites.Bird;

public class GameScreen implements Screen {

    final JumpyBirb game;
    private Bird bird;

    OrthographicCamera camera;
    private Texture bg;
    private Texture ground;


    public GameScreen(JumpyBirb game) {
        this.game = game;
        bird = new Bird(50,300);
        camera = new OrthographicCamera();
        bg = new Texture("bg.png");
        ground = new Texture("ground.png");


    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);

        game.batch.begin();
        game.batch.draw(bg, camera.position.x - (camera.viewportWidth/ 2), 0);
        game.batch.draw(ground, camera.position.x - (camera.viewportWidth/2),0);
        game.font.draw(game.batch, "GAME SCREEN - PRESS MOUSE TO END", JumpyBirb.WIDTH/2, JumpyBirb.HEIGHT/2);
        bird.update(delta);
        game.batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        game.batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            bird.jump();
        }

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
