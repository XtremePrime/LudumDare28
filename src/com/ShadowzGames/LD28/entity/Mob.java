package com.ShadowzGames.LD28.entity;

import org.newdawn.slick.GameContainer;

import com.ShadowzGames.LD28.Direction;

public class Mob extends Entity{
	protected int moveSpeed = 1;
	protected int dir = 0;
	protected int hurtTime = 0;
	protected int xKnockback, yKnockback;
	protected int maxHealth = 10;
	protected int health = maxHealth;
	protected int tickCount = 0;
	
	public Mob() {
	}

	public void update(GameContainer gc, int delta) {
		tickCount++;
		if (health <= 0) {
			die();
		}
		if (hurtTime > 0) hurtTime--;
	}

	public void knockback(int dir, int dist){
		switch(dir){
			case Direction.RIGHT:{
				rect.setX(rect.getX()-dist);
			}break;
			case Direction.LEFT:{
				rect.setX(rect.getX()+dist);
			}break;	
		}
	}
	
	public void hurt(Mob mob, int dmg, int dir){
		doHurt(dmg, dir);
	}
	
	/**
	 * The "GET PWNED" method
	 * @param dmg - Damage received
	 * @param dir - Direction of the mob/player
	 */
	public void doHurt(int dmg, int dir){
		knockback(dir, 3);
		health -= dmg;
		hurtTime = 10;
	}
	
	public void die() {
		remove();
	}
}
