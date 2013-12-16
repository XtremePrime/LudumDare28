package com.ShadowzGames.LD28;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.entity.Entity;

public class SpriteContainer {
	protected Rectangle rect;
	protected Sprite prototype;
	
	public SpriteContainer(Sprite prototype, Rectangle rect) {
		this.prototype = prototype;
		this.rect = rect;
	}
	
	public void update(GameContainer gc, int delta){
		prototype.update(gc, this, delta);
	}
	
	final public void render(Graphics g){
		prototype.render(g, this);
	}
	
	public boolean near(Rectangle other, float offset){
		
		final double a = this.rect.getBoundingCircleRadius() + other.getBoundingCircleRadius();
	    final double dx = this.rect.getX() - other.getX();
	    final double dy = this.rect.getY() - other.getY();
	    return a * a > (dx * dx + dy * dy - offset);
	}
	
	public boolean collide(Entity entity){
		if(prototype.isCollidable()){
			if(near(entity.getRect(), 5)){
				if(entity.getRect().intersects(this.rect)){
					// TODO check which side was collided on?
					return true;
				}
			}
		}
		return false;
	}
	
	public Rectangle getRect(){
		return this.rect;
	}

	public int getPrototypeID() {
		return prototype.getID();
	}

	public <T extends Sprite> boolean isInstance(Class<T> other) {
		return other.isInstance(prototype);
	}
}
