package com.ShadowzGames.LD28;

import java.util.HashMap;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.ShadowzGames.LD28.tile.*;

public class Map {
	private final int TILE_ROW = 30, TILE_COL = 40, TILE_WIDTH=16, TILE_HEIGHT=16;
	public Tile[][] tiles = new Tile[TILE_COL][TILE_ROW];
	private TileFactory envFactory;
//	public int[][] tileSlot = new int[TILE_ROW][TILE_COL];
	private HashMap<Integer, TilePrototype> tileTypes;
	
	public Map(TileFactory environmentFactory){
		try {
			init(environmentFactory);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Don't mind this function, just doing some color to int conversion 
	 * using bit-manipulation (that I shamelessly stole from stackoverflow). xD
	 * @param color Expects a color from Slick2D
	 * @return An integer representing the color in ARGB, note only tracks full or no alpha.
	 */
	private int colorToARGB(Color color){
		int alpha = 0;
		if(color.getAlpha() != 0){
			alpha = 127 << 24;
		}
		final int red = (color.getRed() << 16) & 0xFF0000;
		final int green = (color.getGreen() << 8) & 0x00FF00;
		final int blue = (color.getBlue()) & 0x0000FF;
		return alpha | red | green | blue;
	}
	
	/**
	 * Loads a level from filename.
	 * @param filename
	 * @throws SlickException
	 * @throws IndexOutOfBoundsException
	 */
	public void loadLevel(String filename) throws SlickException, IndexOutOfBoundsException{
		Image level;
		level = new Image(filename);
		if(level.getWidth() != TILE_COL || level.getHeight() != TILE_ROW){
			throw new IndexOutOfBoundsException("Level size was wrong, got " + level.getWidth() + "x" + level.getHeight() + " expected " + TILE_COL + "x" + TILE_ROW);
		}
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				Color tempColor = level.getColor(i, k);
				System.out.println(colorToARGB(tempColor));
				TilePrototype tile = tileTypes.get(colorToARGB(tempColor));
				if(tile != null){
					tiles[i][k] = new Tile(tile);
				}
				else{
					tiles[i][k] = new Tile(tileTypes.get(0));
				}
			}
		}
		level.destroy();
	}

	public void init(TileFactory environmentFactory) throws SlickException {
		envFactory = environmentFactory;
		
		fillTileTypes();
		loadLevel("data/L1.png");
		//for(int i = 0; i < TILE_COL; ++i){
		//	for(int k = 0; k < TILE_ROW; ++k){
		//		tiles[i][k] = new Tile(envFactory.GetTile(1, GrassTile.class));
		//	}
		//}
		try {
			for(int i = 0; i < TILE_COL; ++i){
				for(int k = 0; k < TILE_ROW; ++k){
					tiles[i][k].getRect().setX(TILE_WIDTH * i);
					tiles[i][k].getRect().setY(TILE_HEIGHT * k);
				}
			}	
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}
	 
	private void fillTileTypes() {
		tileTypes = new HashMap<Integer, TilePrototype>();

		tileTypes.put(colorToARGB(new Color(0, 0, 0, 0)), envFactory.GetTile(0, AirTile.class));
		tileTypes.put(colorToARGB(new Color(0, 170, 0, 255)), envFactory.GetTile(1, GrassTile.class));
		tileTypes.put(colorToARGB(new Color(0, 170, 170, 255)), envFactory.GetTile(0, 1, GrassTile.class));
		tileTypes.put(colorToARGB(new Color(170, 85, 00, 255)), envFactory.GetTile(0, 2, GrassTile.class));
	}

	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		for(int i = 0; i < TILE_COL; ++i){
			for(int k = 0; k < TILE_ROW; ++k){
				g.drawRect(i * 16, k * 16, 16, 16);
				tiles[i][k].render(g);
			}
		}
	}

	public void setTile(int x, int y){
	}
	
	public void getTile(int x, int y){
	}
}
