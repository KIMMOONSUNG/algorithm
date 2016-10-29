package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_2294 { //동전 2
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	int total = Integer.parseInt(st.nextToken());
	int coin[] = new int[n+1];
	int d[] = new int[total+1];
	for(int i =1; i<=n; i++){
		coin[i] = Integer.parseInt(bf.readLine());
	}
	for(int j=1; j<=total; j++){
		d[j] = 10001;
	}
	
	for(int i=1; i<=n; i++){
		for(int j=coin[i]; j<=total; j++){
			d[j] = Math.min(d[j], d[j-coin[i]]+1);
		}
	}
	if(d[total]==10001){
		d[total] = -1;
	}
	System.out.println(d[total]);
	
}
}
