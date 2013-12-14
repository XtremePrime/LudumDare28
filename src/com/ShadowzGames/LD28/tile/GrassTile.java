package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class GrassTile extends Tile{

	@Override
	protected void init(){
	}

	@Override
	public void render(Graphics g, float x, float y){
		img.startUse();
		  img.drawEmbedded(x, y);
		  img.endUse();
	}
	
	public int getID(){
		return 0;
	}
}
