package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_11399 { // ATM -> 그리디알고리즘이용 
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	String str [] = bf.readLine().split(" ");
	int time[] = new int[n]; //인출하는데 걸리는 시간 인덱스는 사람번호라고생각 
	for(int i =0; i<n; i++){
	 time[i] = Integer.parseInt(str[i]);	 
	}
	/*
	//인출하는데 걸리는 시간이 적은 사람부터 정렬 해서 더해주면 끝.
	Arrays.sort(time);
	int time2 =0;
	int total =0;
	for(int i =0; i<n; i++){
	 	time2 += time[i]; // 1분 //3분 // 6분 // 9분 //13분
	 	total += time2;
	}
	System.out.println(total);
	*/
	//// 2번째 방법 그리디 ////
	int temp =0;
	for(int i =0; i<n-1; i++){  // bubblesort //
		for(int j=0; j<(n-1)-i; j++){
			if(time[j]>time[j+1]){
				temp = time[j];
				time[j] = time[j+1];
				time[j+1] = temp;
			}
		}
	}
	int total =0;
	
	for(int i =0; i<n; i++){
		for(int j=0; j<=i; j++){
			total += time[j]; 
		}
	}
	System.out.println(total);
	////////////////////
 }
}
