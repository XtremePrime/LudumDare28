package com.ShadowzGames.LD28;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.tile.*;

public class Map {
	private final int TILE_ROW = 30, TILE_COL = 15;
	public Tile[][] tiles = new Tile[TILE_COL][TILE_ROW];
//	public int[][] tileSlot = new int[TILE_ROW][TILE_COL];	
	
	public Map(){
		int id = 0;
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				tiles[i][k] = new Tile(id, 16*i, 16*k);
				id++;
			}
		}
		
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				tiles[i][k].getRect().setX(16 * i);
				tiles[i][k].getRect().setY(16 * k);
			}
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				g.drawRect(tiles[i][k].getRect().getX(), tiles[i][k].getRect().getY(), 16, 16);
			}
		}
	}

	public void setTile(int x, int y){
	}
	
	public void getTile(int x, int y){
	}
}
