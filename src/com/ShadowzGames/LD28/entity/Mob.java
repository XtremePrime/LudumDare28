package com.ShadowzGames.LD28.entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.AnimatedSprite;
import com.ShadowzGames.LD28.SpriteContainer;
import com.ShadowzGames.LD28.Direction;
import com.ShadowzGames.LD28.tile.Tile;

public class Mob extends AnimatedSprite{
	protected final float gravity = 0.005f;
	protected float moveSpeed = 1f;
	protected float jumpSpeed = 0.01f;
	protected int dir = 0;
	protected int hurtTime = 0;
	protected int xKnockback, yKnockback;
	protected int maxHealth = 10;
	protected int health = maxHealth;
	protected int tickCount = 0;
	
	public Mob() {
	}

	@Override
	public void update(GameContainer gc, SpriteContainer sc, int delta) {
		super.update(gc, sc, delta);
		tickCount++;
		if(sc instanceof Entity){
			Entity entity = (Entity)sc;
			if(entity.isFalling() || !entity.isColliding()) gravity(entity, delta);
			if (health <= 0) {
				entity.die();
			}
			if (hurtTime > 0) hurtTime--;
			entity.setColliding(false);
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
	//int fallTime = 0;
	protected void gravity(Entity e, int delta){
		//fallTime += delta;
		Rectangle rect = e.getRect();
		float vel = e.getVelocityY();
		if(rect.getY() < 400 || vel <= 0){ //rect.setY(rect.getY() + moveSpeed);
			float y1 = rect.getY();
			rect.setY(y1 + (float) (vel * delta * jumpSpeed));
			e.setVelocityY((float) (vel + gravity * Math.pow(delta, 2)));
			if(e.isJumping() && e.getVelocityY() >= 0 ){
				e.setJumping(false);
				e.setFalling(true);
			}
			//rect.setY(y1 + (float) (jumpSpeed * fallTime + gravity * Math.pow(fallTime, 2)));
			//e.setVelocityY(y1 - rect.getY());
		}
		else{
			//fallTime = 0;
			setAnimation(e, 0); setFrame(e, 0);
			e.setVelocityY(0);
			e.setFalling(false);
		}
	}

	@Override
	public void collidedWith(Entity self, SpriteContainer other){
		if(other instanceof Tile){
			Tile tile = (Tile)other;
//			float playerbottom = self.getRect().getY()+self.getRect().getHeight();
//			float tiletop = tile.getRect().getY();
			Point tiletopleft = new Point(tile.getRect().getX(), tile.getRect().getY());
			Point tiletopright = new Point(tile.getRect().getX() + tile.getRect().getWidth(), tile.getRect().getY());
			Rectangle mobrect = tile.getRect();
			if(mobrect.contains(tiletopright) || mobrect.contains(tiletopleft)){
				if(self.getVelocityY() > 0){
					//- All top collisions
					self.setVelocityY(0);
					self.setJumping(false);
					self.setFalling(false);
					self.getRect().setY(tiletopleft.getY() - self.getRect().getHeight() + 4);
				}
				if(self.getVelocityX() > 0){
					// TODO Implement sideblocking!
					self.setVelocityX(0);
					self.setMoving(false);
				}
			}
			self.setColliding(true);
		}
	}
}
