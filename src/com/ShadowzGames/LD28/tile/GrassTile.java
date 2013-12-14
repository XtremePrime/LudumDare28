package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GrassTile extends Tile{
	private Image img;
	
	public GrassTile(int id, int x, int y){
		super(id, x, y);
	}

	public void draw(Graphics g){
		img = sheet.getSubImage(0, 0, 16, 16);
		g.drawImage(img, this.x, this.y);
	}
	
	public int getID(){
		return 0;
	}
}
