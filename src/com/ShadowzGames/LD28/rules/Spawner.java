package com.ShadowzGames.LD28.rules;

import com.ShadowzGames.LD28.Map;
import com.ShadowzGames.LD28.Sprite;
import com.ShadowzGames.LD28.entity.Entity;
import com.ShadowzGames.LD28.entity.Mob;

public interface Spawner {
	public final Spawner Random = new RandomSpawnLocation();

	/**
	 * Sets the difficulty of the spawning
	 * @param level From 0-9 where 0 spawns least difficult mobs and 9 is most difficult
	 */
	public void setDificulty(int level);
	
	/**
	 * Gets the difficulty of the spawning. Decides how likely it is for a mob to spawn within the time window.
	 * @return level From 0-9 where 0 spawns least difficult mobs and 9 is most difficult
	 */
	public int getDificulty();
	
	/**
	 * Minimum delay between mob spawning
	 * @return Milliseconds of time when another mob cannot spawn since the last spawned enemy.
	 */
	public int getMinDelay();
	
	/**
	 * Maximum delay between mob spawning
	 * @return Milliseconds of time since the last spawned enemy, when another mob has to spawn, no matter what.
	 */
	public int getMaxDelay();
	
	/**
	 * Called every time a mob is requested to be spawned on the map.
	 * @return Newly created mob.
	 */
	public Entity spawnMob(Sprite[] availableMobs, Map map);
}
