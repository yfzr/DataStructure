package com.sx.huffmantree;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HuffmanTree {
    public static void main(String[] args){
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        preOrder(creatHuffmanTree(arr));
    }

    //前序遍历，可指定根节点
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
            System.out.println();
        }else {
            System.out.println("二叉树为空");
        }
    }

    /**
     * 创建霍夫曼树
     * @param arr 用于创建霍夫曼树的数组
     * @return 最终返回根节点
     */
    public static Node creatHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        //遍历数组，用于赋予节点的权值
        for (Integer i: arr) {
            nodes.add(new Node(i));
        }
        //当集合中存在的节点数为1时，霍夫曼树才构建成功
        while (nodes.size() > 1){
            System.out.println("nodes=" + nodes);
            //1.对节点根据权值进行排序（从小到大）
            Collections.sort(nodes);
            //2.获取权值最小的两个节点，作为初始的左右节点
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //3.创建这两个节点的父节点，父节点的权值是这两个节点权值之和
            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeftNode(left);
            parent.setRightNode(right);
            //4.移除原来的两个节点，并加入父节点
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

//创建二叉树节点，并实现Comparable接口，用于排序
class Node implements Comparable<Node>{
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.print(this.value + "  ");
        if (this.leftNode != null){
            this.getLeftNode().preOrder();
        }
        if (this.rightNode != null){
            this.getRightNode().preOrder();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大
        return this.value - o.value;
    }
}
