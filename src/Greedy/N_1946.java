package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N_1946 {
	public static void main(String[] args) {
		/// BufferedReader로 하면 런타임 에러가 남  // 
		
		
		Scanner sc=  new Scanner(System.in);
		int t = sc.nextInt();
		for(int p =0; p<t; p++){
			int n = sc.nextInt();
			int grade[][] = new int[n][2];
			for(int k=0; k<n; k++){
			  grade[k][0] = sc.nextInt();//서류순위 
			  grade[k][1] = sc.nextInt();//면접순위
			}
			////////////////////////////////////////////////
			// 앞에 그러니까 서류가랭크별로 배열이되고 면접은 그대로 따라 정렬된다 .
		      Arrays.sort(grade, new Comparator<int[]>(){
	                @Override
	                public int compare(int[] o1, int[] o2) {
	                    return o1[0] - o2[0]; // [0]은 [0]에있는것이 정렬되고 [0]이 거기에 맞게 따라오고 
                     // return o1[1] - o2[1]; // [1]은 [1]에있는것이 정렬되고 [0]은 거기에 맞게 따라온다  	                                          
	                }
	            });
		    ////////////////////////////////////////////////  
	            int rank = grade[0][1]; // 0부터 면접 랭크비교  
	            int cnt = 1;
	            for(int i=1; i<n; i++){ //면접랭킹이 더 좋으면 cnt 증가 
	                if(grade[i][1] < rank){
	                    rank = grade[i][1];
	                    cnt++;
	                }
	            }	            
	            System.out.println(cnt);
		}
	}
}
