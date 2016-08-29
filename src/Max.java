import java.util.Scanner;

public class Max { // 최대값 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0];// 최대값
		int maxorder = 1; // 최대값순서
		for (int j = 1; j < 9; j++) {
			if (max < arr[j]) {
				max = arr[j];
				maxorder = j+1; //순서라 +1 해줌
			}
		}
		System.out.println(max);
		System.out.println(maxorder);
	}
}
