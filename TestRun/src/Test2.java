import java.util.Scanner;

public class Test2 {
	


	public static void main(String[] args) {
		num t = new num();
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		t.setNumberofcomputers(num);
		
		System.out.println(t.getNumberofcomputers());

	if (t.getNumberofcomputers() > 10) {
		System.out.println("True");}
	else System.out.println("False");
	}
}
