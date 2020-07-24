package com.sx.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args){
        int[] arr = {7,3,10,12,5,1,9};
        BinarySortTree bst = new BinarySortTree();
        for (int i: arr) {
            Node n = new Node(i);
            bst.add(n);
        }
        System.out.println("中序遍历二叉排序树：");
        bst.infixOrder();
    }
}

class BinarySortTree{
    private Node root;
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void infixOrder(){
        if (root == null){
            System.out.println("二叉树为空");
            return;
        }else {
            root.infixOrder();
        }
    }
}

class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    //添加节点
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                "value=" + value +
                '}';
    }
}
