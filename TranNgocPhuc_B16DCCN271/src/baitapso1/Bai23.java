package baitapso1;

public class Bai23 {
	
	public static int startOfRoad(int[] arr, int valEle) {
		int indexOfMax = 0;
		int sum =0;
		
		while (arr[indexOfMax]!=valEle) {
			sum += arr[indexOfMax++];
		}
		return sum;
	}
	
	public static void runningMan(int[] arr) {
		int distance =1;
		int maxDistance;
		int index =0;
		int[] distances = new int[arr.length];
		
		for (int i =0; i <arr.length-1; i++) {
			if (arr[i] > arr[i+1]) {
				distances[index++] = distance;
				distance = 1;
			}
			else if (i==arr.length-2) {
				if (arr[i] <= arr[i+1]) {
					distance++;
				}
				else {
					distance =1;
				}
				distances[index++] = distance;
			}
			else {
				distance++;
			}
		}
		
		maxDistance = Function.findMax(distances);
		System.out.println("Đường chạy dài nhất là: " + startOfRoad(distances, maxDistance) + " " + maxDistance);
	}
	
	public static void main(String[] args) {
		int[] arr = Function.inputArray(1000, 0);
		
		runningMan(arr);
	}

}
