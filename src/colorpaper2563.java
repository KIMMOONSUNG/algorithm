import java.util.Scanner;

public class colorpaper2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int paper = sc.nextInt();
		int arr[][] = new int[101][101];
		int num = 0;
		for (int k = 0; k < paper; k++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					arr[x + i][y + j] = 1;
				}
			}
		}
		for (int a = 1; a < 101; a++) {
			for (int b = 1; b < 101; b++) {
				if (arr[a][b] == 1) {
					num++;
				}
			}
		}
		System.out.println(num);
	}
}
