import java.util.Arrays;
import java.util.Scanner;

public class jusawe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int money1, number = 0;
		int arr[][] = new int[people][3];
		int arr2[] = new int[people];
		for (int i = 0; i < people; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
				int standard = arr[i][j];
				int aux = j - 1;
				while (aux >= 0 && standard < arr[i][aux]) {
					arr[i][aux + 1] = arr[i][aux];
					aux--;
				}
				arr[i][aux + 1] = standard;
			}
		}
		for (int i = 0; i < people; i++) {
			number = arr[i][0];
			if (number == arr[i][1] && number == arr[i][2]) { //주사위 세번다 같은경우
				money1 = 10000 + (number * 1000);
				arr2[i] = money1;
			} else if (number == arr[i][1]) { //두개 같은경우
				money1 = 1000 + (number * 100);
				arr2[i] = money1;
			} else if (arr[i][1] == arr[i][2]) { //두개 같은경우
				money1 = 1000 + (arr[i][2] * 100);
				arr2[i] = money1;
			} else { // 하나같은경우
				money1 = arr[i][2] * 100;
				arr2[i] = money1;
			}
		}
		Arrays.sort(arr2);
		System.out.println(arr2[people - 1]);
	}
}
