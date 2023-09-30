package Lab2; 
//nhận biết 
public class Percept {
	private String agentLocation;//vị trí agent
	private Environment.LocationState state; //trạng thái mt *bẩn  *sạch

	public Percept(String agentLocation, Environment.LocationState state) {
		this.agentLocation = agentLocation;
		this.state = state;
	}

	public Environment.LocationState getLocationState() {
		return this.state;
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}
}