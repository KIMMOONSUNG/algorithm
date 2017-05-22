package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1182 { // 부분집합의 합 
	static int n ;
	static int s;
	static int arr[];
	static int count;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	s = Integer.parseInt(st.nextToken());
	arr= new int[n];
	st = new StringTokenizer(bf.readLine());
    for(int i =0; i<n; i++){
    	arr[i] = Integer.parseInt(st.nextToken()); 
    }
    func(0,0);
    if(s==0){
    	count--;
    }
    System.out.println(count);
 }
 
 static void func(int index, int num){
	 if(index>=n){
	  if(num==s){
		 count++;
	  }
	  return;
	 }
	 
	 func(index+1, num);
	 func(index+1,num+arr[index]);	 
	 
 }
 
}
