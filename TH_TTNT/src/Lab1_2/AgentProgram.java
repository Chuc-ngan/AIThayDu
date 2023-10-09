package Lab1_2;

import java.util.Random;

import Lab1_2.Environment.LocationState;

public class AgentProgram {
	
	public Action execute(Percept p) {
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else if(p.getAgentLocation() == Environment.LOCATION_A) {
			System.out.println("=================================="+Environment.getRandom());
			return Environment.getRandom();
		}
		else if(p.getAgentLocation() == Environment.LOCATION_B) {		System.out.println("=================================="+Environment.getRandom());
			return Environment.getRandom();
		}
		else if(p.getAgentLocation() == Environment.LOCATION_C) {	System.out.println("=================================="+Environment.getRandom());
			return Environment.getRandom();
		}
		else if(p.getAgentLocation() == Environment.LOCATION_D) {		System.out.println("=================================="+Environment.getRandom());
			return Environment.getRandom();
		}
		return NoOpAction.NO_OP;
	}
}
