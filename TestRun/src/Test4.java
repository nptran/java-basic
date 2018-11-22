import java.util.Scanner;

public class Test4 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter n: ");
		int n = scanner.nextInt();
		String[][] a = new String[n][n];
		for (int i = n-1; i == 0; i--) {
			for (int j = 0; j < n; j++) {
				a[i][j] = "*";
			}
		}
	
		System.out.println(a[i][j]);
	}
}
