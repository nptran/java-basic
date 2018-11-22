import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test5
{

	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Bạn muốn nhập bao nhiêu số?");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Nhập vào các số:");
		for(int counter = 0; counter<n; counter ++){
			arr[counter] = sc.nextInt();
		}
		System.out.println("Tổng các trị tuyệt đối của các phần tử là: "+sumAbsVals(arr));
		System.out.println("Số chẵn lớn nhất là: "+lagestEven(arr));
	}

	public static int sumAbsVals(int[] arr){
		return IntStream.of(arr)
				.map(n -> Math.abs(n))
				.sum();
	}

	public static int lagestEven(int[] i) {
		return IntStream.of(i)
	    .filter(n -> n % 2 == 0).max().getAsInt();
	}

}
