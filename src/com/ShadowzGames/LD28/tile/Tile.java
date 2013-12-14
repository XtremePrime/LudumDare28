package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.geom.Rectangle;

public class Tile {
	
	private Rectangle tileRect;
	private int w = 16, h = 16;
	
	private final int id;
	
	public Tile(int id, int x, int y) {
		this.id = id;
		this.tileRect = new Rectangle(x, y, this.w, this.h);
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}
	
}
