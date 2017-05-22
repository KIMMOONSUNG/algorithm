package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9461 { // 파도반 수열  
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	long d [] = new long[101];
    d[1] = 1;
    d[2] = 1;
    d[3] = 1;
	for(int t = 1; t <=testcase; t++){
		int ans = Integer.parseInt(bf.readLine());
	        for(int i=4; i<=ans; i++)
	        {
	            d[i] = d[i-2] + d[i-3]; 
	        }
	        System.out.println(d[ans]);
	}
 }
 
}
