import java.util.Scanner;

public class dpN2579 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stepnum = sc.nextInt();
		int arr[] = new int[stepnum + 1];
		int arr2[] = new int[stepnum + 1]; // 변수배열
		int count = 0;
		for (int i = 1; i < stepnum + 1; i++) {
			arr[i] = sc.nextInt();
		}
		arr2[stepnum] = arr[stepnum];

		if (stepnum == 2) {
			arr2[1] = arr[1] + arr[2];
		} else {
			for (int a = stepnum - 1; a > 1; a--) {
				if (arr[a] >= arr[a - 1]) {
					arr2[a] = arr2[a + 1] + arr[a];
					a--;
					if (a == 1 && count != 0) {
						arr2[a] = arr2[a + 1];
					} else if (a == 1 && count == 0) {
						arr2[a] = arr2[a + 1] + arr[a];
					} else {
						arr2[a - 1] = arr[a - 1] + arr2[a + 1];
						a--;
					}
					count = 1;

				} else {
					if (a == 4 && count != 1 && arr[a - 2] + arr[a - 3] >= arr[a - 1]) {
						arr2[a] = arr[a] + arr2[a + 1];
						count = 1;
					} else if (a == 4 && count == 1 && arr[a - 2] + arr[a - 3] >= arr[a - 1]) {
						arr2[a] = arr[a] + arr2[a + 1];
						a--;
						arr2[a] = arr2[a + 1];
						count = 0;
					} else {
						arr2[a - 1] = arr[a - 1] + arr2[a + 1];
						a--;
						count = 1;
					}
				}
				if (a == 2) {
					arr2[a - 1] = arr[a - 1] + arr2[a];
				}
			}
		}
		System.out.println(arr2[1]);
	}

}
