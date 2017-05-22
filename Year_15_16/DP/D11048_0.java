package DP;

import java.util.Scanner;

public class D11048_0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	    int m = sc.nextInt();
	    int miro[][] = new int[n+1][m+1];
	    int d[][] = new int[n+1][m+1];
	    for(int i =1; i<=n; i++){
	    	for (int j=1; j<=m; j++){
	    		miro[i][j] = sc.nextInt();
	    	}
	    }
	    for(int i=1; i<=n; i++){
	    	for(int j=1; j<=m; j++){
	    		d[i][j] = d[i][j-1]+miro[i][j]; //왼쪽에서 온것 + 현재 사탕개수
	    		if(d[i][j]<d[i-1][j]+miro[i][j]){ // 위쪽에서 온것+현재 더 큰경우 
	    			d[i][j] = d[i-1][j]+miro[i][j] ;
	    		}
	    	}
	    }
	    System.out.println(d[n][m]);
	}
}