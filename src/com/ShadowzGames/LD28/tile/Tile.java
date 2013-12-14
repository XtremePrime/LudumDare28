package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Tile {
	
	protected Rectangle tileRect;
	protected int w = 16, h = 16, x, y;
	protected SpriteSheet ss;
	private final int id;
	
	public static Tile[] tiles = new Tile[80*60];
	public static Tile grass = new GrassTile(0);
	
	public Tile(int id) {
		this.id = id;
		if (tiles[id] != null) throw new RuntimeException("Tile is already set!");
		tiles[id] = this;
	}
	
	public void render(Graphics g, int x, int y){
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}
	
}
