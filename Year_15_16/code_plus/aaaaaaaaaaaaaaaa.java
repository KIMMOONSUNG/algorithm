package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aaaaaaaaaaaaaaaa {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(bf.readLine());
        int mod = 10007;
        int d[][] = new int[n+1][10];
        for(int i =0; i<=9; i++){
        	d[1][i] = 1;
        }
        for(int i =2; i<=n; i++){
        	for(int j =0; j<=9; j++){
        		for(int k=0; k<=j; k++){
        		  d[i][j] = d[i][j]+d[i-1][k];
        		  d[i][j]%=mod;
        		}
        	}
        }
        int result=0;
        for(int i =0; i<=9 ; i++){
        	result += d[n][i];
        }
        result %= mod;
        System.out.println(result);
	}
}
