package com.ShadowzGames.LD28.tile;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Tile {
	
	protected TilePrototype prototype;
	protected Rectangle tileRect;
	//protected int w = 16, h = 16, x, y;
	
	//public static Tile[] tiles = new Tile[80*60];
	//public static Tile grass = new GrassTile(0);
	
	public Tile(TilePrototype prototype){
		this.prototype = prototype;
		this.tileRect = new Rectangle(0, 0, 16, 16); // default rectangle size
	}

	final public void render(Graphics g){
		prototype.render(g, this.tileRect.getX(), this.tileRect.getY());
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}
	
}
