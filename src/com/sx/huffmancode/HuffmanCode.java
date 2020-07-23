package com.sx.huffmancode;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args){
        /*
        //编码字符串
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println("数据原始长度：" + content.length());
        //编码
        byte[] huffmanCodeBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的长度：" + huffmanCodeBytes.length);
        System.out.println("压缩率：" + zipRate(content.length(), huffmanCodeBytes.length));
        //解码
        String s = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println("解码：" + s);
         */
        /*
        //转换为字节数组
        byte[] contentBytes = content.getBytes();
        //通过文本的字节数组，建立霍夫曼树的节点信息
        List<Node> nodes = getNodes(contentBytes);
        System.out.println("notes=" + nodes);
        //建立霍夫曼树
        Node root = creatHuffmanTree(nodes);
        //前序遍历查看
        preOrder(root);
        //获取霍夫曼编码
        Map<Byte, String> map = getCodes(root);
        System.out.println("霍夫曼编码表：" + map);
        //
        byte[] huffmanCodeBytes = zip(contentBytes, map);
        System.out.println(Arrays.toString(huffmanCodeBytes));
        */

        //文件压缩测试
        String srcFile = "F://src.png";
        String destFile = "F://dest.zip";
        zipFile(srcFile, destFile);

    }

    /**
     * 计算压缩率
     * @param a 原始的长度
     * @param b 压缩后的长度
     * @return 压缩率
     */
    public static double zipRate(double a, double b) {
        if (a > 0 && b > 0){
            return (a - b) / a;
        }else {
            System.out.println("数据有误");
            return -1;
        }
    }

    /**
     * 封装霍夫曼数据压缩过程
     * @param contentBytes 待编码的原始数据
     * @return 压缩后的数据（字节数组）
     */
    public static byte[] huffmanZip(byte[] contentBytes){
        //通过字节数组，建立霍夫曼树的节点信息
        List<Node> nodes = getNodes(contentBytes);
        //根据节点，建立霍夫曼树
        Node root = creatHuffmanTree(nodes);
        //获取霍夫曼编码
        Map<Byte, String> map = getCodes(root);
        //根据霍夫曼编码，以字节长度（8位）为单位，压缩数据
        byte[] huffmanCodeBytes = zip(contentBytes, map);
        return huffmanCodeBytes;
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

    /**
     * 霍夫曼编码压缩
     * @param bytes 原始信息的字节数组
     * @param huffmanCodes 不同字节信息对应的霍夫曼编码路径
     * @return 压缩后的信息数组
     */
    public static byte[] zip(byte[] bytes, Map<Byte, String > huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        //遍历原始信息数组，将不同的字节信息对应的霍夫曼编码依次拼接成串
        for (byte b: bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        //根据霍夫曼编码的长度，建立对应的存放二进制编码的数组
        int len;
        if (stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else {
            len = stringBuilder.length() / 8 + 1;
        }
        byte[] huffmanCodeBytes = new byte[len];
        //以字节长度为单位，压缩霍夫曼编码
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String strByte;
            //注意索引越界，此时截取剩余的编码即可
            if (i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i, i +8);
            }
            //将截取到的二进制串转为字节
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 将一个字节转换为二进制字符串
     * @param flag 标志是否需要补高位，true为需要，如果是最后一个字节，无需补高位
     * @param b 待转换的字节
     * @return 二进制字符串
     */
    public static String byteToBitString(boolean flag, byte b){
        //将字节存放在int类型中，但是会因此自动补上前面的3个字节
        int temp = b;
        if (flag){
            temp |= 256;    //按位与 256 -> 1 0000 0000
        }
        //利用Integer的方法转为二进制
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }

    /**
     * 解码
     * @param huffmanCodes 霍夫曼编码表
     * @param huffmanCodeBytes 编码后（压缩后）的字节数组
     * @return 原始字符串
     */
    public static String decode(Map<Byte, String> huffmanCodes, byte[] huffmanCodeBytes){
        StringBuilder stringBuilder = new StringBuilder();
        //将编码后的字节数组转换为二进制字符串
        for (int i = 0; i < huffmanCodeBytes.length; i++) {
            Byte b = huffmanCodeBytes[i];
            //判断是否是最后一个字节，最后一个字节可能不满8位
            boolean flag = (i == huffmanCodeBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        //将霍夫曼表调换存储，便于反向查询
        Map<String, Byte> map = new HashMap();
        for (Map.Entry<Byte, String> entry: huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        List<Byte> list = new ArrayList<>();
        //将二进制字符串根据不同的字节进行拆分
        for (int i = 0; i < stringBuilder.length();) {
            String key = null;
            int count = 1;
            Byte b = null;
            boolean flag = true;
            while (flag){
                //逐步截取字符串
                key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                //没有匹配值，则继续截取
                if (b == null){
                    count++;
                //有匹配值，则结束
                }else {
                    flag = false;
                }
            }
            list.add(b);
            //i从匹配到的索引后继续开始
            i += count;
        }
        //将list中的字节存入数组
        byte[] resBytes = new byte[list.size()];
        for (int i = 0; i < resBytes.length; i++) {
            resBytes[i] = list.get(i);
        }
        return new String(resBytes);
    }


    public static void zipFile(String srcFile, String destFile){
        FileInputStream fis = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(srcFile);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] huffmanBytes = huffmanZip(bytes);
            oos = new ObjectOutputStream(new FileOutputStream(destFile));
            oos.writeObject(huffmanCodes);
            oos.writeObject(huffmanBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
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
