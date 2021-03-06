package com.sx.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args){
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree bst = new BinarySortTree();
        for (int i: arr) {
            Node n = new Node(i);
            bst.add(n);
        }
        System.out.println("中序遍历二叉排序树：");
        bst.infixOrder();

        //测试删除节点
        bst.delete(7);
        bst.delete(3);
        bst.delete(12);
        bst.delete(5);
        bst.delete(9);
        bst.delete(2);
        bst.delete(1);
        bst.delete(10);
        System.out.println("root=" + bst.getRoot());
        System.out.println("删除后");
        bst.infixOrder();
    }
}

//二叉排序树
class BinarySortTree{
    private Node root;
    //获取根节点
    public Node getRoot() {
        return root;
    }
    //添加节点
    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root == null){
            System.out.println("二叉树为空");
            return;
        }else {
            root.infixOrder();
        }
    }
    //查找节点
    public Node search(int value){
        if (root == null){
            return null;
        }else {

            return root.search(value);
        }
    }
    //查找需要节点的父节点
    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {

            return root.searchParent(value);
        }
    }
    //删除待删除节点的右子树的最小值
    public int delRightMin(Node node){
        //存放目标节点的右子节点
        Node target = node;
        //找到该节点下的最小值节点
        while (target.getLeft() != null){
            target = target.getLeft();
        }
        //删除最小值节点
        delete(target.getValue());
        return target.getValue();
    }
    //删除待删除节点的左子树的最大值
    public int delLeftMax(Node node){
        //存放目标节点的左子节点
        Node target = node;
        //找到该节点下的最大值
        while (target.getRight() != null){
            target = target.getRight();
        }
        //删除最大值的节点
        delete(target.getValue());
        return target.getValue();
    }
    //删除节点
    public void delete(int value){
        if (root == null){
            return;
        }
        //找到待删除的节点
        Node targetNode = search(value);
        //如果节点不存在，则直接返回
        if (targetNode == null){
            return;
        }
        //当待删除的节点是只有一个节点的树，则直接置空即可
        if (root.getLeft() == null && root.getRight() == null){
            root = null;
            return;
        }
        //找到待删除节点的父节点
        Node parentNode = searchParent(value);
        //1. 如果目标节点为叶子节点
        if (targetNode.getLeft() == null && targetNode.getRight() == null){
            //判断目标节点是否是左子节点，，用以配置其父节点
            if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value){
                parentNode.setLeft(null);
            //判断目标节点是否是右子节点，用以配置其父节点
            }else if (parentNode.getRight() != null && parentNode.getRight().getValue() == value){
                parentNode.setRight(null);
            }
        //2. 如果目标节点为有两个子节点的节点
        }else if (targetNode.getLeft() != null && targetNode.getRight() != null){
            //方式一
            //int minValue = delRightMin(targetNode.getRight());
            //targetNode.setValue(minValue);

            //方式二
            int maxValue = delLeftMax(targetNode.getLeft());
            targetNode.setValue(maxValue);
        //3. 如果目标节点为只有一个子节点的节点
        }else {
            //如果是左子节点
            if (targetNode.getLeft() != null){
                //如果一共只剩下两个节点，则父节点不存在，会出现空指令异常
                if (parentNode != null){
                    //判断目标节点是否是左子节点，用以配置其父节点
                    if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value){
                        parentNode.setLeft(targetNode.getLeft());
                        //判断目标节点是否是右子节点，用以配置其父节点
                    }else {
                        parentNode.setRight(targetNode.getLeft());
                    }
                //当父节点不存在，则子节点就成为根节点
                }else {
                    root = targetNode.getLeft();
                }
            //如果是右子节点
            }else {
                //同上
                if (parentNode != null){
                    //判断目标节点是否是左子节点，用以配置其父节点
                    if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value){
                        parentNode.setLeft(targetNode.getRight());
                        //判断目标节点是否是右子节点，用以配置其父节点
                    }else {
                        parentNode.setRight(targetNode.getRight());
                    }
                }else {
                    root = targetNode.getRight();
                }
            }
        }
    }
}

//节点
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
            if (this.left != null && value < this.value){
                return this.left.searchParent(value);
            //要删除节点的值大于当前节点的右子节点的值，则向右递归查找
            }else if (this.right != null && value >= this.value){
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
