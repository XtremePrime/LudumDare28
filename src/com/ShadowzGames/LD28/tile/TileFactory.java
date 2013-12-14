package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class TileFactory {
	protected SpriteSheet ss;
	protected Tile[] loadedImages;
	final int heightCount;
	final int widthCount;
	public final Tile empty =  new AirTile();
	public TileFactory(SpriteSheet sheet) {
		ss = sheet;
		heightCount = ss.getVerticalCount();
		widthCount = ss.getHorizontalCount();
		loadedImages = new Tile[heightCount*widthCount+1];
		empty.create(null, -1);
	}
	
	public Tile GetTile(int id){
		return GetTile(id, AirTile.class);
	}
	
	public Tile GetTile(int x, int y){
		return GetTile(x, y, AirTile.class);
	}
	
	public <T extends Tile> Tile GetTile(int id, Class<T> type){
		if(id == 0){
			//- Returns a tile with a null image, for an empty space
			return GetTile(-1, -1, type);
		}
		else{
			int x = id % widthCount;
			int y = id / widthCount;
			return GetTile(x, y, GrassTile.class);
		}
	}
	
	public <T extends Tile> Tile GetTile(int x, int y, Class<T> type){
		if(x < 0 || y < 0){
			//- Returns a tile with a null image, for an empty space
			return empty;
		}
		
		int id = (x*widthCount+y);
		if(id > loadedImages.length){
			throw new IndexOutOfBoundsException("Couldn't load that an image outside the bounds of the spritesheet.");
		}
		if(loadedImages[id] == null){
			Image temp = ss.getSubImage(x, y);
			try {
				loadedImages[id] = (Tile)type.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			loadedImages[id].create(temp, id);
		}
		
		return loadedImages[id];
	}
}
