package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n2748 { //피보나치수 2 
	static long d[] ; 
 public static void main(String[] args) throws IOException{
	 BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(bf.readLine());
	 d = new long[n+1];
     if(n==0){
    	 System.out.println(0);
     }
     else if (n==1){
    	 System.out.println(1);
     }
     else{
	 d[1] = 1;
	 d[2] = 1;
	 System.out.println(dp(n));
     }
 }
 static long dp(int n){
	 for(int i =2; i<=n; i++){
		d[i] =  d[i-1] + d[i-2];
	 }
	 return d[n-1] + d[n-2];
 }
 
}
