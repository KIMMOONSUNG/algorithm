import java.util.Scanner;

// 달팽이 배열//
public class sit10157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int number = sc.nextInt();
		int arr[][] = new int[c + 1][r + 1]; // 1,1부터 할꺼라서 1씩 배열크기 늘림
		int limit = r + 1;// 가로나타냄
		int limit2 = c; // 세로나타냄 기존보다 1감소해야함.
		int num = 1;
		int delta = 1;
		int i = 1;
		int j = 0;
		while (true) { // 무한루프
			for (int a = 1; a < limit; a++) { // 가로이동일때
				j += delta;
				arr[i][j] = num;
				num++;
			}
			limit--;
			if (limit <= 0)
				break;
			for (int p = 1; p < limit2; p++) {// 세로이동일때
				i = i + delta;
				arr[i][j] = num;
				num++;
			}
			limit2--;
			if (limit2 <= 0)
				break;
			delta = -delta; // **이동방향 바뀜**
		}
		for (int p = 1; p < c + 1; p++) {
			if (number > c * r) {
				System.out.println(0);
				break;
			}
			for (int q = 1; q < r + 1; q++) {
				if (arr[p][q] == number) {
					System.out.println(p + " " + q);
				}
			}
		}
	}
}
