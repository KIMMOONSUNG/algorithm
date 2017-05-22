package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n2618 {
	    static int n, m, p1, p2, tp1, tp2;
	    static int[][] Py, Px, dp;
	    static int[][][] Car;
	    
	    public static void main(String args[]) throws IOException{
		     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	       m = Integer.parseInt(bf.readLine());
	       n = Integer.parseInt(bf.readLine());
	       Py = new int[2][n+1];
	       Px = new int[2][n+1];
	       dp = new int[n+1][n+1];
	       Car = new int[n+1][n+1][2];
	       Arrays.fill(dp[0], -1);
	       Py[0][0] = Px[0][0] = 1;
	       Py[1][0] = Px[1][0] = m;
	       StringTokenizer st ;
	       for(int i = 1; i <= n; i++){
	    	   st = new StringTokenizer(bf.readLine());
	          Py[0][i] = Py[1][i] = Integer.parseInt(st.nextToken());
	          Px[0][i] = Px[1][i] = Integer.parseInt(st.nextToken());
	          Arrays.fill(dp[i], -1);
	       }
	       System.out.println((sol(0, 0)));
	       p1 = p2 = 0;
	       while((p1 < n && p2 < n)){
	          tp1 = Car[p1][p2][0];
	          tp2 = Car[p1][p2][1];
	          if(tp1 < tp2) System.out.println(("2"));
	          else System.out.println(("1"));
	          p1 = tp1;
	         p2 = tp2;
	       }
	    }
	    
	    static int sol(int c1, int c2){
	       if(c1 >= n || c2 >= n) return 0;
	       if(dp[c1][c2] == -1){
	          if(c1 > c2){
	             int d1 = dis(0, c1, c1+1)+sol(c1+1, c2);
	             int d2 = dis(1, c2, c1+1)+sol(c1, c1+1);
	             if(d1 > d2){
	                dp[c1][c2] = d2;
	                Car[c1][c2][0] = c1;
	                Car[c1][c2][1] = c1+1;
	             }else{
	                dp[c1][c2] = d1;
	                Car[c1][c2][0] = c1+1;
	                Car[c1][c2][1] = c2;
	             }
	          }else{
	             int d1 = dis(0, c1, c2+1)+sol(c2+1, c2);
	             int d2 = dis(1, c2, c2+1)+sol(c1, c2+1);
	             if(d1 > d2){
	                dp[c1][c2] = d2;
	                Car[c1][c2][0] = c1;
	                Car[c1][c2][1] = c2+1;
	             }else{
	                dp[c1][c2] = d1;
	                Car[c1][c2][0] = c2+1;
	                Car[c1][c2][1] = c2;
	             }
	          }
	       }
	       return dp[c1][c2];
	    }
	    
	    static int dis(int c, int P, int N){
	       return Math.abs(Py[c][N]-Py[c][P])+Math.abs(Px[c][N]-Px[c][P]);
	    }
	
	
}
