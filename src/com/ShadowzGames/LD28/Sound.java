package com.ShadowzGames.LD28;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sound {

	public static final Sound JUMP = new Sound("data/sfx/jump.wav", "WAV");
	public static final Sound ATTACK = new Sound("data/sfx/hit.wav", "WAV");
	public static final Sound HURT = new Sound("data/sfx/hurt.wav", "WAV");

	private Audio sample;
	
	private Sound(String name, String format){
		try{
			sample = AudioLoader.getAudio(format, ResourceLoader.getResourceAsStream(name));
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void play(){
		sample.playAsSoundEffect(1.0f, 1.0f, false);
	}
	
	public void loop(){
		sample.playAsMusic(1.0f, 1.0f, true);
	}
	
	public void stop(){
		sample.stop();
	}
}
