import java.util.ArrayList;
import java.util.Scanner;

public class Low2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		int arr[] = new int[people];
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		for (int i = 0; i < people; i++) {
			arr[i] = sc.nextInt();
		//	arraylist.add(i, i + 1); // 사람 넣고 할때 
		}
		for (int i = 0; i < people; i++) {
				arraylist.add(i - arr[i], i+1);
		}
		for (int i = 0; i < people; i++) {
			System.out.print(arraylist.get(i) + " ");
		}
	}
}
