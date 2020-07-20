package com.sx.huffmancode;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args){
        //编码字符串
        String contents = "i like like like java do you like a java";
        //转换为字节数组
        byte[] contentsByte = contents.getBytes();
        //通过文本的字节数组，建立霍夫曼树的节点信息
        List<Node> nodes = getNodes(contentsByte);
        System.out.println("notes=" + nodes);
        //建立霍夫曼树
        Node root = creatHuffmanTree(nodes);
        //前序遍历查看
        preOrder(root);
        //获取霍夫曼编码
        Map<Byte, String> map = getCodes(root);
        System.out.println("霍夫曼编码表：" + map);

    }

    //获取节点信息，存放在list中，用于建立霍夫曼树
    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        //统计不同字节的数量
        for (byte b:bytes) {
            Integer count = counts.get(b);
            if (count == null){
                counts.put(b, 1);
            }else {
                counts.put(b, count + 1);
            }
        }
        //根据不同字节的数量，建立对应的节点信息
        for (Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    //创建霍夫曼树，非叶子节点的data为null
    public static Node creatHuffmanTree(List<Node> nodes){
        while (nodes.size() > 1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null, leftNode.getWeight() + rightNode.getWeight());
            parent.setLeft(leftNode);
            parent.setRight(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //前序遍历
    public static void preOrder(Node root){
        if (root != null){
            root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }

    //用于存储霍夫曼编码信息
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //用于存放递归过程中的节点路径
    static StringBuilder stringBuilder = new StringBuilder();

    //根据霍夫曼树的根节点进行霍夫曼编码
    public static Map<Byte, String> getCodes(Node root){
        if (root == null){
            return null;
        }
        //分别向左和向右递归获取编码路径
        getCodes(root.getLeft(), "0", stringBuilder);
        getCodes(root.getRight(), "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 霍夫曼编码
     * @param node 当前节点
     * @param code 编码，左节点编码为0，右节点编码为1
     * @param stringBuilder 用于拼接路径
     */
    public static void getCodes(Node node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null){
            //如果data为null，说明还没到叶子节点
            if (node.getData() == null){
                //分别向左向右进行递归编码
                getCodes(node.getLeft(), "0", stringBuilder1);
                getCodes(node.getRight(), "1", stringBuilder1);
            }else {
                //到达叶子节点后，存储相应的字节（已进行ASCII码表转换）及编码路径信息
                huffmanCodes.put(node.getData(), stringBuilder1.toString());
            }
        }
    }
}

//节点
class Node implements Comparable<Node>{
    private Byte data;
    private int weight;
    private Node left;
    private Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    public Byte getData() {
        return data;
    }

    public void setData(byte data) {
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

    @Override
    public int compareTo(Node o) {
        return this.weight -  o.weight;
    }
}
