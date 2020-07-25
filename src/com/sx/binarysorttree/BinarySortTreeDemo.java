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

    //查找要删除的节点
    public Node search(int value){
        //找到节点
        if (value == this.value){
            return this;
        //如果删除的节点值小于当前节点值，则向左递归查找
        }else if (value < this.value){
            //没有对应的节点
            if (this.left == null){
                return null;
            }
            return this.left.search(value);
        //如果删除节点的值大于等于当前节点的值，则向右递归查找
        }else {
            //没有对应节点
            if (this.right == null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value){
        //需要保证当前节点有子节点，其子节点的值符合，则返回当前节点
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            //要删除节点的值小于当前节点的左子节点的值，则向左递归查找
            if (this.left != null && value < this.left.value){
                return this.left.searchParent(value);
            //要删除节点的值大于当前节点的右子节点的值，则向右递归查找
            }else if (this.right != null && value >= this.right.value){
                return this.right.searchParent(value);
            //没有对应的父节点
            }else {
                return null;
            }
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
