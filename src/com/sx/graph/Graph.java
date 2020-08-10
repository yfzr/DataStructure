package com.sx.graph;

import java.util.ArrayList;

public class Graph {
    public int[][] edges;   //邻接矩阵，存放顶点之间的关系
    public ArrayList<String> vertexList;    //存放顶点
    public int edgesNum;    //边的数量

    public static void main(String[] args){
        String[] vertexes = {"A", "B", "C", "D", "E"};
        int n = 5;
        Graph graph = new Graph(5);
        for (String vertex: vertexes) {
            graph.insertVertex(vertex);
        }
        graph.insertEdges(0, 1, 1);
        graph.insertEdges(0, 2, 1);
        graph.insertEdges(1, 2, 1);
        graph.insertEdges(1, 3, 1);
        graph.insertEdges(1, 4, 1);
        graph.showGraph();
    }
    //图的初始化
    public Graph(int n){
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        edgesNum = 0;
    }
    //插入顶点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //插入边
    public void insertEdges(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgesNum++;
    }
    //查询边的数量
    public int getNumOfEdges(){
        return edgesNum;
    }
    //查询顶点的数量
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //查询索引对应的顶点值
    public String getVertex(int i){
        return vertexList.get(i);
    }
    //显示图的邻接矩阵
    public void showGraph(){
        for (int[] link: edges) {
            for (int weight: link) {
                System.out.print(weight + "\t");
            }
            System.out.println();
        }
    }
}
