package SCPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class example{
 public static void main(String[] args) throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int t = Integer.parseInt(bf.readLine());
	 int Case =1;
	 for(int a= 0; a<t; a++){
		 int num = Integer.parseInt(bf.readLine());
		 String str[] = bf.readLine().split(" ");
		 int n [] = new int[num+1];
		 for(int i =0; i<num; i++){
		 	 n[i+1] = Integer.parseInt(str[i]);
		 }
		 int count =0;
		 int k = Integer.parseInt(bf.readLine());// 최대점프거리 
		 int cur = n[0]; // 개구리 처음 있는 칸
		 for(int i =1 ; i<=num; i++){
			if(n[i]-n[i-1] > k){ //간격이 최대점프거리보다 크면 -1로해주고 끝
				count= -1; 
				break;
			}
			if(cur + k < n[i]){  
				cur = n[i-1];
				count +=1;
			}
		 }
		 if(count!=-1){
			 count +=1;
		 }
		 System.out.println("Case #" + Case);
		 System.out.println(count);
		 Case++;
	 }
 }
}
