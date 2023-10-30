package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				double f1 = o1.getG()+o1.getH();
				double f2 = o2.getG()+o2.getH();
				int re  =Double.compare(f1, f2);
				return re==0?o1.getLabel().compareTo(o2.getLabel()):re;
			}
		});
		frontier.add(root);
		List<Node> explore = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			System.out.print(current+" ");
			System.out.println(frontier);
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				List<Edge> children = current.getChildren();
				System.out.println(current.getLabel());
				explore.add(current);
				for (Edge edge : children) {
					Node end = edge.getEnd();
					double newCost = current.getG() + edge.getWeight();
					if (!frontier.contains(end) && !explore.contains(end)) {
						frontier.add(end);
						end.setG(newCost);
						end.setParent(current);
					} 
					else if (frontier.contains(end)) {
						if (end.getG() > newCost) {
//							frontier.remove(end);
							end.setParent(current);
							end.setG(newCost);
//							frontier.add(end);
						}
					}
				}
			}
		}
		return null;

	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorAStar());
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
				double newPathCost = current.getG() + tmp.getWeight();
				if (!frontier.contains(child) && !explored.contains(child)) {
					frontier.add(child);
					if (isStart) {
						child.setParent(current);
						child.setG(newPathCost);
					}

				} else if (frontier.contains(child) && (newPathCost < child.getG())) {
					child.setG(newPathCost);
					child.setParent(current);
				}
			}
		}
		return null;
	}
	public boolean isAdmissible(Node tree, String goal) {
		List<Node> explored = new ArrayList<Node>();
		Stack<Node> frontier = new Stack<Node>();
		frontier.add(tree);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (!current.getLabel().equals(goal)) {
				explored.add(current);
				Node g = execute(current, goal);
				// nếu như g k null và H tại g > pathcost của g thì k admissible
				if (g != null && current.getH() > g.getG()) {
					System.out.println(current.getLabel() + ", H: " + current.getH() + ", G: " + g.getG());
					return false;
				}

				// tiếp tục mở rộng các node con khác
				List<Edge> children = current.getChildren();
				for (int i = 0; i < children.size(); i++) {
					Node child = children.get(i).getEnd();
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setG(0);
					}
				}

			}

		}
		return true;
	}
	public static void main(String[] args) {
		PriorityQueue<Node> q  = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Double.compare(o1.getH(),o2.getH());
						
			}
		});
		Node n1 = new Node("n1",1);
		Node n2 = new Node("n2",2);
		Node n3 = new Node("n3",3);
		q.add(n3);
		q.add(n2);
		q.add(n1);
		n2.setH(99);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
		System.out.println("---------------");
		q.add(n3);
		q.add(n2);
		q.add(n1);
		
		n1.setH(100);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}

class NodeComparatorAStar implements Comparator<Node> {
	@Override
	public int compare(Node node1, Node node2) {
		return Double.compare(node1.getH() + node1.getG(), node2.getH() + node2.getG());
	}
}
