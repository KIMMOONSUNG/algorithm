package DP;

import java.util.Scanner;
///////// 도착지에서의 그 전상황을  파악 어디서왔는지를 파악해 그거중에 최대값을 구함 ★★★★
public class D_11048 {
	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int x = sc.nextInt();
	   int y = sc.nextInt();
	   int a[][] = new int [x+1][y+1];
	   int d[][] = new int [x+1][y+1];
	   for(int i =1; i<=x; i++){
		   for(int j=1; j<=y; j++){
	         a[i][j] = sc.nextInt();   		   
		   }
	     }
	   sc.close();
	    for(int i =1; i<=x; i++){
	    	for(int j =1; j<=y; j++){
	    		d[i][j] = d[i][j-1]; //왼쪽에서 온것
	    		if(d[i][j]<d[i-1][j]){ // 위쪽에서 온것이 더 큰경우 
	    			d[i][j] = d[i-1][j] ;
	    		}
	    		d[i][j]+=a[i][j];
	    	}
	    }
	    System.out.println(d[x][y]);
	   }
	 }


