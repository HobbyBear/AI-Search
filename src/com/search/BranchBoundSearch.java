package com.search;

import java.util.*;

public class BranchBoundSearch {
    private UnderestimatesComparator sorter = new UnderestimatesComparator();

    public void search(Node node) {

        Queue<Node> queue = new PriorityQueue<Node>(10, sorter);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node G = queue.poll();
            System.out.println("Visiting " + G.getNodeName() + "\t");
            if (G.isGoalNode()) {
                System.out.println("find success");
                return;
            }
            Node[] children = G.children();
            for (Node child : children) {
                queue.offer(child);
            }

        }

    }


    public static void main(String[] args) {
        IrelandMap ire = new IrelandMap();
        Node start = ire.getStartNode();
        start.setVisited(true);
        BranchBoundSearch hc = new BranchBoundSearch();
        System.out.println("BrancBoundSearch ");
        hc.search(start);
    }

}
