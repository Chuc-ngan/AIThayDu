package lab9;

import java.util.List;

public class MinimaxAlgo {
	public void execute(Node node) {
		int v = maxValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int v = Integer.MIN_VALUE;
		if (node.isTerminal())
			return 0;
		else {
			List<Node> children = node.getSuccessors();
			for (Node n : children) {
				v = Math.max(v, minValue(n));
			}
		}
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int v = Integer.MAX_VALUE;
		if (node.isTerminal())
			return 1;
		else {
			List<Node> children = node.getSuccessors();
			for (Node n : children) {
				v = Math.min(v, maxValue(n));
			}
		}
		return v;
	}
}
