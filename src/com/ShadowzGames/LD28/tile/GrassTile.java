package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.Graphics;

import com.ShadowzGames.LD28.Sprite;
import com.ShadowzGames.LD28.SpriteContainer;

public class GrassTile extends Sprite{

	@Override
	protected void init(){
	}
	
	@Override
	public boolean isCollidable(){
		return true;
	}

	@Override
	public void render(Graphics g, SpriteContainer sc){
		super.render(g, sc);
	}
}
