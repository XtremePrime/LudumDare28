package com.ShadowzGames.LD28.tile;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

abstract public class TilePrototype {

	protected Image img;
	protected boolean created = false;
	private int id;
	
	abstract protected void init();
	
	final public void create(Image img, int id){
		if(this.created) 
			Logger.getLogger("LudumDareLog").log(
					Level.WARNING, "The tile had already been created, make sure to not call the create function too often.", this);
		this.img = img;
		this.id = id;
		this.created = true;
		init();
		//if (tiles[id] != null) throw new RuntimeException("Tile is already set!");
		//tiles[id] = this;
		
	}
	
	public int getID(){
		return id;
	}
	
	protected void render(Graphics g, float x, float y){
	}
}
