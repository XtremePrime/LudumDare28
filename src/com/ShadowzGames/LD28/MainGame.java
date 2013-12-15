package com.ShadowzGames.LD28;


import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import com.ShadowzGames.LD28.objectives.Objective;

import com.ShadowzGames.LD28.entity.Entity;
import com.ShadowzGames.LD28.entity.Player;


public class MainGame extends BasicGameState{

	private Map map;
	private Entity player;
	SpriteSheet envSheet, charSheet;
	Animation charAnim;
	String[] levelList;
	Objective[] objectiveList;
	long timer;
	int currentLevel = 0; 
	
	public MainGame(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		levelList = new String[]{"data/L1.png", "data/L2.png"};
		objectiveList = new Objective[]{Objective.KillAll, Objective.ReachStar};
		
		envSheet = new SpriteSheet("data/environment.png", 16, 16);
		charSheet = new SpriteSheet("data/characters.png", 16, 32);
		SpriteFactory environment = new SpriteFactory(envSheet);
		SpriteFactory characters = new SpriteFactory(charSheet);
		map = new Map(environment, levelList[currentLevel]);
		player = new Entity(characters.GetTile(0, 0, 5, 6, Player.class));
		resetTimer();
	}
	public void resetTimer(){
		timer = 60000L;
	}
	
	public void levelUp(){
		if(currentLevel + 1 < levelList.length){
			currentLevel++;
		}
		else{
			//TODO VICTORY!! Player passed all levels.
		}
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString(""+(timer/1000), 20, 5);
		map.draw(g);
		player.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		timer -= delta;
		map.update(gc,delta);
		player.update(gc, delta);
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
