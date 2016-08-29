import java.util.Arrays;
import java.util.Scanner;

public class joiA {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int arr[] = new int [4];
	int arr2[] = new int [2];
	for(int i =0; i<4; i++){
		arr[i]=sc.nextInt();
	}
	for(int j=0; j<2; j++){
		arr2[j]=sc.nextInt();
	}
	Arrays.sort(arr);
	Arrays.sort(arr2);
	System.out.println(arr[1]+arr[2]+arr[3]+arr2[1]);
}
}
