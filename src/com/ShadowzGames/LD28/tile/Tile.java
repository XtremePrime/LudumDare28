package com.ShadowzGames.LD28.tile;


import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Sprite;

public class Tile extends SpriteContainer { 
	
	public Tile(Sprite prototype){
		super(prototype, new Rectangle(0, 0, 16, 16));
	}
	
}