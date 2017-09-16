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
    float asteroidX1;
    float asteroidY1;
    float asteroidVX1;
    float asteroidX2;
    float asteroidY2;
    float asteroidVX2;
    float shipX;
    float shipY;
    float shipVY;
    float bulletX;
    float bulletY;
    float bulletVX;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("img.png");
        asteroidX1 = 1250.0f;
        asteroidY1 = 350.0f;
        asteroidVX1 = 10.0f;
        asteroidX2 = 1250.f;
        asteroidY2 = 170.0f;
        asteroidVX2 = 35.0f;
        shipX = 10.0f;
        shipY = 166.0f;
        shipVY = 120.0f;
        bulletX = 20.0f;
        bulletY = 190.0f;
        bulletVX = 60.0f;
    }

    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);
        Gdx.gl.glClearColor(0.051f, 0.027f, 0.263f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        t += 0.2f;
        batch.begin();
        batch.draw(img, asteroidX1, asteroidY1, 64, 64, 128, 128, 1, 1, t, 0, 0, 256, 256, false, false);
        batch.draw(img, asteroidX2, asteroidY2, 64, 64, 128, 128, 0.8f, 0.8f, -t, 0, 0, 256, 256, false, false);
        batch.draw(img, bulletX, bulletY, 0, 0, 16, 16, 1, 1, 0, 256, 176, 16, 16, true, false);
        batch.draw(img, shipX, shipY, 0, 0, 64, 64, 1, 1, 0, 256, 192, 64, 64, false, false);
        batch.end();
    }

    public void update(float dt) {
        asteroidX1 -= asteroidVX1 * dt;
        asteroidX2 -= asteroidVX2 * dt;
//        if (shipY > Gdx.graphics.getHeight() - 64) {
//            shipY = Gdx.graphics.getHeight() - 64;
//            shipVY = -shipVY;
//        } else if (shipY < 0) {
//            shipY = 0;
//            shipVY = -shipVY;
//        } else shipY += shipVY * dt;
        bulletX += bulletVX * dt;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            shipY += shipVY * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            shipY -= shipVY * dt;
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
