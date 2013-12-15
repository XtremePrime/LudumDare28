package com.ShadowzGames.LD28;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

import com.ShadowzGames.LD28.tile.AirTile;

public class SpriteFactory {
	protected SpriteSheet ss;
	protected Sprite[] loadedImages;
	final int heightCount;
	final int widthCount;
	public final Sprite empty = new Sprite(); // new AirTile();
	
	public SpriteFactory(SpriteSheet sheet) {
		ss = sheet;
		heightCount = ss.getVerticalCount();
		widthCount = ss.getHorizontalCount();
		loadedImages = new Sprite[heightCount*widthCount+1];
		empty.create(null, -1);
	}
	
	public Sprite GetTile(int id){
		return GetTile(id, AirTile.class);
	}
	
	public Sprite GetTile(int x, int y){
		return GetTile(x, y, AirTile.class);
	}
	
	public Sprite GetTile(int x, int y, int w, int h){
		return GetTile(x, y, w, h, AirTile.class);
	}
	
	/**
	 * 
	 * @param id ID for the tile, uses the reverse conversion of x*widthCount+y to calculate its position on the chart.
	 * @param type  A type of Tile that you expect to be created
	 * @return  The tile of the type you requested
	 */
	public <T extends Sprite> Sprite GetTile(int id, Class<T> type){
		if(id == 0){
			//- Returns a tile with a null image, for an empty space
			return GetTile(-1, -1, type);
		}
		else{
			id = id-1;
			int x = id % widthCount;
			int y = id / widthCount;
			return GetTile(x, y, type);
		}
	}
	
	/**
	 * 
	 * @param x  Indices from the left, starting with 0
	 * @param y  Indices from the top, starting with 0
	 * @param type  A type of Tile that you expect to be created
	 * @return  The tile of the type you requested
	 */
	public <T extends Sprite> Sprite GetTile(int x, int y, Class<T> type){
//		if(x < 0 || y < 0){
//			//- Returns a tile with a null image, for an empty space
//			return empty;
//		}
//		
//		int id = (x*widthCount+y)+1; //- Offset by one, to match with the GetTile(int id, Class<T> type) algorithm
//		if(id > loadedImages.length){
//			throw new IndexOutOfBoundsException("Couldn't load that an image outside the bounds of the spritesheet.");
//		}
//		if(loadedImages[id] == null){
//			Image temp = ss.getSubImage(x, y);
//			try {
//				loadedImages[id] = (Sprite)type.newInstance();
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//			loadedImages[id].create(temp, id);
//		}
		
		return GetTile(x, y, 1, 1, type);
	}
	
	/**
	 * Gets a mass of tiles into a single tile, excellent for bigger sprites.
	 * 
	 * @param x  Indices from the left, starting with 0
	 * @param y  Indices from the top, starting with 0
	 * @param width  Count of how many tiles wide sprite you want to get
	 * @param height  Count of how many tiles tall sprite you want to get
	 * @param type  A type of Tile that you expect to be created
	 * @return  The tile of the type you requested
	 */
	public <T extends Sprite> Sprite GetTile(int x, int y, int width, int height, Class<T> type){
		if(x < 0 || y < 0){
			//- Returns a tile with a null image, for an empty space
			return empty;
		}
		
		int id = (x*widthCount+y)+1; //- Offset by one, to match with the GetTile(int id, Class<T> type) algorithm
		if(id > loadedImages.length){
			throw new IndexOutOfBoundsException("Couldn't load that an image outside the bounds of the spritesheet.");
		}
		if(loadedImages[id] == null){
			Image temp = ss.getSubImage(x, y, width, height);
			try {
				loadedImages[id] = (Sprite)type.newInstance();
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


