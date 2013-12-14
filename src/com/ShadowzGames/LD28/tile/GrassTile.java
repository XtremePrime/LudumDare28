package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class GrassTile extends Tile{
	
	public GrassTile(Image image, int id){
		super(image, id);
	}

	@Override
	public void render(Graphics g, int x, int y){
		img.drawEmbedded(x, y);
	}
	
	public int getID(){
		return 0;
	}
}
