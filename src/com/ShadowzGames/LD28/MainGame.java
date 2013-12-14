package com.ShadowzGames.LD28;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends BasicGameState{

	private Map map;
	SpriteSheet sheet;
	
	public MainGame(int state){
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		sheet = new SpriteSheet("data/environment.png", 16, 16);
		map = new Map(sheet);
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
