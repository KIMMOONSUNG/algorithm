package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1182_2 {
	static int n;
	static int s;
	static int arr[];
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	s = Integer.parseInt(st.nextToken());
	arr = new int[n];
	st = new StringTokenizer(bf.readLine());
	for(int i =0; i<n; i++){
		arr[i] = Integer.parseInt(st.nextToken());
	}
	int result =0 ;
	for(int i =1; i<(1<<n); i++){
		int sum = 0;
		for(int k =0; k<n; k++){
			if((i&(1<<k))!=0){
				sum = sum+arr[k];
			}
		}
		if(sum == s){
			result++;
		}
	}
	System.out.println(result);
}
}
