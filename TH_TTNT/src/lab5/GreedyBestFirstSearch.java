package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<>();
		frontier.add(model.getInitialState());
		int count =0;
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.equals(model.getGoalState())) {
				return current;
			} else {
				explored.add(current);
				List<Node> children = model.getSuccessors(current);
				System.out.println(current);
				for (Node node : children) {
					System.out.println(count++);
					System.out.println(node);
					if (!frontier.contains(node) && !explored.contains(node)) {
						node.setG(current.getG() + 1);
						node.setParent(current);
						frontier.add(node);
					}
				}
			}
		}
		return null;
	}

}
