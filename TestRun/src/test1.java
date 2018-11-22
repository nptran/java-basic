import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class test1 {

	private static Scanner scanner;
	
	private static Formatter x;
	public static void creatFile() {
		try {
			x = new Formatter("fred.txt");		
		} catch (Exception e) {
			System.out.println("You got an error.");
		}
	}
	
	public static void scanFile() {
		try {
			scanner = new Scanner(new File("fred.txt"));
			System.out.println("Scanned");
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file");
		}
		
		
	}
	
	private static void addRecords() {
//			x.format("%s%s%s", "Phuc ","20 ","JAVA");
			x.format("%s%s%s", "Linh", "20", "RUBY");
			System.out.println("Added");
	}
	
	private static void readFile() {
		while (scanner.hasNext()) {
			String a = scanner.next();
			System.out.println("1...");
//			String b = scanner.next();
//			System.out.println("2...");
//			String c = scanner.next();
			System.out.printf("%s",a);
			
		}
			
	}
	
	private static void closeFile() {
		scanner.close();
		System.out.println("CLOSED file.");
	}

	public static void main(String[] args) {
		
		scanFile();
		readFile();
		closeFile();
		
	}
}
