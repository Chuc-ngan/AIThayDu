package Lab2;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result)+"BFS graph start S");
		System.out.println();
		
		ISearchAlgo  algo2 = new BreadthFirstSearchAlgo();
		Node result2 = algo2.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(result2)+"BFS graph start A");
		System.out.println();
		
		ISearchAlgo algo3 = new BreadthFirstSearchAlgo();
		Node result3 = algo3.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result3)+"BFS Tree start S");
		System.out.println();
		
		ISearchAlgo  algo4 = new BreadthFirstSearchAlgo();
		Node result4 = algo4.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(result4)+"BFS Tree start A");
		System.out.println();
		
		ISearchAlgo dfs = new DepthFirstSearchAlgo();
		Node resultdfs = dfs.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result)+"DFS graph start S");
		System.out.println();
		
		ISearchAlgo  dfs2 = new DepthFirstSearchAlgo();
		Node resultdfs2 = dfs2.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(resultdfs2)+"DFS graph start A");
		System.out.println();
		
		ISearchAlgo dfs3 = new DepthFirstSearchAlgo();
		Node resultdfs3 = dfs3.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result3)+"DFS tree start S");
		System.out.println();
		
		ISearchAlgo  dfs4 = new DepthFirstSearchAlgo();
		Node resultdfs4 = dfs4.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(resultdfs4)+"DFS tree start A");
		System.out.println();
		
		ISearchAlgo ucs = new UniformCostSearchAlgo();
		Node resultUCS = ucs.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(resultUCS)+"UCS start S");
		NodeUtils.print(nodeG);
		System.out.println();
		
		ISearchAlgo ucsA = new UniformCostSearchAlgo();
		Node resultUCSA = ucsA.execute(nodeS,"A", "G");
		System.out.println(NodeUtils.printPath(resultUCSA)+"UCS start A");
		NodeUtils.print(nodeG);
		System.out.println();
		
		LimitedDeepSearchGraph limitedDeepSearchGraph = new LimitedDeepSearchGraph();
		System.out.println(NodeUtils.printPath(limitedDeepSearchGraph.execute(nodeS, "G",2)));
		System.out.println();
		
		
	}
}
