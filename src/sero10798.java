import java.util.Scanner;

public class sero10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = new String[5];
		char arr2[][] = new char[5][15];
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.next();
			for (int j = 0; j < arr[i].length(); j++) {
				arr2[i][j] = arr[i].charAt(j); // arr[i] 의  문자열 중 j번째 문자 1개를 반환해 arr2[i][j]에 넣는다
			}
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr2[j][i] != 0)
					System.out.print(arr2[j][i]);
			}
		}
	}
}
