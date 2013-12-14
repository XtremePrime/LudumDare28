package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GrassTile extends Tile{

	@Override
	public void init(){
	}

	@Override
	public void render(Graphics g, int x, int y){
		img.drawEmbedded(x, y);
	}
	
	public int getID(){
		return 0;
	}
}
