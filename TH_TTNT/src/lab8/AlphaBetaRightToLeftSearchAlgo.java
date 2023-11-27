package lab8;

import java.util.List;

public class AlphaBetaRightToLeftSearchAlgo implements ISearchAlgo{

	@Override
	public void execute(Node node) {
		 int v = minValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	        System.out.println(v);
	        node.setValue(v);
	    }

	    public int maxValue(Node node, int alpha, int beta) {
	        if (node.isTerminal()) {
	            return node.getValue();
	        }

	        int v = Integer.MIN_VALUE;
	        List<Node> children = node.getChildren();

	        for (int i = children.size() - 1; i >= 0; i--) {
	            Node child = children.get(i);
	            v = Math.max(v, minValue(child, alpha, beta));

	            if (v >= beta) {
	                for (int j = 0; j < i; j++) {
	                    System.out.println("Cut: " + children.get(j).getLabel() + " " + children.get(j).getValue());
	                }
	                return v;
	            }

	            alpha = Math.max(alpha, v);
	        }

	        return v;
	    }

	    public int minValue(Node node, int alpha, int beta) {
	        if (node.isTerminal()) {
	            return node.getValue();
	        }

	        int v = Integer.MAX_VALUE;
	        List<Node> children = node.getChildren();

	        for (int i = children.size() - 1; i >= 0; i--) {
	            Node child = children.get(i);
	            v = Math.min(v, maxValue(child, alpha, beta));

	            if (v <= alpha) {
	                for (int j = 0; j < i; j++) {
	                    System.out.println("Cut: " + children.get(j).getLabel() + " " + children.get(j).getValue());
	                }
	                return v;
	            }

	            beta = Math.min(beta, v);
	        }

	        return v;
	    }

}
