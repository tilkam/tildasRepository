package se.yrgo.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private Vector3 position;
    private Vector3 velocity;

    private Texture bird;
    private Rectangle bounds;

    public Bird(int x, int y){
        //startposition
        position = new Vector3(x,y,0);
        //not moving
        velocity = new Vector3(0,0,0);
        //lägg in bilden vi ska ha
        bird = new Texture("bird.png");
        //För collision
        bounds = new Rectangle(x,y, bird.getWidth(), bird.getHeight());
    }

    public void update(float dt){
        if(position.y > 0)
            velocity.add(0,GRAVITY,0);
        velocity.scl(dt);
        //Framåt
        position.add(MOVEMENT * dt,velocity.y, 0);

        //Bara upp och ner
        position.add(0, velocity.y, 0);
        if( position.y < 0)
            position.y = 0;
        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);


    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return bird;
    }

    public void jump(){
        velocity.y = 150;
    }
    public Rectangle getBounds(){
        return bounds;
    }


}
