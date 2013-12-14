package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class GrassTile extends Tile{
	private Image img;
	
	public GrassTile(int id){
		super(id);
	}

	public void draw(Graphics g){
		ss.getSubImage(0, 0, 16, 16).drawEmbedded(this.x, this.y);
	}
	
	public int getID(){
		return 0;
	}
}
