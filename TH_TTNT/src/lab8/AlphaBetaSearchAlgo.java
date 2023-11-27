package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = minValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(v);
		node.setValue(v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// ft

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal())
			return node.getValue();
		int v = Integer.MIN_VALUE;
		List<Node> children = node.getChildren();
		for (int i = 0; i < children.size(); i++) {
			Node child = children.get(i);
			v = Math.max(v, minValue(child, alpha, beta));
			if (v >= beta) {
				for (int j = i+1; j < children.size(); j++) {
					System.out.println("Cut:"+ children.get(j).getLabel() +" " + children.get(j).getValue());
				}
				return v;
			}
			alpha = Math.max(alpha, v);
		}
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal())
			return node.getValue();
		int v = Integer.MAX_VALUE;
		List<Node> children = node.getChildren();
		for (int i = 0; i < children.size(); i++) {
			Node child = children.get(i);
			v = Math.min(v, maxValue(child, alpha, beta));
			if (v <= alpha) {
				for (int j = i+1; j < children.size(); j++) {
					System.out.println("Cut:"+ children.get(j).getLabel() +" " + children.get(j).getValue());
				}
				return v;
			}
			beta = Math.min(beta, v);
		}
		return v;
	}
}
