package com.mygdx.game;

public class Bullet {
    float xBullet;
    float yBullet;

    public Bullet(float xBullet, float yBullet) {
        this.xBullet = xBullet;
        this.yBullet = yBullet;
    }

    public float getxBullet() {
        return xBullet;
    }

    public float getyBullet() {
        return yBullet;
    }

    public void setxBullet(float xBullet) {
        this.xBullet = xBullet;
    }
}
