package com.ShadowzGames.LD28.entity;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.ShadowzGames.LD28.Direction;
import com.ShadowzGames.LD28.Sound;
import com.ShadowzGames.LD28.SpriteContainer;

public class Player extends Mob{
	
	private int enemiesKilled = 0;
	private int score = 0;
	private int wave = 0;
	private int attackRange = 16;
	private int attackTime = 0;
	private boolean isAttacking = false;
	private Rectangle attackRect;
//	private boolean isDead = false;
//	private boolean isFalling = true;
//	private boolean isMoving = false;
//	private boolean isJumping = false;
	//private int dX, dY;
	
	private Random rand = new Random();
	
	public Player(){
		this.health = 10;
		this.dir = 0;
		this.moveSpeed = 1.6f;
		this.score = 0;
		this.wave = 0;
	}
	
	@Override
	public Rectangle getBoundingBox(){
		return new Rectangle(0,0,16,32);
	}
	
	@Override
	public void update(GameContainer gc, SpriteContainer sc, int delta){
		//super.update(gc, sc, delta); //- You don't need to run Mob's update as well, or you'll get double the gravity xD
		if(sc instanceof Entity){
			Entity entity = (Entity)sc;
			move(gc, entity, delta);
			if(isAttacking) attack(entity, delta, this.dir);
			if(entity.isJumping() || entity.isFalling()) gravity(entity, delta);
			//if(entity.isJumping() && !entity.isFalling()) jump(entity, delta);
		}
	}
	
	@Override
	public void render(Graphics g, SpriteContainer sc){
		super.render(g, sc);
		g.setColor(Color.magenta);
		//Attack debug purposes.
		if(isAttacking) g.fillRect(attackRect.getX(), attackRect.getY(), attackRect.getWidth(), attackRect.getHeight());
	}
	
	/**
	 * The player's mobility function.
	 * @param gc - The GameContainer. A bit self explanatory
	 * @param entity - The entity that's visible on the gameplan, requesting to move.
	 * @param delta - Still WIP, but it's the delta between current frame and last frame.
	 **/
	public void move(GameContainer gc, Entity entity, int delta){
		Input input = gc.getInput();
		entity.setMoving(false);
		Rectangle rect = entity.getRect();
		//Actions
		if(input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)){
			if(!entity.isJumping() && !entity.isFalling()){
				entity.setJumping(true);
				entity.setVelocityY(-40);
				Sound.JUMP.play();
				//jumpTime = 0;
			}
		}
		if(input.isKeyPressed(Input.KEY_SPACE) || input.isKeyPressed(Input.KEY_C)){
			if(!isAttacking){
				isAttacking = true;
				Sound.ATTACK.play();
			}
		}
		//Move Directions
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT)){
			this.dir = Direction.LEFT;
			rect.setX(rect.getX() - moveSpeed);
			entity.setMoving(true);
		}else if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT)){
			this.dir = Direction.RIGHT;
			rect.setX(rect.getX() + moveSpeed);
			entity.setMoving(true);
		}
		
		if(entity.isMoving() && !entity.isJumping() && !entity.isFalling()) animate(entity, delta);
		else if(entity.isJumping() && !entity.isFalling()){
			animateSingle(entity, 1, 2);
		}else if(!entity.isJumping() && entity.isFalling()){
			animateSingle(entity, 1, 3);
		}else if(!entity.isMoving() && !entity.isJumping() && !entity.isFalling()) setAnimation(entity, 0);
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
	
	private void animateSingle(Entity entity, int row, int frame) {
		if(previousDir != dir){
			if(previousDir == Direction.RIGHT && dir == Direction.LEFT ||
					previousDir == Direction.LEFT && dir == Direction.RIGHT){
				entity.flip();
				previousDir = dir;
			}
		}
		
		setAnimation(entity, row);
		setFrame(entity, frame);
	}

	@Override
	protected void gravity(Entity e, int delta){
		super.gravity(e, delta);
	}
	
	private int jumpTime = 0;
	public void jump(Entity entity, int delta){
		jumpTime += delta;
		Rectangle r = entity.getRect();
		float y1 = r.getY();
		//r.setY(y1 - (float) (jumpSpeed * jumpTime + gravity * Math.pow(jumpTime, 2)));
		//r.setY(r.getY() + moveSpeed);
		//entity.setDeltaY(y1 - r.getY());
		if(entity.getVelocityY() == 0){
			jumpTime = 0;
			entity.setJumping(false);
			entity.setFalling(true);
		}
	}
	
	public void attack(Entity e, int delta, int dir){
		attackTime += delta;
		if(dir == Direction.RIGHT) attackRect = new Rectangle(e.getRect().getX()+16, e.getRect().getY()+5, attackRange, 32-5);
		else if(dir == Direction.LEFT) attackRect = new Rectangle(e.getRect().getX()-16, e.getRect().getY()+5, attackRange, 32-5);
		
		if(attackTime >= 75){
			attackTime = 0; isAttacking = false;
			attackRect.setX(0); attackRect.setY(0); attackRect.setWidth(0); attackRect.setHeight(0); 
			return;
		}
	}
	
	private int getAttackDamage(){
		return rand.nextInt(3)+1;
	}
}
