package com.ShadowzGames.LD28.rules;

import java.util.Random;

import com.ShadowzGames.LD28.Map;
import com.ShadowzGames.LD28.Sprite;
import com.ShadowzGames.LD28.entity.Entity;
import com.ShadowzGames.LD28.entity.Mob;

public class RandomSpawnLocation implements Spawner {
	int level = 3;
	Random r;
	@Override
	public void setDificulty(int level) {
		this.level = level;
	}

	@Override
	public int getDificulty() {
		return level;
	}

	@Override
	public int getMinDelay() {
		return 1500 - level*180;
	}

	@Override
	public int getMaxDelay() {
		return 4000 - level*200;
	}

	@Override
	public Entity spawnMob(Sprite[] availableMobs, Map map) {
		if(r == null){
			r = new Random();
		}
		int i = Math.abs(r.nextInt() % availableMobs.length);
		int x = Math.abs(r.nextInt() % (map.TILE_COL * map.TILE_WIDTH));
		int y = Math.abs(r.nextInt() % (map.TILE_ROW * map.TILE_HEIGHT));
		
		Entity e = new Entity(availableMobs[i]);
		
		e.getRect().setLocation(x, y);
		
		return e;
	}
}
