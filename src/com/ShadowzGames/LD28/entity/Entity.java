package com.ShadowzGames.LD28.entity;

import org.newdawn.slick.geom.Rectangle;

public class Entity {
	public boolean removed;
	protected Rectangle rect;
	
	public void remove() {
		removed = true;
	}
	
	public Rectangle getRect(){
		return this.rect;
	}
}
