package Lab2;

import java.util.Random;


import Lab2.Environment.LocationState;

public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public enum LocationState {
		CLEAN, DIRTY
	}
	private static Random random = new Random();
	public static Action getRandom() {
		int randomAction = random.nextInt(4);
		if(randomAction == 0) {
			return Environment.MOVE_LEFT;
		}
		else if(randomAction == 1) {
			return Environment.MOVE_RIGHT;
		}
		else if(randomAction == 2) {
			return Environment.MOVE_DOWN;
		}
		return Environment.MOVE_UP;
	}
	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
			LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		this.agent = agent;
		envState.setAgentLocation(location);
	}

	public EnvironmentState getCurrentState() {// lấy về trạng thái
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {// khi thực hiện hành động thì mt thay đổi như thế naof
		if(action == Environment.SUCK_DIRT) {
			String agentlocation =  envState.getAgentLocation();
			envState.increaseScore(500);
			envState.setLocationState(agentlocation, LocationState.CLEAN);
		}
		else if(action == Environment.MOVE_LEFT && envState.getAgentLocation().equals(LOCATION_B)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_A);
		}
		else if(action == Environment.MOVE_LEFT && envState.getAgentLocation().equals(LOCATION_C)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_D);
		}
		else if(action == Environment.MOVE_RIGHT && envState.getAgentLocation().equals(LOCATION_A)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_B);
		}
		else if(action == Environment.MOVE_RIGHT && envState.getAgentLocation().equals(LOCATION_D)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_C);
		}
		else if(action == Environment.MOVE_DOWN && envState.getAgentLocation().equals(LOCATION_A)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_D);
		}
		else if(action == Environment.MOVE_DOWN && envState.getAgentLocation().equals(LOCATION_B)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_C);
		}
		else if(action == Environment.MOVE_UP && envState.getAgentLocation().equals(LOCATION_D)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_A);
		}
		else if(action == Environment.MOVE_UP && envState.getAgentLocation().equals(LOCATION_C)) {
			envState.decreaseScore(10);
			envState.setAgentLocation(LOCATION_B);
		}
		else {
			System.out.println("Không thể di chuyển");
			envState.decreaseScore(100);
			envState.getAgentLocation();
		}
		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {// lấy ra trnagj thái egent đang ở
		String agentLocation = envState.getAgentLocation();
		LocationState LocationState = envState.getLocationState(agentLocation);
		Percept percept = new Percept(agentLocation, LocationState);
		return percept;
	}
	/**
	 * In ra thong diep
	 * @param m thong diep can in
	 */
	public void printMessage(String m) {
		System.out.println(m);
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		int score = this.envState.getScore();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction + "\tScore: " + score);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_C) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
