package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Greedybestfirstearch implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		Set<Node> explored = new HashSet<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				explored.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node node : children) {
					if(!frontier.contains(node) && !explored.contains(node)) {
						frontier.add(node);
						node.setParent(current);
						
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<Node>();
		frontier.add(root);
		boolean isStart = false;

		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				isStart = true;
				frontier.clear();
				explored.clear();
			}
			if (current.getLabel().equals(goal) && isStart)
				return current;

			explored.add(current);
			List<Edge> children = current.getChildren();
			for (int i = 0; i < children.size(); i++) {
				Edge tmp = children.get(i);
				Node child = tmp.getEnd();

				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					if (isStart)
						child.setParent(current);

				}
			}
		}
		return null;
	}
}
class NodeComparator implements Comparator<Node> {
	@Override
	public int compare(Node node1, Node node2) {
		return Double.compare(node1.getH(), node2.getH());
	}
}