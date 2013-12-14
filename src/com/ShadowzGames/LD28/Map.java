package com.ShadowzGames.LD28;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.tile.*;

public class Map {
	private final int TILE_ROW = 2, TILE_COL = 3, TILE_WIDTH=16, TILE_HEIGHT=16;
	public Tile[][] tiles = new Tile[TILE_COL][TILE_ROW];
//	public int[][] tileSlot = new int[TILE_ROW][TILE_COL];	
	
	public Map(){
		int id = 0;
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				tiles[i][k] = new Tile(id, TILE_WIDTH*i, TILE_HEIGHT*k);
				id++;
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
		g.setColor(Color.magenta);
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				g.drawRect(tiles[i][k].getRect().getX(), tiles[i][k].getRect().getY(), TILE_WIDTH, TILE_HEIGHT);
			}
		}
	}

//	public void setTile(int x, int y){	
//	}
//	
//	public void getTile(int x, int y){
//	}
}
