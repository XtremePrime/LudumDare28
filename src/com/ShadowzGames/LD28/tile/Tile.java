package com.ShadowzGames.LD28.tile;


import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Sprite;

public class Tile extends SpriteContainer {
	
	//protected Sprite prototype;
	//protected Rectangle tileRect;
	//protected int w = 16, h = 16, x, y;
	
	//public static Tile[] tiles = new Tile[80*60];
	//public static Tile grass = new GrassTile(0);
	
	public Tile(Sprite prototype){
		super(prototype, new Rectangle(0, 0, 16, 16));
		//this.prototype = prototype;
		//this.tileRect = new Rectangle(0, 0, 16, 16); // default rectangle size
	}

	
}
