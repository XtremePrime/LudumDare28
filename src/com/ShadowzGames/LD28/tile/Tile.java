package com.ShadowzGames.LD28.tile;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public abstract class Tile {
	
	protected Rectangle tileRect;
	//protected int w = 16, h = 16, x, y;
	protected Image img;
	protected boolean created = false;
	private int id;
	
	//public static Tile[] tiles = new Tile[80*60];
	//public static Tile grass = new GrassTile(0);
	
	protected Tile(){}
	
	abstract protected void init();
	
	final public void create(Image img, int id){
		if(this.created) 
			Logger.getLogger("LudumDareLog").log(
					Level.WARNING, "The tile had already been created, make sure to not call the create function too often.", this);
		this.img = img;
		this.id = id;
		tileRect = new Rectangle(0, 0, 16, 16); // default rectangle size
		this.created = true;
		init();
		//if (tiles[id] != null) throw new RuntimeException("Tile is already set!");
		//tiles[id] = this;
		
	}
	
	public int getID(){
		return id;
	}

	final public void render(Graphics g){
		render(g, tileRect.getX(), tileRect.getY());
	}
	
	protected void render(Graphics g, float x, float y){
	}
	
	public Rectangle getRect(){
		return this.tileRect;
	}
	
}
