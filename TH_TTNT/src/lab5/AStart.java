package lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStart implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		 PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
		    List<Node> explored = new ArrayList<>();
		    frontier.add(model.getInitialState());
		    int count = 0;
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
		                    node.setH(model.computeH1(node));
		                    node.setParent(current);
		                    frontier.add(node);
		                }
		            }
		        }
		    }
		    return null;
	}
	public Node executeH2(Puzzle model) {
		 PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
		    List<Node> explored = new ArrayList<>();
		    frontier.add(model.getInitialState());
		    int count = 0;
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
		                    node.setH(model.computeH2(node));
		                    node.setParent(current);
		                    frontier.add(node);
		                }
		            }
		        }
		    }
		    return null;
	}

}
