package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_2846 {
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n =Integer.parseInt(bf.readLine());
	int d[] = new int[n];
	StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	for(int i =0; i<n; i++){
	  d[i] = Integer.parseInt(st.nextToken());	
	}
	int start = d[0];
	int end =0;
	int result =-1;
	for(int i =1; i<n; i++){
		if(d[i-1]<d[i]){			
			end = d[i];
			if(i==n-1){ //마지막 두수가 오르막길인경우도추가  
				if(result<(end-start)){
					result = end - start;
					}
			}
		}
		else if(d[i-1]>=d[i]){
			if(result<(end-start)){
				result = end - start;
				}
			start=d[i];
		}
	}
	if(result == -1){
		System.out.println(0);
	}
	else{
	    System.out.println(result);
	}
  }
 }
