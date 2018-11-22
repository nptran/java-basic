package javabasic;

import java.util.Scanner;

public class P {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t=scanner.nextInt(), testCase=0;
		while (t-->0) {
			testCase++;
			int n=scanner.nextInt(), m=scanner.nextInt();
			int[][] matrix= input(n, m), 
					matrixT = transposition(n, m, matrix),
					mul = mul(n, m, matrix, m, n, matrixT);
			System.out.printf("Test %d:\n", testCase);
			show(mul, n, n);
		}
	}
	
	public static void show(int[][] matrix, int n, int m) {
		for (int i =0; i <n; i++) {
			for (int j =0; j <m; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static int[][] input(int n, int m) {
		int[][] matrix = new int[n][m];
		for (int i =0; i <n; i++) {
			for (int j =0; j <m; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		return matrix;
	}
	
	public static int[][] transposition(int n, int m, int[][] matrix) {
		
		int heiT = m;
		int widT = n;
		int[][] matrixT = new int[heiT][widT];
		
		for (int i =0; i <heiT; i++) {
			for (int j =0; j <widT; j++) {
				matrixT[i][j] = matrix[j][i];
			}
		}
		
		return matrixT;
	}
	
	public static int[][] mul(int n1, int m1, int[][] mat1, int n2, int m2, int[][] mat2) {
		int heiAns = n1, widAns = m2;
		int[][] matAns = new int[heiAns][widAns];
		
		if (m1 == n2) {
			for (int i =0; i <heiAns; i++) {
				for (int j =0; j <widAns; j++) {
					for (int k =0; k <n2; k++) {
						matAns[i][j] += mat1[i][k] * mat2[k][j];
					}
				}
			}
		}
		return matAns;
	}
}
