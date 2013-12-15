package com.ShadowzGames.LD28;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
public class Main extends StateBasedGame
{
	public static final float WIDTH = 640;
	public static final float HEIGHT = 480;
	public static final String TITLE = "You Only Get One";
	
	public static final int MAIN_MENU = 0;
	public static final int MAIN_GAME = 1;
	
	public Main(String title) {
		super(title);
		
		//this.addState(new MainMenu(MAIN_MENU));
		this.addState(new MainGame(MAIN_GAME));
	}
 
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.enterState(MAIN_GAME);
	}
 
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new Main(TITLE));
 
		app.setDisplayMode((int)WIDTH, (int)HEIGHT, false);
		app.setTargetFrameRate(60);
		app.setShowFPS(true);
		app.start();
  	}
}