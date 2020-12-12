package com.search;

import java.util.*;

public class BeamSearch {
    HeuristicNodeComparator sorter = new HeuristicNodeComparator();
    int beamWidth = 2;

    public void search(Node node) {
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.addFirst(node);
        while (!queue.isEmpty()) {
            System.out.println(queue);
            LinkedList<Node> levelNodeList = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node removeNode = queue.removeFirst();
                if (removeNode.isGoalNode()) {
                    System.out.println("Reached goal node " + removeNode.getNodeName());
                    return;
                }
                System.out.println("Visiting " + removeNode.getNodeName() + "\t");
                Node[] children = removeNode.children();
                levelNodeList.addAll(Arrays.asList(children));
            }
            Collections.sort(levelNodeList, sorter);

            int bound = 0;
            bound = Math.min(levelNodeList.size(), beamWidth);
            for (int i = 0; i < bound; i++) {
                queue.addLast(levelNodeList.get(i));
            }
        }
    }

    public static void main(String[] args) {
        IrelandMap ire = new IrelandMap();
        Node start = ire.getStartNode();
        start.setVisited(true);
        BeamSearch bf = new BeamSearch();
        bf.search(start);
    }
}
