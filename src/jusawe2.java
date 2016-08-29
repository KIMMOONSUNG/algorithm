import java.util.Arrays;
import java.util.Scanner;

public class jusawe2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int money1 = 0;
		int arr[] = new int[3];
		int arr2[] = new int[people];
		for (int i = 0; i < people; i++) {
			for (int j = 0; j < 3; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr); 
			if (arr[0] == arr[1] && arr[0] == arr[2]) { // 정렬되었을때 0이 1과 2와 같으므로 주사위세번다 같은수일경우 
				money1 = 10000 + (arr[0] * 1000);
				arr2[i] = money1;
			} else if (arr[0] == arr[1]) { // 2개가같은경우
				money1 = 1000 + (arr[0] * 100);
				arr2[i] = money1;
			} else if (arr[1] == arr[2]) { // 2개가 같은경우
				money1 = 1000 + (arr[2] * 100);
				arr2[i] = money1;
			} else {   // 다 다른경우
				money1 = arr[2] * 100;
				arr2[i] = money1;
			} 
		}
		Arrays.sort(arr2);
		System.out.println(arr2[people - 1]);
	}
}
