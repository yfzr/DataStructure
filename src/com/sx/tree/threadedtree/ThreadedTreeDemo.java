package com.sx.tree.threadedtree;

public class ThreadedTreeDemo {
    public static void main(String[] args){
        HeroNode root = new HeroNode(1, "kobe");
        HeroNode heroNode2 = new HeroNode(3, "wades");
        HeroNode heroNode3 = new HeroNode(6, "james");
        HeroNode heroNode4 = new HeroNode(8, "paul");
        HeroNode heroNode5 = new HeroNode(10, "shaq");
        HeroNode heroNode6 = new HeroNode(14, "melo");

        //手动创建二叉树
        ThreadedBinaryTree tbt = new ThreadedBinaryTree();
        tbt.setRoot(root);
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
        heroNode2.setRight(heroNode5);
        heroNode3.setLeft(heroNode6);

        //测试中序线索化
        tbt.threadedNode();
        HeroNode leftNode = heroNode5.getLeft();
        HeroNode rightNode = heroNode5.getRight();
        System.out.println("10号节点的前驱节点是：" + leftNode);
        System.out.println("10号节点的后置节点是：" + rightNode);
    }
}

//二叉树的英雄节点
class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;
    //定义节点的类型，如果为0，表示节点的左（右）节点是子树，如果为1，表示节点的左（右）节点是前驱（后继）节点
    private int leftType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    private int rightType;

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

//线索化二叉树，需要线索化的节点就是有空置的 左/右节点 的节点
class ThreadedBinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //
    private HeroNode pre = null;
    //中序遍历方式实现二叉树节点的线索化
    public void threadedNode(){
        threadedNode(root);
    }
    public void threadedNode(HeroNode node){
        if (node == null){
            //System.out.println("二叉树为空，无法线索化");
            return;
        }
        //先向左线索化
        threadedNode(node.getLeft());

        //当前节点的线索化
        if (node.getLeft() == null){
            //设置当前节点的前置节点
            node.setLeft(pre);
            //设置当前节点的左节点类型
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null){
            //设置当前节点的后继节点
            pre.setRight(node);
            //设置当前节点的右节点类型
            pre.setRightType(1);
        }
        //将当前节点设置为下一节点的前置节点
        pre = node;
        //向右线索化
        threadedNode(node.getRight());
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
