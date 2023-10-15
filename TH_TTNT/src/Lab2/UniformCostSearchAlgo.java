package Lab2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Set<Node> explored = new HashSet<>();
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equals(goal)) {
				return node;
			} else
				explored.add(node);
			List<Edge> children = node.getChildren();
			for (Edge child : children) {
				Node end = child.getEnd();
				double newPathCode = (node.getPathCost() + child.getWeight());
				if (!frontier.contains(end) || !explored.contains(end)) {
					frontier.add(end);
					end.setParent(node);
					end.setPathCost(node.getPathCost() + child.getWeight());
				}
				else if (end.getPathCost() > newPathCode) {
					end.setPathCost(newPathCode);
					end.setParent(node);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean visited = false;
		Set<Node> explored = new HashSet<>();
		PriorityQueue<Node> frontier = new PriorityQueue<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current =frontier.poll();
			if(current.getLabel().equals(start)) {
				frontier.clear();
				explored.clear();
				current.setParent(null);
				current.setPathCost(0);
				visited = true;
			}
			if(current.getLabel().equals(goal)&& visited ==true) {
				return current;
			}else
				explored.add(current);
			List<Edge> children = current.getChildren();
			for (Edge child : children) {
				Node end = child.getEnd();
				double newPathCode = (current.getPathCost() + child.getWeight());
				if (!frontier.contains(end) || !explored.contains(end)) {
					frontier.add(end);
					end.setParent(current);
					end.setPathCost(current.getPathCost() + child.getWeight());
				}
				else if (end.getPathCost() > newPathCode) {
					end.setPathCost(newPathCode);
					end.setParent(current);
				}
			}
			
		}
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node node1, Node node2) {
			return Double.compare(node1.getPathCost(), node2.getPathCost());
		}
	}

	@Override
	public Node execute(Node root, String goal, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
