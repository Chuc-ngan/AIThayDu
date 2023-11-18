package Lab6_2;

public class HillClimbing {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;

	public Node execute(Node initialState) {
		Node current = initialState;
		Node neighbour = null;
		while (true) {
			neighbour = current.getBestCandidate();
			if (neighbour.getH() < current.getH()) {
				current = neighbour;
				stepClimbed++;
				stepClimbedAfterRandomRestart++;
			} else {
				return current;
			}
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node current = execute(initialState);
		
		while(current.getH()!=0) {
			current.generateBoard();
			current = execute(current);
			current.displayBoard();
			randomRestarts++;
			System.out.println(randomRestarts);
		}
		System.out.println(current.getH());
		return current;
	}
}