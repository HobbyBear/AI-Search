package com.search;

import java.util.*;

public class BranchBoundSearch {
    private UnderestimatesComparator sorter = new UnderestimatesComparator();

    public void search(Node node) {

        Queue<Node> queue = new PriorityQueue<Node>(10, sorter);
        queue.add(node);

        while (!queue.isEmpty()) {
            Node G = queue.poll();
            if (G.isGoalNode()) {
                path(G);
                return;
            }
            Node[] children = G.children();
            for (Node child : children) {
                queue.offer(child);
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
        BranchBoundSearch hc = new BranchBoundSearch();
        hc.search(start);
    }

}
