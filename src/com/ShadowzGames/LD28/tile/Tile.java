package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Tile {
	
	protected Rectangle tileRect;
	protected int w = 16, h = 16, x, y;
	SpriteSheet sheet;
	
	private final int id;
	
	public Tile(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.tileRect = new Rectangle(x, y, this.w, this.h);
		
		try {
			this.sheet = new SpriteSheet("data/environment.png", 16, 16);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}
	
}
