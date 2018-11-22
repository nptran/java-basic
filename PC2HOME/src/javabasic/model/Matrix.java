package javabasic.model;

import java.util.Scanner;

public class Matrix {
	
	private int[][] matrix;
	
	private int hei, wid;
	
	private static Scanner scanner = new Scanner(System.in);
	
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public int getHei() {
		return hei;
	}

	public void setHei(int hei) {
		this.hei = hei;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public void show() {
		for (int i =0; i <this.hei; i++) {
			for (int j =0; j <this.wid; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public int[][] input() {
		
		setHei(scanner.nextInt());
		setWid(scanner.nextInt());
		matrix = new int[hei][wid];
		for (int i =0; i <hei; i++) {
			for (int j =0; j <wid; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		return matrix;
	}
	
	public int[][] transposition() {
		int heiT = this.getWid();
		int widT = this.getHei();
		int[][] matrixT = new int[heiT][widT];
		
		for (int i =0; i <heiT; i++) {
			for (int j =0; j <widT; j++) {
				matrixT[i][j] = matrix[j][i];
			}
		}
		setHei(heiT);
		setWid(widT);
		matrix = matrixT;
		return matrix;
	}
	
	/*===============================Calculate Matrix============================*/
	//multiplication 2 matrices.
	public Matrix mul(Matrix matFactor) {
		Matrix matAns = new Matrix();
		
		if (this.getWid() == matFactor.getHei()) {
			int heiAns = this.getHei();
			int widAns = matFactor.getWid();
			
			int[][] ans = new int[heiAns][widAns];
			int[][] factor = matFactor.getMatrix();
			
			for (int i =0; i <heiAns; i++) {
				for (int j =0; j <widAns; j++) {
					for (int k =0; k <matFactor.getHei(); k++) {
						ans[i][j] += matrix[i][k] * factor[k][j];
					}
				}
			}
			
			matAns.setHei(heiAns);
			matAns.setWid(widAns);
			matAns.setMatrix(ans);
		}
		else {
			System.out.println("Can not be multiplied!");
		}
		
		return matAns;
	}
	
	/*===================================Create Spiral Matrix===========================================*/
	public Matrix spiral(int n) {
		Matrix spiralMat = new Matrix();
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
		
		spiralMat.setHei(n);
		spiralMat.setWid(n);
		spiralMat.setMatrix(spiral);
		return spiralMat;
	}

}
