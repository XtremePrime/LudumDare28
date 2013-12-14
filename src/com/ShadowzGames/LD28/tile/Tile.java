package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Tile {
	
	protected Rectangle tileRect;
	protected int w = 16, h = 16, x, y;
	protected Image img;
	private final int id;
	
	//public static Tile[] tiles = new Tile[80*60];
	//public static Tile grass = new GrassTile(0);
	
	public Tile(Image img, int id) {
		this.img = img;
		this.id = id;
		//if (tiles[id] != null) throw new RuntimeException("Tile is already set!");
		//tiles[id] = this;
	}
	
	// Do not inherit this one, take the one below instead
	public void render(Graphics g){
		render(g, x, y);
	}
	
	public void render(Graphics g, int x, int y){
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}
	
}
