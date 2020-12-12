package com.search;

import java.util.*;

public class ASearch {
    private UnderestimatesComparator sorter = new UnderestimatesComparator();

    public void search(Node node) {

        Queue<Node> queue = new PriorityQueue<Node>(10, sorter);
        queue.offer(node);

        while (!queue.isEmpty()) {

            node = queue.poll();
            node.setVisited(true);
            if (node.isGoalNode()) {
                path(node);
                return;
            } else {

                Node[] children = node.children();

                for (Node child : children) {
                    if (!child.isVisited()) {
                        queue.offer(child);
                    }
                }
            }
        }
        System.out.println("find fail");
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
        ASearch bf = new ASearch();
        bf.search(start);
    }
}
