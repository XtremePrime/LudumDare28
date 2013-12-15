package com.ShadowzGames.LD28;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

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
	
	public Rectangle getRect(){
		return this.rect;
	}

	public <T extends Sprite> boolean isInstance(Class<T> other) {
		return other.isInstance(prototype);
	}
}
