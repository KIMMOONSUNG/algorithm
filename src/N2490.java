import java.util.Scanner;

public class N2490 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[3][4];
		char arr2[] = { 'D', 'C', 'B', 'A', 'E', 0, 0, 0 };
		int total = 0;
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 4; b++) {
				arr[a][b] = sc.nextInt();
				total += arr[a][b];
			}
			arr2[a + 5] = arr2[total];
			total = 0;
		}
		for (int a = 5; a < 8; a++) {
			System.out.println(arr2[a]);
		}
	}
}
