package com.ShadowzGames.LD28;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class MainGame extends BasicGameState{

	private Map map;
	//private Player player;
	SpriteSheet envSheet, charSheet;
	
	public MainGame(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		envSheet = new SpriteSheet("data/environment.png", 16, 16);
		charSheet = new SpriteSheet("data/characters.png", 16, 32);
		SpriteFactory environment = new SpriteFactory(envSheet);
		SpriteFactory characters = new SpriteFactory(charSheet);
		map = new Map(environment);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 1;
	}
}
