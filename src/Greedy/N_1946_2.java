package Greedy;

import java.util.Scanner;

public class N_1946_2 {
	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt(); //테스트케이스
	        for (int i = 0; i < t; i++) {
	            int cnt = 1;
	            int index;
	            int min;
	            int m = sc.nextInt(); //지원자의 수 
	            int rank[] = new int[m+1];

	            for (int j = 1; j <=m; j++) {
	                index = sc.nextInt(); // ★★★서류 심사성적 -> 순차적으로 하는거 ★ 
	                rank[index] = sc.nextInt(); //면접 심사성적
	            }
	            min = rank[1]; // 처음 1부터 시작 
	            
	            for (int j = 2; j <= m; j++){
	                if (rank[j]<min) { // 비교했는데 면접심사성적순위가 더 좋다면 
	                    cnt++; 
	                    min = rank[j];
	                }
	            }
	            System.out.println(cnt);
	        }
	    }
}