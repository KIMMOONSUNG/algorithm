package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_2629 { // 양팔저울  / /실패  
	static int n;
	static int map[];
	static int m;
	static int map2[];
	static boolean result =false;
	static boolean arr[];
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map = new int[n];
	StringTokenizer st = new StringTokenizer(bf.readLine());
	for(int i =0; i<n; i++){
		map[i] = Integer.parseInt(st.nextToken());
	}
	Arrays.sort(map);
	m = Integer.parseInt(bf.readLine());
	map2 = new int[m];
	st = new StringTokenizer(bf.readLine().trim());
	for(int i =0; i<m; i++){
		map2[i] = Integer.parseInt(st.nextToken());
	}
    arr =  new boolean[m];
	func(n-1);
	StringBuilder sb = new StringBuilder();
	for(int i =0; i<arr.length; i++){
		if(arr[i] ==true){
			sb.append("Y"+" ");
		}
		else{
			sb.append("N"+" ");
		}
	}
	System.out.println(sb.toString());
}
 
 static void func(int index){
	 if(index <0){
		 return ;
	 }
	
	 for(int i =0; i<n; i++){
		 if(index <= i){
			 continue;
		 }
		 
		 for(int j=0; j<m; j++){
			if( (map[index]==map2[j]) || (map[index]-map[i])==map2[j] || (map[index]+map[i])==map2[j]){
			  	arr[j] = true;
			  	
			}
		 }
		 
	 }
	 
	 func(index-1);
 }
 
 
}
