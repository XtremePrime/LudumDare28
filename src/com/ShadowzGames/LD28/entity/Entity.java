package com.ShadowzGames.LD28.entity;

import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Sprite;

public class Entity extends SpriteContainer {
	public boolean removed;
	private int animationIndex;
	private int animationFrame;
	private boolean flipped;
	
	public Entity(Sprite prototype){
		super(prototype, prototype.getBoundingBox());
	}
	
	public void remove() {
		removed = true;
	}
	
	public void die() {
		remove();
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
}
