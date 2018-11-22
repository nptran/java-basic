import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 * 
 */

/**
 * @author Phuc Tran
 *
 */
public class Test {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		LocalDate dob = LocalDate.parse(str, FORMATTER);
		
		System.out.println(dob.toString());
	}
}
