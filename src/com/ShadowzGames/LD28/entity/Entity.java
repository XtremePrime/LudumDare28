package com.ShadowzGames.LD28.entity;

import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Sprite;

public class Entity extends SpriteContainer {
	public boolean removed;
	
	public Entity(Sprite prototype){
		super(prototype, prototype.getBoundingBox());
	}
	
	public void remove() {
		removed = true;
	}
	
	public void die() {
		remove();
	}
}
