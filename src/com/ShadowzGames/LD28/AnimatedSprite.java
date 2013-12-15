package com.ShadowzGames.LD28;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.entity.Entity;

public class AnimatedSprite extends Sprite {
	ArrayList<Animation> animation;
	int maxFrame = 0;
	//int currentRow = 0;
	//int currentFrame = 0;
	boolean automatic = false;
	@Override
	public void init(){
		if(img == null){
			return; //- Ignores sprites without images
		}
		animation = new ArrayList<Animation>();
		Rectangle bounds = getBoundingBox();
		final int x = 0;
		final int w = (int) (img.getWidth()/bounds.getWidth())-1;
		final int h = 0;
		final int height = (int) (img.getHeight()/bounds.getHeight());
		for(int y = 0; y < height; ++y){
			animation.add(new Animation(new SpriteSheet(img, (int)bounds.getWidth(), (int)bounds.getHeight()), x, y, w, h, false, 100, false));
		}
		maxFrame = w;
	}
	
	/**
	 * Sets durations to current row, using the durations in the int-array.
	 * Ignores calls to nextFrame when durations.length > 0.
	 * @param durations
	 */
	public void setDurations(Entity entity, int[] durations){
		setDurations(durations, entity.getAnimationIndex());
	}
	
	/**
	 * Set this method to make the animation run automatically, using the durations in the int-array. 
	 * Ignores calls to nextFrame when durations.length > 0.
	 * @param durations
	 * @param row Animation row to modify
	 */
	public void setDurations(int[] durations, int row){
		if(animation != null){
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
	}
	
	public void setAnimation(Entity entity, int row){
		entity.setAnimationIndex(row);
		entity.setAnimationFrame(0);
	}
	
	public void nextFrame(Entity entity){
		int frame =  entity.getAnimationFrame()+1;
		if(frame >= maxFrame){
			frame = 0;
		}
		entity.setAnimationFrame(frame);
	}
	
	@Override
	public void update(GameContainer gc, SpriteContainer sc, int delta){
		Entity entity;
		if(sc instanceof Entity){
			entity = (Entity)sc;
			if(animation != null){
				if(automatic){
					animation.get(entity.getAnimationIndex()).update(delta);
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g, SpriteContainer sc){
		Entity entity = null;
		if(sc instanceof Entity){
			entity = (Entity)sc;
			if(animation != null){
				if(automatic){
					animation.get(entity.getAnimationIndex()).draw(entity.getRect().getX(), entity.getRect().getY());
				}
				else{
					try{
						int frame = entity.getAnimationFrame();
						if(frame > maxFrame) frame = 0; //- Fixing potential index out of range problems by setting framecount to 0
						
						Image temp = animation.get(entity.getAnimationIndex()).getImage(frame);
						
						if(entity.isFlipped()) temp = temp.getFlippedCopy(true, false);
						
						temp.startUse();
						temp.drawEmbedded(entity.getRect().getX(), entity.getRect().getY());
						temp.endUse();
					}
					catch(IndexOutOfBoundsException e){
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
