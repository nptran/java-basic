package baitapso2.ex07ex08ex09ex10ex11ex12;

public class MyPoint {
	
	double x;
	double y;
	MyPoint p;
	
	//Khởi tạo mặc định cho x=0 và y=0
	public MyPoint() {}	
	
	//Khởi tạo đối tượng có toạ độ theo tham số
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//Khởi tạo đối tượng bản sao của đối tượng trong tham số
	public MyPoint(MyPoint p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double distance(MyPoint scPoint) {
		double distance = Math.sqrt(Math.pow(x-scPoint.getX(), 2) + Math.pow(y-scPoint.getY(),2));		
		return distance;
	}
	
	public static double distance(MyPoint p1, MyPoint p2) {
		double distance = Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(), 2) );
		return distance;
	}

}
