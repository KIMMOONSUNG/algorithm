import java.util.Scanner;

public class N2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int computer = sc.nextInt();
		int connect = sc.nextInt();
		int num = 0;
		int num2 = 0;
		int c = 0;
		int count = 0;
		int arr[][] = new int[connect][2];
		int arr2[] = new int[110];
		int ar[] = new int[computer+1];
		for(int a=1;a<computer+1; a++){
			ar[a]=a;
		}
		for (int a = 0; a < connect; a++) {
			for (int b = 0; b < 2; b++) {
				arr[a][b] = sc.nextInt();
			}
			if (arr[a][0] == ar[1]) {
				arr2[num] = arr[a][1];
				num++;
			}
		}
		num2 = num;
		for (int a = 0; a < connect; a++) {
			for (int b = 0; b < num2; b++) {
				if (arr[a][0] == arr2[b]) {
					for (int i = 0; i < num2; i++) {
						if (arr[a][1] == arr2[i]) {
							c = 1;
							break;
						}
					}
					if (c != 1) {
						arr2[num] = arr[a][1];
						num++;
						count++;
					}
					c = 0;
				}
			}
			if (a == connect - 1) {
				num2 = num;
				if (count == 0) {
					break;
				} else {
					count = 0;
					a = 0;
				}
			}
		}
		System.out.println(num);
	}
}
