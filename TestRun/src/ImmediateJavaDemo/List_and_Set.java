package ImmediateJavaDemo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*DIFFERENT List & Set
 * 
 * `List` allows have DUPLICATE elements in it.
 * `Set` DON'T allows have DUPLICATE in it.
 * */

public class List_and_Set {

	public static void main(String[] args) {
		String[] arr = {"apple", "banana", "orange", "banana", "lemon"};
		List<String> list = Arrays.asList(arr);
		System.out.println(list);
		

		Set<String> set = new HashSet<>(list);
		System.out.println(set);
	
	}
}
