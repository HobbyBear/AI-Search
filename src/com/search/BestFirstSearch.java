package com.search;

import java.util.*;

public class BestFirstSearch {

    private List<Node> closed = new ArrayList<Node>();
    private HeuristicNodeComparator sorter = new HeuristicNodeComparator();

    public void search(Node node) {

        Queue<Node> queue = new PriorityQueue<Node>(10, sorter);
        queue.offer(node);

        while (!queue.isEmpty()) {

            node = queue.poll();
            System.out.println("Visiting " + node.getNodeName() + "\t");
            closed.add(node);

            if (node.isGoalNode()) {
                System.out.println("find success");
                return;
            } else {

                Node[] children = node.children();

                for (int i = 0; i < children.length; i++) {
                    queue.offer(children[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        IrelandMap ire = new IrelandMap();
        Node start = ire.getStartNode();
        start.setVisited(true);
        BestFirstSearch bf = new BestFirstSearch();
        System.out.println("BestFirstSearch ");
        bf.search(start);
    }
}