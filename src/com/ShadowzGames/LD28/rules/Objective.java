package com.ShadowzGames.LD28.rules;

import com.ShadowzGames.LD28.Map;

public interface Objective {
	final public static Objective KillAll = new KillAllObjective();
	final public static Objective ReachStar = new ReachStarObjective();
	
	/**
	 * Checks whether or not the requirement of the objective is met yet.
	 * @param map Map data, to check requirements against.
	 * @return True when all requirements of the objective is finished
	 */
	public boolean isRequirementMet(Map map);
	
	/**
	 * The toString function will be used to print out on the start of the map, which rule applies.
	 */
	public String toString(); 
}
