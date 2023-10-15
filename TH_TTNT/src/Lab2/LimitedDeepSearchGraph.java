package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LimitedDeepSearchGraph  implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 */
	@Override
	public Node execute(Node root, String goal, int limit) {
		Stack<Node> frontier = new Stack<>();
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while(!frontier.isEmpty()) {
			Node current= frontier.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				explored.add(current);
				if (current.getDepth()<limit) {
					List<Node> children = current.getChildrenNodes();
					for (Node node : children) {
						if (!frontier.contains(node) && !explored.contains(node)) {
							frontier.add(node);
							node.setParent(current);
							node.setDepth(current.getDepth()+1);
						}
					} 
				}
				else {
					
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

}
