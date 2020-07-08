package com.sx.tree;

public class BinaryTreeDemo {
    public static void main(String[] args){
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义");
        HeroNode heroNode3 = new HeroNode(3, "公孙胜");
        HeroNode heroNode4 = new HeroNode(4, "吴用");
        HeroNode heroNode5 = new HeroNode(5, "林冲");
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setLeft(heroNode5);
        heroNode3.setRight(heroNode4);

        BinaryTree binaryTree = new BinaryTree(root);

        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.infixOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();
    }
}

//二叉树的英雄节点
class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder(){
        //1.先输出当前节点
        System.out.println(this);
        //2.如果当前节点的左节点非空，则向左继续前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //3.如果当前节点的右节点非空，则向右继续前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        //1.如果当前节点的左节点非空，则向左继续中序遍历
        if (this.left != null){
            this.left.infixOrder();
        }
        //2.输出当前节点
        System.out.println(this);
        //3.如果当前节点的右节点非空，则向右继续中序遍历
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        //1.如果当前节点的左节点非空，则向左继续后序遍历
        if (this.left != null){
            this.left.postOrder();
        }
        //2.如果当前节点的右节点非空，则继续向右后序遍历
        if (this.right != null){
            this.right.postOrder();
        }
        //3.最后输出当前节点
        System.out.println(this);
    }
}

//二叉树
class BinaryTree{
    private HeroNode root;
    public BinaryTree(HeroNode root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}