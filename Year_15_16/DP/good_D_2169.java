package DP;

import java.util.Scanner;

public class good_D_2169 {
	//가치의합이 최대가되는경우 -> DP
	
	// 왼쪽에서오는것과 위쪽에서 오는것 중 큰값과  오른쪽에서오는것과 위에서오는것중 큰값 중 더 큰값을 max넣고 저장. 
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			int number[][] = new int[2][m]; // 위에서오는값과 왼에서오는값중 큰값저장vs 위에서오는값과 오에서오는값중 큰값 저장.
			int arr[][] = new int[n ][m ]; // 기본 배열
			int max[][] = new int[n ][m ]; // MAX값넣을 배열
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			max[0][0] = arr[0][0];
			for (int i = 1; i < m; i++) { //가장위에줄 채움 
			  max[0][i] = max[0][i - 1] + arr[0][i];
			}
			       
			for (int i = 1; i < n; i++) {
				
				for(int j=0; j<m; j++){ //위에서오는경우
					  number[1][j] = max[i-1][j]+arr[i][j]; 
		              number[0][j] = max[i-1][j]+arr[i][j];
				}
				
				for (int j = 1; j < m; j++) { //왼쪽에서오는경우  //기존 위에값과 왼쪽에서온값 중 큰값을 number에 저장
					number[0][j] = Math.max(number[0][j], number[0][j-1] + arr[i][j]); 
				}
				for (int j = m-2; j >=0; j--) { //오른쪽에서 오는경우 // 기존 위에값과 오른쪽에서 온값 중 큰값을 number에저장
					number[1][j] = Math.max(number[1][j], number[1][j + 1] + arr[i][j]);
				}
				for (int j = 0; j < m; j++) { // 두값 중 큰수 
					max[i][j] = Math.max(number[0][j], number[1][j]);
				}
				
			}
			
			System.out.println(max[n-1][m-1]);
		}
}
