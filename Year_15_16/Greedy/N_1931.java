package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N_1931 {
	//도착시간을 기준으로 정렬한다음 얼마나 많은 회의를 할수있는지를 체크
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] time = new int[T][2];
		for (int i = 0; i < T; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		//y기준 즉 끝나는시간으로 정렬
		  Arrays.sort(time, new Comparator<int []>(){
		    public int compare(int a[] , int b[]){
		    		if(a[1] > b[1]){
		    			return 1;
		    		}
		    		else if(a[1]==b[1]){
		    			if(a[0]>b[0]){
		    				return 1;
		    			}
		    			else if(a[0]==b[0]){
		    				return 0;
		    			}
		    			else{
		    				return -1;
		    			}
		    		}
		    		else{
		    			return -1;
		    		}
		    	}
			});    
		
		for(int i =0; i<T; i++){
			for(int j =0; j<2; j++){
				System.out.print(time[i][j]+"/");
			}
			System.out.println();
		}

		int cnt = 1;
		int endt = time[0][1];
		for (int i = 1; i < T; i++) {
			if (endt <= time[i][0]) {
				endt = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}