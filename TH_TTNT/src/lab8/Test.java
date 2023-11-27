package lab8;

public class Test {
	public static void main(String[] args) {
		MiniMaxSearchAlgo miniMaxSearchAlgo = new MiniMaxSearchAlgo();
		AlphaBetaSearchAlgo alphaBetaSearchAlgo = new AlphaBetaSearchAlgo();
		AlphaBetaRightToLeftSearchAlgo alphaBetaRightToLeftSearchAlgo =  new AlphaBetaRightToLeftSearchAlgo();
		
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		nodeE.setValue(3);
		Node nodeF = new Node("F");
		nodeF.setValue(12);
		Node nodeG = new Node("G");
		nodeG.setValue(8);
		Node nodeH = new Node("H");
		nodeH.setValue(2);
		Node nodeI = new Node("I");
		nodeI.setValue(4);
		Node nodeJ = new Node("J");
		nodeJ.setValue(6);
		Node nodeK = new Node("K");
		nodeK.setValue(14);
		Node nodeL = new Node("L");
		nodeL.setValue(5);
		Node nodeM = new Node("M");
		nodeM.setValue(2);

		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeA.addChild(nodeD);

		nodeB.addChild(nodeE);
		nodeB.addChild(nodeF);
		nodeB.addChild(nodeG);

		nodeC.addChild(nodeH);
		nodeC.addChild(nodeI);
		nodeC.addChild(nodeJ);

		nodeD.addChild(nodeK);
		nodeD.addChild(nodeL);
		nodeD.addChild(nodeM);
		
//		miniMaxSearchAlgo.execute(nodeA);
//		alphaBetaSearchAlgo.execute(nodeA);
		alphaBetaRightToLeftSearchAlgo.execute(nodeA);
		System.out.println(nodeA.getValue());
	}
}
