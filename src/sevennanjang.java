import java.util.Arrays;
import java.util.Scanner;

public class sevennanjang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		int index,index2,sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == j) {
					continue;
				}
				index = i;
				index2 = j;
				if (sum - (arr[index] + arr[index2]) == 100) {
					arr[index] = 0;
					arr[index2] = 0;
					i = 9;
					j = 9;
				}
			}
		}
		Arrays.sort(arr);
		for (int a = 2; a < 9; a++)
			System.out.println(arr[a]);
	}
}
