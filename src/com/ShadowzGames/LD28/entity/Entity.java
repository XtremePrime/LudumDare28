package com.ShadowzGames.LD28.entity;

import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Sprite;

public class Entity extends SpriteContainer {
	public boolean removed;
	private int animationIndex;
	private int animationFrame;
	private boolean flipped;
	private boolean dead = false;
	private boolean falling = true;
	private boolean moving = false;
	private boolean jumping = false;
	private float velY = 1;
	private float velX = 0;
	
	public Entity(Sprite prototype){
		super(prototype, prototype.getBoundingBox());
	}
	
	private void remove() {
		removed = true;
	}
	
	public void die() {
		remove();
		dead = true;
	}
	
	public boolean isDead(){
		return dead;
	}
	
	public boolean isFlipped(){
		return flipped;
	}

	public int getAnimationIndex() {
		return animationIndex;
	}

	public void setAnimationIndex(int animationIndex) {
		if(animationIndex >= 0)
			this.animationIndex = animationIndex;
	}

	public int getAnimationFrame() {
		return animationFrame;
	}

	public void setAnimationFrame(int animationFrame) {
		if(animationFrame >= 0)
			this.animationFrame = animationFrame;
	}

	public void flip() {
		flipped = !flipped;
		
	}

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}

	public float getVelocityY() {
		return velY;
	}

	public float getVelocityX() {
		return velX;
	}

	/**
	 * Limited velocity to 50, to keep it from going too fast
	 * @param velY
	 */
	public void setVelocityY(float velY) {
		if(velY <= 50)
			this.velY = velY;
		else
			this.velY = 50;
	}

	public void setVelocityX(float velX) {
		if(velX <=50)
			this.velX = velX;
		else
			this.velX = 50;
	}
}
