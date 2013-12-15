package com.ShadowzGames.LD28.objectives;

import com.ShadowzGames.LD28.Map;

public interface Objective {
	final public static Objective KillAll = new KillAllObjective();
	final public static Objective ReachStar = new ReachStarObjective();
	
	/**
	 * 
	 * @param map Map data, to check requirements against.
	 * @return True when all requirements of the objective is finished
	 */
	public boolean isRequirementMet(Map map);
	public String toString(); 
}
