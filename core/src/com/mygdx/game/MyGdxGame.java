package com.mygdx.game;
//batch.draw(img/*картинка*/, 10, 150/*координаты на экране*/, 0, 0/*якорь*/, 64, 64/*размер картинки*/, 1, 1/*масштаб*/, 0/*угол поворота*/, 256, 192/*начало откуда смотрим*/, 64,64/*размер от начала откуда смотрим*/, false,false/*отражение картинки*/);

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    float t = 0f;
    float xAsteroid1;
    float yAsteroid1;
    float vxAsteroid1;
    float xAsteroid2;
    float yAsteroid2;
    float vxAsteroid2;
    float xShip;
    float yShip;
    float vxShip;
    float vyShip;
    float xBullet;
    float yBullet;
    float vxBullet;
    boolean flag;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("img.png");
        xAsteroid1 = 1250.0f;
        yAsteroid1 = 350.0f;
        vxAsteroid1 = 10.0f;
        xAsteroid2 = 1250.f;
        yAsteroid2 = 170.0f;
        vxAsteroid2 = 35.0f;
        xShip = 10.0f;
        yShip = 166.0f;
        vxShip = 120.0f;
        vyShip = 120.0f;
//        xBullet = 20.0f;
//        yBullet = 190.0f;
        vxBullet = 60.0f;
        flag = false;
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(0.051f, 0.027f, 0.263f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        t += 0.2f;
        batch.begin();
        batch.draw(img, xAsteroid1, yAsteroid1, 64, 64, 128, 128, 1, 1, t, 0, 0, 256, 256, false, false);
        batch.draw(img, xAsteroid2, yAsteroid2, 64, 64, 128, 128, 0.8f, 0.8f, -t, 0, 0, 256, 256, false, false);
        if (flag) batch.draw(img, xBullet, yBullet, 0, 0, 16, 16, 1, 1, 0, 256, 176, 16, 16, true, false);
        batch.draw(img, xShip, yShip, 0, 0, 64, 64, 1, 1, 0, 256, 192, 64, 64, false, false);
        batch.end();
    }

    public void update(float dt) {
        xAsteroid1 -= vxAsteroid1 * dt;
        xAsteroid2 -= vxAsteroid2 * dt;
        xBullet += vxBullet * dt;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            yShip += vyShip * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            yShip -= vyShip * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xShip += vxShip * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xShip -= vxShip * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            flag = true;
            xBullet = xShip + 10;
            yBullet = yShip + 24;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
