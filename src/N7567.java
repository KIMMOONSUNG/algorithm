import java.util.Scanner;

public class N7567 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int total = 10;
		for (int j = 0; j < a.length() - 1; j++) {
			if (a.charAt(j) == a.charAt(j + 1)) {
				total += 5;
			} else {
				total += 10;
			}
		}
		System.out.println(total);
	}
}
