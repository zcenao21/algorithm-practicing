package com.will.practice.linkedlist;

import java.util.LinkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

public class FlatMultiLayerLinkedList {
    public Node flatten(Node head) {
        LinkedList<Node> nextNodes = new LinkedList<>();
        flattenInner(head, nextNodes);
        return head;
    }

    public Node flattenInner(Node node, LinkedList<Node> nextNodes){
        if(node==null) return null;

        if(node.child==null){
            if(node.next==null){
                if(nextNodes.size()>0){
                    Node nextNode = nextNodes.pollFirst();
                    node.next=nextNode;
                    nextNode.prev=node;
                }else{
                    return null;
                }
            }
        }else{
            if(node.next!=null){
                nextNodes.addFirst(node.next);
            }

            Node nxtNode = node.child;
            node.next=nxtNode;
            nxtNode.prev=node;
            node.child=null;
        }
        flattenInner(node.next, nextNodes);

        return node;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[13];

        for(int i=1;i<13;i++){
            nodes[i]=new Node();
            nodes[i].val=i;
        }

        for(int i=1;i<=5;i++){
            nodes[i].next=nodes[i+1];
        }
        for(int i=2;i<=6;i++){
            nodes[i].prev=nodes[i-1];
        }

        for(int i=7;i<=9;i++){
            nodes[i].next=nodes[i+1];
        }
        for(int i=8;i<=10;i++){
            nodes[i].prev=nodes[i-1];
        }

        nodes[11].next=nodes[12];
        nodes[12].prev=nodes[11];

        nodes[3].child=nodes[7];
        nodes[8].child=nodes[11];

        FlatMultiLayerLinkedList f = new FlatMultiLayerLinkedList();
        f.flatten(nodes[1]);

        System.out.println();
    }
}
