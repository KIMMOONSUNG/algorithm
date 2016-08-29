import java.util.Scanner;

public class N2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int now = 0;
		int count = 1;
		int count2 = 1;
		int max = 0;
		int max2 = 0;
		int arr[] = new int[number];
		for (int i = 0; i < number; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i < number; i++) {
			now = arr[i];
			if (now == arr[i - 1]) {
				count++;
				count2++;
			} else if (now - 1 == arr[i - 1] || (now > arr[i - 1] && i != number - 1 && now == arr[i + 1])) {
				count++;
			} else if (now + 1 == arr[i - 1] || (now < arr[i - 1] && i != number - 1 && now == arr[i + 1])) {
				count2++;
			} else {
				count = 1;
				count2 = 1;
			}
			if (max < count || max < count2) {
				max = count;
				max2 = count2;
			}
		}
        if(max2==1&& max==1){
        	System.out.println(2);
        }
        else if (max2 > max)
			System.out.println(max2);
		else
			System.out.println(max);
	}
}
