package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11047 {
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" ");
	int n = Integer.parseInt(str[0]); // 동전종류개수
	int k = Integer.parseInt(str[1]); // 가격 
	int coin[] = new int [n];
	for(int i =n-1; i>=0; i--){ // 동전을 큰거부터 coin에 넣고 
		coin[i] = Integer.parseInt(bf.readLine());
	}
	int count =0; //동전개수 샐것
	
	for(int i =0; i<n; i++){// 제일 큰 동전부터 비교  
	 if(coin[i]<=k){ // 동전이 가격보다 적거나 같은수중 첫번째 
		 while(coin[i]<=k){ // 그 동전을 계속비교  
		  k = k-coin[i];
		  count++; // 개수 증가 
		 }
	 }
	 if(k == 0){ // 가격이 0 원되면 종료 
		 break;
	 }
	}
	System.out.println(count);
}
}
