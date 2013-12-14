package com.ShadowzGames.LD28.tile;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class TileFactory {
	protected SpriteSheet ss;
	protected Tile[] loadedImages; 
	final int heightCount;
	final int widthCount;
	public final Tile empty =  new Tile(null, -1);
	public TileFactory(SpriteSheet sheet) {
		ss = sheet;
		heightCount = ss.getVerticalCount();
		widthCount = ss.getHorizontalCount();
		loadedImages = new Tile[heightCount*widthCount+1];
	}
	
	public Tile GetTile(int id){
		if(id == 0){
			//- 0 Returns a tile with a null image, for an empty space
			return GetTile(-1, -1);
		}
		else{
			int x = id % widthCount;
			int y = id / widthCount;
			return GetTile(x, y);
		}
	}
	
	public Tile GetTile(int x, int y){
		if(x < 0 || y < 0){
			//- 0 Returns a tile with a null image, for an empty space
			return empty;
		}
		int id = (x*widthCount+y);
		if(id > loadedImages.length){
			throw new IndexOutOfBoundsException("Couldn't load that an image outside the bounds of the spritesheet.");
		}
		if(loadedImages[id] == null){
			Image temp = ss.getSubImage(x, y);
			loadedImages[id] = new Tile(temp, id);
		}
		
		return loadedImages[id];
	}
}
