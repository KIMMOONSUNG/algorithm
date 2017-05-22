package Study;

import java.util.Scanner;

public class N_11054 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int d1[] = new int[n];
		int d2[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}		
		
		for(int i =0; i<n; i++){//K
			d1[i] = 1;
			for(int j=0; j<i; j++){//K앞부분
				if(arr[i]>arr[j] && d1[i]<d1[j]+1){
					d1[i] = d1[j]+1;
				}
			}
		}
		for(int i=n-1; i>=0; i--){//K
			d2[i] =1;
			for(int j=i+1; j<n; j++){//K뒤부분
				if(arr[i]>arr[j] && d2[i]<d2[j]+1){
					d2[i] = d2[j]+1;
				}
			}
		}
		int result =-1;
		for(int i =0; i<n; i++){
			if(result<d1[i]+d2[i]-1){
				result = d1[i]+d2[i]-1;
			}
		}
		System.out.println(result);
	}
		
}
