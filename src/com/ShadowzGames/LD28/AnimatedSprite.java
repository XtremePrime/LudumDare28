package com.ShadowzGames.LD28;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class AnimatedSprite extends Sprite {
	ArrayList<Animation> animation;
	int currentRow = 0;
	int currentFrame = 0;
	boolean automatic = false;
	@Override
	public void init(){
		if(img == null){
			return; //- Ignores sprites without images
		}
		animation = new ArrayList<Animation>();
		Rectangle bounds = getBoundingBox();
		for(int i = 0; i < img.getHeight() / bounds.getHeight(); ++i){
			int x = 0;
			int y = i;
			int w = (int) (img.getWidth() / bounds.getWidth());
			int h = i;
			animation.add(new Animation(new SpriteSheet(img, x, y), x, y, w, h, false, 0, false));
		}
	}
	
	/**
	 * Sets durations to current row, using the durations in the int-array.
	 * Ignores calls to nextFrame when durations.length > 0.
	 * @param durations
	 */
	public void setDurations(int[] durations){
		setDurations(durations, currentRow);
	}
	
	/**
	 * Set this method to make the animation run automatically, using the durations in the int-array. 
	 * Ignores calls to nextFrame when durations.length > 0.
	 * @param durations
	 * @param row Animation row to modify
	 */
	public void setDurations(int[] durations, int row){
		if(durations.length == 0){
			automatic = false;
		}
		else{
			for (int k = 0; k < durations.length; k++) {
				animation.get(row).setDuration(k, durations[k]);
			}
			automatic = true;
		}
	}
	
	public void setAnimation(int row){
		currentRow = row;
		currentFrame = 0;
	}
	
	public void nextFrame(){
		++currentFrame;
	}
	
	@Override
	public void update(GameContainer gc, SpriteContainer sc, int delta){
		if(automatic){
			animation.get(currentRow).update(delta);
		}
	}
	
	@Override
	public void render(Graphics g, float x, float y){
		if(automatic){
			animation.get(currentRow).draw(x, y);
		}
		else{
			animation.get(currentRow).getImage(currentFrame);
		}
	}
}
