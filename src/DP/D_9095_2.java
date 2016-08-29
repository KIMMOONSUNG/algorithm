package DP;

import java.util.Scanner;

public class D_9095_2 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Testc = sc.nextInt();
		int d[] = new int[11]; //11까지 
		d[0]=1; 
		d[1]=1;// 1은 1하나뿐 그래서 1번
		d[2]=2; // 2는 2와 1+1 그래서 2번
		for(int i =1; i<=Testc; i++){ // Testc만큼 돌림
			int n = sc.nextInt();
			for(int j = 3; j<=n; j++){ 
				d[j] = d[j-1]+d[j-2]+d[j-3]; 
			}
			System.out.println(d[n]);
		}
	}
}
