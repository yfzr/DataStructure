package com.sx.sparsearray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArr {

	public static void main(String[] args) throws IOException {

	/**
	 * 1.创建一个原始的二维数组	11*11
	 * 		0：表示没有棋子	1：表示黑子	2：表示蓝子
	 */	
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		//输出原始二维数组,并统计非零数据个数
		int sum = 0;
		System.out.println("原始二维数组：");
		for (int[] row : chessArr1) {
			for (int value : row) {
				System.out.printf("%d\t", value);
				if (value != 0) {
					sum++;
				}
			}
			System.out.println();
		}
		
		/**
		 * 2.将二维数组转为稀疏数组
		 */
		System.out.println("------------------------------------");
		System.out.printf("共有%d个非零数据\n", sum);
		int[][] sparseArr1 = new int[sum + 1][3];
		sparseArr1[0][0] = 11;
		sparseArr1[0][1] = 11;
		sparseArr1[0][2] = sum;
		int count = 0;
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr1[count][0] = i;
					sparseArr1[count][1] = j;
					sparseArr1[count][2] = chessArr1[i][j];
				}
			}
		}
		System.out.println("生成的稀疏数组如下：");
		for (int i = 0; i < sparseArr1.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
		}
		System.out.println("------------------------------------");
		
		//将稀疏数组保存在map.data文件中
		System.out.println("将稀疏数组保存在map.data文件中...");
		FileOutputStream fos = new FileOutputStream("map.data");
		//byte[] arr = new byte[8*1024];
		//int len;
		for (int i = 0; i < sparseArr1.length; i++) {
			String s = sparseArr1[i][0] + "\t" + sparseArr1[i][1] + "\t" + sparseArr1[i][2] + "\n";
			//fw.write(s);
			byte[] b = s.getBytes();
//			for (byte c : b) {
//				System.out.println(c);
//			}
			fos.write(b);
//			for (int j = 0; j < 3; j++) {
//				fos.write(sparseArr1[i][j]);;
//			}
		}
		System.out.println("------------------------------------");
		//读取map.data中的稀疏数组
		System.out.println("读取map.data中的稀疏数组：");
		BufferedReader br = new BufferedReader(new FileReader("map.data"));
		String line;
		int count2 = 0;
		int len = 0;
		int a = 0;
		int[] arr = new int[12];
		while ((line = br.readLine()) != null) {
			count2++;
			String[] s1 = line.split("\t");
			len = s1.length;
			for (int i = 0; i < s1.length; i++) {
				arr[a] = Integer.parseInt(s1[i]);
				a++;
			}
		}
//		for (int i : arr) {
//			System.out.println(i);
//		}
		int[][] sparseArr2 = new int[count2][len];
		int count3 = 0;
		for (int i = 0; i < sparseArr2.length; i++) {
			for (int k = 0; k < len; k++) {
				sparseArr2[i][k] = arr[count3];
				count3++;
			}
		}
		for (int i = 0; i < sparseArr2.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArr2[i][0], sparseArr2[i][1], sparseArr2[i][2]);
		}
		System.out.println("------------------------------------");
		
		/**
		 * 3.将稀疏数组转为原始二维数组 
		 */
		int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
		for (int i = 1; i < sparseArr2.length; i++) {
				chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
		}
		System.out.println("还原的原始二维数组如下：");
		for (int[] row : chessArr2) {
			for (int value : row) {
				System.out.printf("%d\t", value);
			}
			System.out.println();
		}
	}

}
