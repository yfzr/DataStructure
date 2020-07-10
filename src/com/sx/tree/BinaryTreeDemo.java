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

//        System.out.println("前序查找-----");
//        HeroNode resNode = binaryTree.preOrderSearch(5);
//        System.out.printf("id=%d  name=%s", resNode.getId(), resNode.getName());

//        System.out.println("中序查找-----");
//        HeroNode resNode = binaryTree.infixOrderSearch(5);
//        System.out.printf("id=%d  name=%s", resNode.getId(), resNode.getName());

        System.out.println("后序查找-----");
        HeroNode resNode = binaryTree.postOrderSearch(15);
        if (resNode != null){
            System.out.printf("id=%d  name=%s\n", resNode.getId(), resNode.getName());
        }else {
            System.out.println("没有找到要删除的节点");
        }

        binaryTree.delNode(5);
        System.out.println("删除后前序遍历：");
        binaryTree.preOrder();
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
    //前序查找
    public HeroNode preOrderSearch(int id){
        HeroNode resNode = null;
        System.out.println("正在进行前序查找...");
        //1.先比较当前节点的id，如果相同，则直接返回
        if (this.id == id){
            return this;
        }
        //2.如果不同且左节点非空，则先继续向左前序查找
        if (this.left != null){
            resNode = this.left.preOrderSearch(id);
        }
        //3.如果向左前序查找已找到，则返回
        if (resNode != null){
            return resNode;
        }
        //4.如果不同且右节点非空，则向右前序查找
        if (this.right != null){
            resNode = this.right.preOrderSearch(id);
        }
        //System.out.printf("找不到id=%d的节点信息\n", id);
        return resNode;
    }
    //中序查找
    public HeroNode infixOrderSearch(int id){
        HeroNode resNode = null;
        //1.如果左节点非空，则先继续向左中序查找
        if (this.left != null){
            resNode = this.left.infixOrderSearch(id);
        }
        //2.如果向左中序查找已找到，则返回
        if (resNode != null){
            return resNode;
        }
        System.out.println("正在进行中序查找...");
        //3.比较当前节点的id，如果相同，则直接返回
        if (this.id == id){
            return this;
        }
        //4.如果不同且右节点非空，则向右中序查找
        if (this.right != null){
            resNode = this.right.infixOrderSearch(id);
        }
        //System.out.printf("找不到id=%d的节点信息\n", id);
        return resNode;
    }
    //后序查找
    public HeroNode postOrderSearch(int id){
        HeroNode resNode = null;
        //1.如果左节点非空，则先继续向左后序查找
        if (this.left != null){
            resNode = this.left.postOrderSearch(id);
        }
        //2.如果向左后序查找已找到，则返回
        if (resNode != null){
            return resNode;
        }
        //3.如果不同且右节点非空，则向右后序查找
        if (this.right != null){
            resNode = this.right.postOrderSearch(id);
        }
        //4.如果向右后序查找已找到，则返回
        if (resNode != null){
            return resNode;
        }
        System.out.println("正在进行后序查找...");
        //5.最后比较当前节点的id，如果相同，则直接返回
        if (this.id == id){
            return this;
        }
        //System.out.printf("找不到id=%d的节点信息\n", id);
        return resNode;
    }
    //删除节点
    public void delNode(int id){
        //如果当前节点的左节点非空，且刚好是要删除的节点，则删除返回
        if (this.left != null && this.left.id == id){
            this.left = null;
            return;
        }
        //如果当前节点的右节点非空，且刚好是要删除的节点，则删除返回
        if (this.right != null && this.right.id == id){
            this.right =null;
            return;
        }
        //如果没找到节点，则继续向左递归删除
        if (this.left != null){
            this.left.delNode(id);
        }
        //如果没找到节点，则继续向右递归删除
        if (this.right != null){
            this.right.delNode(id);
        }
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
    //前序查找
    public HeroNode preOrderSearch(int id){
        if (this.root != null){
            return this.root.preOrderSearch(id);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int id){
        if (this.root != null){
            return this.root.infixOrderSearch(id);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    //后序查找
    public HeroNode postOrderSearch(int id){
        if (this.root != null){
            return this.root.postOrderSearch(id);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    //节点删除
    public void delNode(int id){
        if (this.root != null){
            if (this.root.getId() == id){
                this.root =null;
                return;
            }else {
                this.root.delNode(id);
            }
        }else {
            System.out.println("二叉树为空，无法删除节点");
        }
    }
}