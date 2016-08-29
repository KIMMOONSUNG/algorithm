import java.util.Arrays;
import java.util.Scanner;

public class averagecenter {
	public static void main(String[] args) {
		int arr[] = new int[5]; // 0~4
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		System.out.println(sum / 5);
		System.out.println(arr[2]);
	}
}
