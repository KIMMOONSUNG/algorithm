import java.util.Scanner;

public class insertionsort {
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// System.out.println("값을 입력해주세요:");
		// int num1 = sc.nextInt();
		int arr[] = { 11, 10, 9, 8, 1, 4, 3, 7, 5 };
		// 선택정렬 인덱스 1부터 기준 으로 왼쪽과 비교
		for (int i = 1; i < arr.length; i++) {
			int standard = arr[i]; // standard->기준 값
			int aux = i - 1; // aux->비교대상의인덱스
			// 인덱스를 기준으로 짠다.
			while (aux >= 0 && standard < arr[aux]) {
				arr[aux + 1] = arr[aux];
				aux--;
			}
			arr[aux + 1] = standard;
		}
		for (int i = 0; i < arr.length; i++) // 완성된배열값출력
		{
			System.out.print(arr[i] + "/");
		}

	}
}
