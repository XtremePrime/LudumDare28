package com.ShadowzGames.LD28.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.AnimatedSprite;
import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Direction;

public class Mob extends AnimatedSprite{
	protected float moveSpeed = 0.1f;
	protected int dir = 0;
	protected int hurtTime = 0;
	protected int xKnockback, yKnockback;
	protected int maxHealth = 10;
	protected int health = maxHealth;
	protected int tickCount = 0;
	
	protected boolean isDead = false;
	protected boolean isFalling = true;
	protected boolean isMoving = false;
	protected boolean isJumping = false;
	
	public Mob() {
	}

	@Override
	public void update(GameContainer gc, SpriteContainer sc, int delta) {
		super.update(gc, sc, delta);
		tickCount++;
		if(sc instanceof Entity){
			Entity entity = (Entity)sc;
			if(isFalling) gravity((Entity)sc);
			if (health <= 0) {
				entity.die();
			}
			if (hurtTime > 0) hurtTime--;
		}
	}

	public void knockback(Entity sc, int dir, int dist){
		Rectangle rect = sc.getRect();
		switch(dir){
			case Direction.RIGHT:{
				rect.setX(rect.getX()-dist);
			}break;
			case Direction.LEFT:{
				rect.setX(rect.getX()+dist);
			}break;	
		}
	}
	
	public void hurt(Entity mob, int dmg, int dir){
		doHurt(mob, dmg, dir);
	}
	
	/**
	 * The "GET PWNED" method
	 * @param dmg - Damage received
	 * @param dir - Direction of the mob/player
	 */
	public void doHurt(Entity sc, int dmg, int dir){
		knockback(sc, dir, 3);
		health -= dmg;
		hurtTime = 10;
	}
	
	@Override
	public void render(Graphics g, SpriteContainer sc){
		super.render(g, sc);
	}
	
	protected void gravity(Entity e){
		Rectangle rect = e.getRect();
		if(rect.getY() < 400) rect.setY(rect.getY() + moveSpeed*2);
		else isFalling = false;
	}
}
