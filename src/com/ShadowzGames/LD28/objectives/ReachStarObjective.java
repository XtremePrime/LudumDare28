package com.ShadowzGames.LD28.objectives;

import com.ShadowzGames.LD28.Map;

public class ReachStarObjective implements Objective {

	@Override
	public boolean isRequirementMet(Map map) {
		return false;
	}
	
	@Override
	public String toString(){
		return "Reach the star!";
	}
}
