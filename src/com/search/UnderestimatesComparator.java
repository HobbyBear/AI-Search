package com.search;

import java.util.Comparator;

public class UnderestimatesComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.getUnderEstimates() > node2.getUnderEstimates()){
            return 1;
        }else if (node1.getUnderEstimates() < node2.getUnderEstimates()){
            return -1;
        }else{
            return 0;
        }
    }
}
