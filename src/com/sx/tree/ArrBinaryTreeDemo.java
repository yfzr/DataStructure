package com.sx.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree abt = new ArrBinaryTree(arr);
        //abt.preOrder();
        //abt.infixOrder();
        abt.postOrder();
    }
}

//创建二叉树，利用数组结构顺序存储二叉树的节点
class ArrBinaryTree{
    private int[] arr;
    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }
    //前序遍历
    public void preOrder(){
        preOrder(0);
    }
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("二叉树为空，无法遍历");
            return;
        }
        //先输出当前节点
        System.out.println(arr[index]);
        //向左遍历，父节点的左子节点索引为 2 * index + 1
        if (2 * index + 1 < arr.length){
            preOrder(2 * index + 1);
        }
        //向右遍历，父节点的右子节点索引为 2 * index + 2
        if (2 * index + 2 < arr.length){
            preOrder(2 * index + 2);
        }
    }
    //中序遍历
    public void infixOrder(){
        infixOrder(0);
    }
    public void infixOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("二叉树为空，无法遍历");
            return;
        }
        //先向左遍历，父节点的左子节点索引为 2 * index + 1
        if (2 * index + 1 < arr.length){
            infixOrder(2 * index + 1);
        }
        //输出当前节点
        System.out.println(arr[index]);
        //向右遍历，父节点的右子节点索引为 2 * index + 2
        if (2 * index + 2 < arr.length){
            infixOrder(2 * index + 2);
        }
    }
    //后序遍历
    public void postOrder(){
        postOrder(0);
    }
    public void postOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("二叉树为空，无法遍历");
            return;
        }
        //先向左遍历，父节点的左子节点索引为 2 * index + 1
        if (2 * index + 1 < arr.length){
            postOrder(2 * index + 1);
        }
        //向右遍历，父节点的右子节点索引为 2 * index + 2
        if (2 * index + 2 < arr.length){
            postOrder(2 * index + 2);
        }
        //输出当前节点
        System.out.println(arr[index]);
    }
}
