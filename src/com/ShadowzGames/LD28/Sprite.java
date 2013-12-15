package com.ShadowzGames.LD28;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Sprite {
		
	protected Image img;
	protected boolean created = false;
	private int id;
	
	protected void init(){
		
	
	}
	
	final public void create(Image img, int id){
		if(this.created) 
			Logger.getLogger("LudumDareLog").log(
					Level.WARNING, "The tile had already been created, make sure to not call the create function too often.", this);
		this.img = img;
		this.id = id;
		this.created = true;
		init();
	}
	
	public int getID(){
		return id;
	}
	
	public void render(Graphics g, float x, float y){
	}
	
	public void update(GameContainer gc, int delta){
	}
	
}
