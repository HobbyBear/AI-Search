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
            closed.add(node);

            if (node.isGoalNode()) {
                path(node);
                System.out.println(closed);
                return;
            } else {

                Node[] children = node.children();

                for (int i = 0; i < children.length; i++) {
                    queue.offer(children[i]);
                }
            }
        }
    }

    private void path(Node node) {
        List<Node> path = new ArrayList<Node>();
        while (node.getParent() != null) {
            path.add(node);
            node = node.getParent();
        }
        path.add(node);
        Collections.reverse(path);
        System.out.println("Path: " + path);
    }


    public static void main(String[] args) {
        IrelandMap ire = new IrelandMap();
        Node start = ire.getStartNode();
        start.setVisited(true);
        BestFirstSearch bf = new BestFirstSearch();
        bf.search(start);
    }
}