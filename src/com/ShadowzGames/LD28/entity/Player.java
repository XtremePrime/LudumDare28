package com.ShadowzGames.LD28.entity;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.Direction;
import com.ShadowzGames.LD28.SpriteContainer;

public class Player extends Mob{
	
	private int enemiesKilled = 0;
	private int score = 0;
	private int wave = 0;
	private boolean isDead = false;
	
	private Random rand = new Random();
	
	public Player(int x, int y){
		this.health = 10;
		this.dir = 0;
		this.moveSpeed = 1;
		this.score = 0;
		this.wave = 0;
		this.isDead = false;
	}
	
	@Override
	public Rectangle getBoundingBox(){
		return new Rectangle(0,0,16,32);
	}
	
	@Override
	public void update(GameContainer gc, SpriteContainer sc, int delta){
		super.update(gc, sc, delta);
		if(sc instanceof Entity){
			move(gc, (Entity)sc, delta);
		}
	}
	
	/**
	 * The player's mobility function.
	 * @param gc - The GameContainer. A bit self explanatory
	 * @param delta - Still WIP, but it's the delta between current frame and last frame.
	 * 
	 * */
	public void move(GameContainer gc, Entity entity, int delta){
		Input input = gc.getInput();
		/*Will use for the weapon direction, no point yet.*/
		//TODO weapon dir;
//		if((input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) &&
//			(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))){
//			this.dir = Direction.UP_RIGHT;
//			this.rect.setX(rect.getX() + moveSpeed); // Moving right, Pointing up-right
//			return;
//		}else if((input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)) &&
//			(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))){
//			this.dir = Direction.UP_LEFT;
//			this.rect.setX(rect.getX() - moveSpeed); // Moving left, Pointing up-left
//			return;
//		}
//		if((input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) &&
//			(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))){
//			this.dir = Direction.DOWN_RIGHT;
//			this.rect.setX(rect.getX() + moveSpeed); // Moving right, Pointing down-right
//			return;
//		}else if((input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)) &&
//			(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))){
//			this.dir = Direction.DOWN_LEFT;
//			this.rect.setX(rect.getX() - moveSpeed); // Moving left, Pointing down-left
//			return;
//		}
		Rectangle rect = entity.getRect();
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)){
			this.dir = Direction.UP;
			//TODO jump;
		}else if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)){
			this.dir = Direction.DOWN;
			//TODO crouch?; 
			//XXX I don't think we'll need crouch, but maybe add tiles that can be dropped through by pushing down?
		}else if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)){
			this.dir = Direction.LEFT;
			rect.setX(rect.getX() - moveSpeed);
		}else if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
			this.dir = Direction.RIGHT;
			rect.setX(rect.getX() + moveSpeed);
		}
	}
	
	public void jump(){
		//TODO jump 48/64
	}
	
	public void attack(){
		int range = 12;
	}
	
	private int getAttackDamage(){
		return rand.nextInt(3)+1;
	}
}
