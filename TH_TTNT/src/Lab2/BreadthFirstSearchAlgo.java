package Lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {

		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> expanded = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if (node.getLabel().equals(goal)) {
				return node;
			} else
				expanded.add(node);
			for (Node child : node.getChildrenNodes()) {
				if (!expanded.contains(child) && !frontier.contains(child)) {
					frontier.add(child);
					child.setParent(node);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean started = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> exployred = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				exployred.clear();
				current.setParent(null);
			}
			if(current.getLabel().equals(goal) && started) {
				return current;
			}else {
				exployred.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node node : children) {
					if(!frontier.contains(node) && !exployred.contains(node)) {
						frontier.add(node);
						node.setParent(current);
					}
				}
			}
		}
		
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String goal) {
		 Queue<Node> frontier = new LinkedList<Node>();
		    frontier.add(root);
		    while (!frontier.isEmpty()) {
		        Node node = frontier.poll();
		        if (node.getLabel().equals(goal)) {
		            return node;
		        }
		        for (Node child : node.getChildrenNodes()) {
		            if (!frontier.contains(child)) {
		                frontier.add(child);
		                child.setParent(node);
		            }
		        }
		    }
		    return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String start, String goal) {
		boolean started = false;
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
			
				current.setParent(null);
			}
			if(current.getLabel().equals(goal) && started) {
				return current;
			}else {
				
				List<Node> children = current.getChildrenNodes();
				for (Node node : children) {
					if(!frontier.contains(node) ) 
						frontier.add(node);
						node.setParent(current);
					}
				}
			}
		
		
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
