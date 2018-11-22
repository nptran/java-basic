package javabasic;

import java.util.Scanner;

public class N {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t =scanner.nextInt();
		int testCase = 0;
		while(t-->0) {
			testCase++;
			int n=scanner.nextInt();
			if (1<n && n<20) {
				int[][] spiral = spiral(n);
				System.out.printf("Test %d:\n", testCase);
				show(n, spiral);
			}
		}
		scanner.close();
	}
	
	public static void show(int n, int[][] matrix) {
		for (int i =0; i <n; i++) {
			for (int j =0; j <n; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public static int[][] spiral(int n) {
		int row =0;		int col =0;
		int wid =n;		int hei =n;
		int[][] spiral = new int[n][n];
		int value = n*n;
		
		while (value >=1) {
			for (int i =col; i <wid; i++) {
				spiral[col][i] = value--;
			}
			for (int j =row+1; j <hei; j++) {
				spiral[j][hei-1] = value--;
			}
			for (int x =wid-2; x >=col; x--) {
				spiral[wid-1][x] = value--;
			}
			for (int y =hei-2; y >row; y--) {
				spiral[y][col] = value--;
			}
			wid--;
			hei--;
			row++;
			col++;
		}
		
		return spiral;
	}
	
}
