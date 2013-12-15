package com.ShadowzGames.LD28.tile;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.Sprite;

public class Tile {
	
	protected Sprite prototype;
	protected Rectangle tileRect;
	//protected int w = 16, h = 16, x, y;
	
	//public static Tile[] tiles = new Tile[80*60];
	//public static Tile grass = new GrassTile(0);
	
	public Tile(Sprite prototype){
		this.prototype = prototype;
		this.tileRect = new Rectangle(0, 0, 16, 16); // default rectangle size
	}

	public void update(GameContainer gc, int delta){
		prototype.update(gc, delta);
	}
	
	final public void render(Graphics g){
		prototype.render(g, this.tileRect.getX(), this.tileRect.getY());
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}

	public <T extends Sprite> boolean isInstance(Class<T> other) {
		return other.isInstance(prototype);
	}
}
