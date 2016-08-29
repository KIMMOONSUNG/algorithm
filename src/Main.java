import java.util.Scanner;

public class Main {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[7];
		int sum = 0;
		int min = 100;
		for (int i = 0; i < 7; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}
		for (int i = 0; i < 7; i++) {
			if (arr[i] % 2 != 0) {
				sum += arr[i];
				if (min > arr[i]) {
					min = arr[i];
				}
			}
		}
		if (sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			sum = -1;
			System.out.println(sum);
		}
	}
}
