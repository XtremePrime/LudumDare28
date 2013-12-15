package com.ShadowzGames.LD28.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.Direction;

public class Player extends Mob{
	
	private int enemiesKilled = 0;
	private int score = 0;
	private int wave = 0;
	private boolean isDead = false;
	
	public Player(int x, int y){
		this.health = 10;
		this.dir = 0;
		this.moveSpeed = 1;
		this.score = 0;
		this.wave = 0;
		this.isDead = false;
		
		this.rect = new Rectangle(x, y, 16, 32);
	}
	
	public void update(GameContainer gc, int delta){
		super.update(gc, delta);
	}
	
	/**
	 * The player's mobility function.
	 * @param gc - The GameContainer. A bit self explanatory
	 * @param delta - Still WIP, but it's the delta between current frame and last frame.
	 * 
	 * */
	public void move(GameContainer gc, int delta){
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
			
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP)){
			this.dir = Direction.UP;
			//TODO jump;
		}else if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)){
			this.dir = Direction.DOWN;
			//TODO crouch?;
		}else if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)){
			this.dir = Direction.LEFT;
			this.rect.setX(rect.getX() - moveSpeed);
		}else if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
			this.dir = Direction.RIGHT;
			this.rect.setX(rect.getX() + moveSpeed);
		}
	}
	
}
