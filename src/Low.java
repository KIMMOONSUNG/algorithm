import java.util.Scanner;

public class Low {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int people = sc.nextInt();
		//int arr[] = new int[people];
		int arr2[] = new int[people];
		for (int i = 0; i < people; i++) { 
			//arr[i] = i + 1;
			arr2[i] = sc.nextInt();
		}
		for(int i =0; i<people; i++){
			int nowpeople = i+1;
			for(int j=i; j>i-arr2[i]; j--){
				arr2[j]=1;
			}
			arr2[i] = nowpeople;
		}
		/*
		for (int i = 0; i < people; i++) {
				int nowpeople = arr[i]; 
				for (int j = i ; j > i-arr2[i]; j--) {
					arr[j]=arr[j-1];
				}
				arr[i - arr2[i]] = nowpeople;
		}*/
		for (int i = 0; i < people; i++) {
			System.out.print(arr2[i] + " ");
		}
		
	}
}
