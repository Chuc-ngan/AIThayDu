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
		System.out.println(NodeUtils.printPath(result)+"BFS graph");
		
		ISearchAlgo  algo2 = new BreadthFirstSearchAlgo();
		Node result2 = algo2.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(result2)+"BFS graph start A");
		
		ISearchAlgo algo3 = new BreadthFirstSearchAlgo();
		Node result3 = algo3.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result3)+"BFS Tree");
		
		ISearchAlgo  algo4 = new BreadthFirstSearchAlgo();
		Node result4 = algo4.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(result4)+"BFS Tree start A");
		
		ISearchAlgo dfs = new DepthFirstSearchAlgo();
		Node resultdfs = dfs.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result)+"DFS graph");
		
		ISearchAlgo  dfs2 = new DepthFirstSearchAlgo();
		Node resultdfs2 = dfs2.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(resultdfs2)+"DFS graph start A");
		
		ISearchAlgo dfs3 = new DepthFirstSearchAlgo();
		Node resultdfs3 = dfs3.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result3)+"DFS tree");
		
		ISearchAlgo  dfs4 = new DepthFirstSearchAlgo();
		Node resultdfs4 = dfs4.execute(nodeS, "A", "G");//Task2
		System.out.println(NodeUtils.printPath(resultdfs4)+"DFS tree start A");
	}
}
