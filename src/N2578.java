import java.util.Scanner;

public class N2578 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[5][5];
		int arr2[][] = new int[5][5];
		int arr3[] = new int[25];
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		int bingo = 0;
		int C = 0;
		int num4 = 0;
		int now = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr2[i][j] = sc.nextInt();
				C++; // 몇번째일때 빙고인지 알게하기위해

				for (int a = 0; a < 5; a++) {
					for (int b = 0; b < 5; b++) {
						if (arr[a][b] == arr2[i][j]) {
							arr[a][b] = 0; // 같으면 0을넣어준다 
						}
					}
				}
				for (int a = 0; a < 5; a++) {
					for (int b = 0; b < 5; b++) {
						num += arr[a][b]; // 가로
						num2 += arr[b][a]; //세로 
						num3 += arr[b][b];// 대각선
						num4 += arr[b][4 - b]; //대각선2
					}
					if (num == 0) {
						bingo++;
					}
					if (num2 == 0) {
						bingo++;
					}
					if (num3 == 0) {
						bingo++;
					}
					if (num4 == 0) {
						bingo++;
					}
					if (bingo == 3) {
						arr3[now] = C; // 몇번째인지를 배열에 넣는다 
						now++;
					}
					if (num3 == 0 || num4 == 0) {
						bingo--; //대각선들은 계속도니까  bingo값증가하지않게  한번할때 - 해준다 .
					}
					num = 0;
					num2 = 0;
					num3 = 0;
					num4 = 0;
				}
				bingo = 0;
			}
		}
		System.out.println(arr3[0]); // 인덱스 첫번째꺼가 빙고 처음됬을때의 순번
	}
}
