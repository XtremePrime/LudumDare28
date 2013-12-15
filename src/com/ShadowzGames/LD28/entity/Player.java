package com.ShadowzGames.LD28.entity;

import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.Direction;
import com.ShadowzGames.LD28.SpriteContainer;

public class Player extends Mob{
	
	private int enemiesKilled = 0;
	private int score = 0;
	private int wave = 0;
	private boolean isDead = false;
	private boolean isFalling = false;
	private boolean isMoving = false;
	private boolean isJumping = false;
	private int dX, dY;
	
	private Random rand = new Random();
	
	public Player(){
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
			if(!isJumping && isFalling) gravity((Entity)sc);
			if(isJumping && !isFalling) jump((Entity) sc);
		}
	}
	
	@Override
	public void render(Graphics g, SpriteContainer sc){
		super.render(g, sc);
	}
	
	/**
	 * The player's mobility function.
	 * @param gc - The GameContainer. A bit self explanatory
	 * @param entity - The entity that's visible on the gameplan, requesting to move.
	 * @param delta - Still WIP, but it's the delta between current frame and last frame.
	 **/
	public void move(GameContainer gc, Entity entity, int delta){
		Input input = gc.getInput();
		isMoving = false;

		Rectangle rect = entity.getRect();
//		if((input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)) &&
//			(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))){
//			isJumping = true;
//			dY = -65;
//			return;
//		}else if((input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)) &&
//			(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))){
//			isJumping = true;
//			dY = -65;
//			return;
//		}
//		
		if(input.isKeyPressed(Input.KEY_SPACE) || input.isKeyPressed(Input.KEY_W)){
			if(!isJumping && !isFalling){
				isJumping = true;
				dY = -65;
			}
		}
		
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)){
			this.dir = Direction.DOWN;
			//TODO crouch?; 
			//XXX I don't think we'll need crouch, but maybe add tiles that can be dropped through by pushing down?
		}else if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)){
			this.dir = Direction.LEFT;
			rect.setX(rect.getX() - moveSpeed);
			isMoving = true;
		}else if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
			this.dir = Direction.RIGHT;
			rect.setX(rect.getX() + moveSpeed);
			isMoving = true;
		}
		
		if(isMoving) animate(entity, delta);
		else setAnimation(entity, 0);
	}
	
	int combinedDelta = 0;
	int previousDir = Direction.RIGHT;
	private void animate(Entity entity, int delta) {
		combinedDelta += delta;
		if(previousDir != dir){
			if(previousDir == Direction.RIGHT && dir == Direction.LEFT ||
					previousDir == Direction.LEFT && dir == Direction.RIGHT){
				entity.flip();
				previousDir = dir;
			}
		}
		if(combinedDelta > 140){
			nextFrame(entity);
			combinedDelta = 0;
		}
	}

	private void gravity(Entity e){
		Rectangle rect = e.getRect();
		if(rect.getY() < 400) rect.setY(rect.getY() + moveSpeed*2);
		else isFalling = false;
	}
	
	public void jump(Entity sc){
		Rectangle r = sc.getRect();
		r.setY(r.getY()-(moveSpeed+1));
		dY++;
		if(dY == 0){
			isJumping = false;
			isFalling = true;
		}
	}
	
	public void attack(){
		int range = 12;
	}
	
	private int getAttackDamage(){
		return rand.nextInt(3)+1;
	}
}
