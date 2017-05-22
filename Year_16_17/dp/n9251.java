package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 // twinw.tistory.com/126

public class n9251 { // LCS 
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String a = bf.readLine();
	String b=  bf.readLine();
	int dp[][] = new int[1001][1001];
	int lena = a.length();
	int lenb = b.length();
	for(int i =0; i<lena; i++){
		for(int j =0; j<lenb; j++){
			if(a.charAt(i) == b.charAt(j)){
				dp[i+1][j+1] = dp[i][j] +1;
			}
			else{
				dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}
	}
	System.out.println(dp[lena][lenb]);
 }
}
