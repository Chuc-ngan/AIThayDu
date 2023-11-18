package Lab6_2;

public class Test {
	public static void main(String[] args) {
		Node node = new Node();
		node.generateBoard();
		node.displayBoard();
//		System.out.println(node.getH());
		HillClimbing climbing = new HillClimbing();
//		climbing.execute(node).displayBoard();
		climbing.executeHillClimbingWithRandomRestart(node);
	}
}
