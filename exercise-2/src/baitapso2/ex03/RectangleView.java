package baitapso2.ex03;

import java.util.Scanner;

public class RectangleView {
	private static Scanner scanner = new Scanner(System.in);
	
	public Rectangle input() {
		double width = scanner.nextDouble(), height = scanner.nextDouble();
		scanner.nextLine();
		String color = scanner.nextLine();
		Rectangle rectangle = new Rectangle(width,height,color);
		return rectangle;
	}
	
	public void display(Rectangle rectangle) {
		System.out.printf("Width: %.2f Height: %.2f Color: %s\n", rectangle.getWidth(), rectangle.getHeight(), rectangle.getColor());
	}

}
