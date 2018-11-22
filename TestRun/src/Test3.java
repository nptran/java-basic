import java.util.Scanner;

import com.sun.java_cup.internal.runtime.Symbol;

public class Test3 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter n: ");
		int n = scanner.nextInt();
		String[][] arr = new String[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[0][j] = arr[n - 1][j] = arr[i][0] = arr[i][n - 1] = "*";
		
				for (i = 1; i < n-2; i++) {
					for(j = n-2; j==1; j--) {
						arr[i][j] = "*";
					}
				}

			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == null) {
					arr[i][j] = " ";
				} else
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}