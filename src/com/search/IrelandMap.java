package com.search;

public class IrelandMap {
	private Node aNode;
	
	public IrelandMap() {
		aNode = new Node("A", 18);
		Node b = new Node("B", 14);
		Node c = new Node("C", 4);
		Node d = new Node("D", 9);
		Node e = new Node("E", 12);
		Node f = new Node("F", 1);
		Node g1 = new Node("G1", 0);
		Node g2 = new Node("G2", 0);
		Node h = new Node("H", 3);
		Node i = new Node("I", 21);
		Node j = new Node("J", 31);
		Node k = new Node("K", 34);
		Node l = new Node("L", 21);
		Node m = new Node("M", 18);
		Node n = new Node("N", 8);
		g2.setGoalNode(true);
		


		aNode.addChildNode(b, 4);
		aNode.addChildNode(c, 11);
		
		b.addChildNode(d, 15);
		b.addChildNode(e, 13);

		d.addChildNode(i, 12);
		d.addChildNode(j, 10);

		e.addChildNode(g1, 18);
		e.addChildNode(k, 16);
		
		c.addChildNode(f, 4);
		c.addChildNode(h, 3);

		f.addChildNode(i, 6);
		f.addChildNode(m, 3);

		h.addChildNode(n, 1);
		h.addChildNode(g2, 7);
	}
	
	public Node getStartNode(){
		return aNode;
	}
}
