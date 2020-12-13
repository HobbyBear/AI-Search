package com.search;

import java.util.*;

public class HillClimbSearch {
    private HeuristicNodeComparator sorter = new HeuristicNodeComparator();

    public void search(Node node) {

        Queue<Node> queue = new PriorityQueue<Node>(10, sorter);

        if (node.isGoalNode()) {
            path(node);
            return;
        }
        Node[] children = node.children();
        for (Node child : children) {
            if (!child.isVisited()) {
                queue.offer(child);
                child.setParent(node);
            }
        }

        Node bestChild = queue.poll();

        if (bestChild == null) {
            System.out.println("find fail");
            return;
        }

        System.out.println("Visiting " + bestChild.getNodeName());

        if (!bestChild.isLeaf()) {
            search(bestChild);
        } else {
            if (bestChild.isGoalNode()) {
               System.out.println("find success");
            } else {
                System.out.println("find fail");
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
        System.out.println("Path: " + path + ". Distance of " + distance(path));
    }

    private int distance(List<Node> path) {
        int distance = 0;
        for (int i = 0; i < path.size(); i++) {
            if (i + i <= path.size()) distance += path.get(i).getDistance(path.get(i + 1));
        }
        return distance;
    }

    public static void main(String[] args) {
        IrelandMap ire = new IrelandMap();
        Node start = ire.getStartNode();
        start.setVisited(true);
        HillClimbSearch hc = new HillClimbSearch();
        hc.search(start);
    }

}
