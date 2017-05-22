package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class aaaaa {
	static int n;
	static int num[];
 public static void main(String[] args) throws IOException{
	 BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	  n = Integer.parseInt(bf.readLine());
	  StringTokenizer st = new StringTokenizer(bf.readLine());
	  num = new int[n];
	  for(int i =0; i<n; i++){
		  num[i] = Integer.parseInt(st.nextToken());
	  }
	  Arrays.sort(num);
	  int m = Integer.parseInt(bf.readLine());
	  st = new StringTokenizer(bf.readLine());
	  StringBuilder sb = new StringBuilder();
	  for(int i =0; i<m; i++){
		  int number = Integer.parseInt(st.nextToken());
		  boolean result = binary(number);
		  if(result==true){
			  sb.append("1 ");
		  }
		  else {
			  sb.append("0 ");
		  }
	  }
	  System.out.println(sb);
}	
 static boolean binary(int goal){
	 int n = num.length;
	 int left = 0;
	 int right = n-1;
	 while(left<=right){
		 int mid = left +(right-left)/2;
		 if(num[mid]==goal){
			 return true;
		 }
		 else if(num[mid]>goal){
			 right = mid-1;
		 }
		 else{
			 left = mid+1;
		 }
	 }
	 return false;
 }
	
}
