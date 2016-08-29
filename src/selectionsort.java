import java.util.Scanner;

public class selectionsort {
	public static void main(String args[]) {
		int arr[] = { 8, 31, 48, 73, 3, 65, 20, 29, 11, 15 };
		for (int i = 0; i < arr.length ; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) { // 오름차순
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print("/"+arr[i]);
		}

	}
}
