package com.ShadowzGames.LD28;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.ShadowzGames.LD28.tile.*;

public class Map {
	private final int TILE_ROW = 2, TILE_COL = 3, TILE_WIDTH=16, TILE_HEIGHT=16;
	public Tile[][] tiles = new Tile[TILE_COL][TILE_ROW];
	private TileFactory envFactory;
//	public int[][] tileSlot = new int[TILE_ROW][TILE_COL];
	
	public Map(TileFactory environmentFactory){
		try {
			init(environmentFactory);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void init(TileFactory environmentFactory) throws SlickException {
		envFactory = environmentFactory;
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				tiles[i][k] = envFactory.GetTile(0);
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
