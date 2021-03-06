package ImmediateJavaDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Collections_and_Convert_List_to_Arrays {

	public static void main(String[] args) {

		String[] arr = {"apple", "banana", "orange", "lemon"};
		List<String> things = new LinkedList<>(Arrays.asList(arr));
		
		String[] arr1 = {"5"};
		List<String> things1 = new LinkedList<>(Arrays.asList(arr1));
		
		Collections.sort(things, Collections.reverseOrder());
		System.out.printf("%s\n", things);
		
		boolean tof = Collections.disjoint(things, things1);
		System.out.println("These lists DON'T have anything in common: " + tof);
		
		/*
		 .frequency(list, element)  
		this method will return how many time "element" appear in the "list"*/
		
		/*
		 .disjoint(list1, list2)     [boolean type]
		 this method check these list have any element in common 
		 if DONT HAVE ANY COMMON return TRUE or else return false).*/
		
	
	}
}

