import java.util.Scanner;

public class N2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();// 시
		int m = sc.nextInt();// 분
		int total = sc.nextInt();// 걸리는시간
		if (m + total > 59) {
			t += (m + total) / 60;
			m = (m + total) % 60;
			if (t > 23) {
				t = t - 24;
			}
		} else {
			m += total;
		}
		System.out.print(t + " " + m);
	}
}
