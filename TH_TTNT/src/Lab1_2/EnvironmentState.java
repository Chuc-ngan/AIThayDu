package Lab1_2; 

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import Lab1_2.Environment.LocationState;


public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//
	private int score;

	public EnvironmentState(Environment.LocationState locAState, Environment.LocationState locBState, Environment.LocationState locCState, Environment.LocationState locDState) {
		this.state.put(Environment.LOCATION_A, locAState);
		this.state.put(Environment.LOCATION_B, locBState);
		this.state.put(Environment.LOCATION_C, locCState);
		this.state.put(Environment.LOCATION_D, locDState);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAgentLocation(String location) {
		this.agentLocation = location;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, LocationState locationState) {
		this.state.put(location, locationState);
	}
	public void increaseScore(int points) {
        score += points;
    }

    public void decreaseScore(int points) {
        score -= points;
    }
	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}