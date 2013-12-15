package com.ShadowzGames.LD28;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class Sprite {
		
	protected Image img;
	protected boolean created = false;
	private int id;
	
	protected void init(){
		
	
	}
	
	//- Override this function to set default size of the sprite
	public Rectangle getBoundingBox(){
		return new Rectangle(0,0,16,16);
	}
	
	final public void create(Image img, int id){
		if(this.created) 
			Logger.getLogger("LudumDareLog").log(
					Level.WARNING, "The tile had already been created, make sure to not call the create function too often, may cause weird bugs.", this);
		this.img = img;
		this.id = id;
		this.created = true;
		init();
	}
	
	public int getID(){
		return id;
	}
	
	public void render(Graphics g, SpriteContainer sc){
		if(img != null){
			img.startUse();
			img.drawEmbedded(sc.getRect().getX(), sc.getRect().getY());
			img.endUse();
		}
	}
	
	public void update(GameContainer gc, SpriteContainer sc, int delta){
		
	}
}
