package com.ShadowzGames.LD28;


import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.ShadowzGames.LD28.rules.Objective;
import com.ShadowzGames.LD28.rules.Spawner;
import com.ShadowzGames.LD28.entity.Entity;
import com.ShadowzGames.LD28.entity.Mob;
import com.ShadowzGames.LD28.entity.Player;


public class MainGame extends BasicGameState{

	private Map map;
	private Random rng = new Random();
	SpriteSheet envSheet, charSheet;
	Animation charAnim;
	String[] levelList;
	String[] backgroundList;
	Objective[] objectiveList;
	Spawner[] spawnerList;
	Image currentBackground; 
	long timer;
	long mobTimer;
	int currentLevel = 0; 
	SpriteFactory environment;
	SpriteFactory characters;
	
	public MainGame(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		levelList = new String[]{"data/L1.png", "data/L2.png"};
		backgroundList = new String[]{"data/L1Back.png", "data/L1Back.png"};
		objectiveList = new Objective[]{Objective.KillAll, Objective.ReachStar};
		spawnerList = new Spawner[]{Spawner.Random, Spawner.Random};
		
		envSheet = new SpriteSheet("data/environment.png", 16, 16);
		charSheet = new SpriteSheet("data/characters.png", 16, 32);
		environment = new SpriteFactory(envSheet);
		characters = new SpriteFactory(charSheet);
		map = new Map(environment, characters, levelList[currentLevel]);
		currentBackground = new Image(backgroundList[currentLevel]);
		resetTimer();
	}
	public void resetTimer(){
		timer = 60000L;
		mobTimer = 0L;
	}
	
	public void levelUp(){
		if(currentLevel + 1 < levelList.length){
			currentLevel++;
			try {
				map = new Map(environment, characters, levelList[currentLevel]);
				currentBackground = new Image(backgroundList[currentLevel]);
			} catch (SlickException e) {
				
			}
		}
		else{
			//TODO VICTORY!! Player passed all levels.
		}
	}
	
	public void mobSpawner(){
		Sprite[] mobList = new Sprite[]{ 
				characters.GetTile(4, 0, 5, 1, Mob.class), //- Robo-Slug
				characters.GetTile(4, 1, 5, 1, Mob.class)  //- Slime-warrior
				};
		
		Spawner spawn = spawnerList[currentLevel];
		boolean dospawn = false;
		if(mobTimer > spawn.getMinDelay()){
			if(mobTimer > spawn.getMaxDelay()){
				dospawn = true;
			}
			if(Math.abs(rng.nextInt()) % (15 - spawn.getDificulty()) == 0){
				dospawn = true;
			}
		}
		
		if(dospawn){
			spawn.spawnMob(mobList, map);
			mobTimer = 0;
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(""+(timer/1000), 20, 5);
		
		currentBackground.startUse();
		currentBackground.drawEmbedded(0, 0);
		currentBackground.endUse();
		map.draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		mobTimer += delta;
		timer -= delta;
		
		mobSpawner();
		
		map.update(gc,delta);
		if(objectiveList[currentLevel].isRequirementMet(map)){
			// TODO Level win handling!!
		}
		if(timer < 0){
			// TODO Timeout handling!!
		}
		
//		player.getRect().intersects(map.tiles[1][1].getRect())
	}

	@Override
	public int getID() {
		return 1;
	}
}
