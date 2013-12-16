package com.ShadowzGames.LD28.rules;

import java.util.Random;

import com.ShadowzGames.LD28.Map;
import com.ShadowzGames.LD28.Sprite;
import com.ShadowzGames.LD28.entity.Entity;
import com.ShadowzGames.LD28.entity.Mob;
import com.ShadowzGames.LD28.tile.AirTile;

public class RandomSpawnLocation implements Spawner {
	int level = 1;
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
		return 5000 - (level*180);
	}

	@Override
	public int getMaxDelay() {
		return 10000 - (level*300);
	}

	@Override
	public Entity spawnMob(Sprite[] availableMobs, Map map) {
		if(r == null){
			r = new Random();
		}
		int i = Math.abs(r.nextInt() % availableMobs.length);
		int x = 0;
		int y = 0;
		do{
			x = Math.abs(r.nextInt() % (map.TILE_COL * map.TILE_WIDTH));
			y = Math.abs(r.nextInt() % (map.TILE_ROW * map.TILE_HEIGHT));
		} while(map.getTile(x/map.TILE_WIDTH, y/map.TILE_HEIGHT).getPrototypeID() == 0);
		
		Entity e = new Entity(availableMobs[i]);
		
		e.getRect().setLocation(x, y);
		if( x > (map.TILE_COL * map.TILE_WIDTH)/2){
			e.flip();
		}
		return e;
	}
}
