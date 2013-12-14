package com.ShadowzGames.LD28;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.tile.*;

public class Map {
	private final int TILE_ROW = 2, TILE_COL = 3, TILE_WIDTH=16, TILE_HEIGHT=16;
	public Tile[][] tiles = new Tile[TILE_COL][TILE_ROW];
//	public int[][] tileSlot = new int[TILE_ROW][TILE_COL];
	SpriteSheet sheet;
	
	public Map(SpriteSheet sheet){
		this.sheet = sheet;
		try {
			init();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void init() throws SlickException {
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				tiles[i][k] = new Tile(0);
			}
		}
		
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				tiles[i][k].getRect().setX(TILE_WIDTH * i);
				tiles[i][k].getRect().setY(TILE_HEIGHT * k);
			}
		}
	}
	
	public void draw(Graphics g) {
	}

	public void setTile(int x, int y){
	}
	
	public void getTile(int x, int y){
	}
}
