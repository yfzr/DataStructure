package com.sx.huffmancode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
    public static void main(String[] args){
        String contents = "i like like like java do you like a java";
        byte[] contentsByte = contents.getBytes();

    }

//    public static List<Node> getNodes(byte[] bytes){
//        List<Node> res = new ArrayList<>();
//        Map<Character, Integer> counts = new HashMap<>();
//        int count = 0;
//        for (byte b:bytes) {
//            if (counts.get(b) == null){
//                counts.put(b, 1);
//            }else {
//                counts.put(b, count + 1)
//            }
//        }
//    }
}

//节点
class Node{
    private char data;
    private int weight;
    private Node left;
    private Node right;

    public Node(char data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.getLeft() != null){
            this.getLeft().preOrder();
        }
        if (this.getRight() != null){
            this.getRight().preOrder();
        }
    }
}
