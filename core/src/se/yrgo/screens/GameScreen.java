package se.yrgo.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import se.yrgo.JumpyBirb;
import se.yrgo.sprites.Bird;
import se.yrgo.sprites.Tube;

public class GameScreen implements Screen {
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    final JumpyBirb game;
    private Bird bird;

    OrthographicCamera camera;
    private Texture bg, ground;

    //private Tube tube;

    private Array<Tube> tubes;

    public GameScreen(JumpyBirb game) {
        this.game = game;
        bird = new Bird(50, 300);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, JumpyBirb.WIDTH,JumpyBirb.HEIGHT) ;
        bg = new Texture("bg.png");
        ground = new Texture("ground.png");
        //tube = new Tube(100);
        tubes = new Array<Tube>();

        for (int i = 1; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));

        }


    }

    @Override
    public void show() {

    }



    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(bg, camera.position.x - (camera.viewportWidth / 2), 0);
        game.batch.draw(ground, camera.position.x - (camera.viewportWidth / 2), 0);
        game.batch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes) {
            game.batch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            game.batch.draw(tube.getBottomTube(), tube.getPosBottomTube().x, tube.getPosBottomTube().y);
        }

        bird.update(delta);
        camera.position.x = bird.getPosition().x;
        camera.update();
        for (Tube tube : tubes) {
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + ((tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }
        }
        camera.update();

        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
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
