package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class n_1325{
	int one,num, cnt;
	n_1325(int one ,int num, int cnt){
		this.one = one;
		this.num = num;
		this.cnt = cnt;
	}
}
public class N1325 { // 실패

 public static void main(String[] args) throws IOException{
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(bf.readLine().trim());
  int n = Integer.parseInt(st.nextToken()); //컴퓨터의 수  
  int m = Integer.parseInt(st.nextToken());  // 조건의 수 
  
  boolean map[][] = new boolean[n+1][n+1];
  boolean visit [] = new boolean[n+1];
  int number[] = new int [n+1];
  Arrays.fill(number, 9999999);
  
  for(int i =0; i<m; i++){
	  st = new StringTokenizer(bf.readLine());
	  int x = Integer.parseInt(st.nextToken());
	  int y = Integer.parseInt(st.nextToken());
	  number[y] = 1;
	  map[x][y] = true;
	  map[y][x] = true;
  }
   number[0]= -1;
   Arrays.sort(number);
   
  
   int c =0;
   int result [] = new int[n+1];
   Arrays.fill(result, 9999999);
  for(int a =1; a<number.length; a++){
	  
	  Queue<n_1325> q = new LinkedList<n_1325>();
	  visit = new boolean [n+1];
	  q.offer(new n_1325(a,a,0));
	  visit[a] = true;
	  
	  int k = 0;
	  int now =0 ;
	  while(!q.isEmpty()){
		  n_1325 p = q.poll();
		 
		  for(int i =1; i<number.length; i++){
			  if(visit[i] == false && map[p.num][i]==true){
				  visit[i] = true;
				  q.offer(new n_1325(a,i,p.cnt+1));
				  k= p.cnt+1;
			  }
		  }
		  
	   }
	  int t=1;
	  if(k>now){
		  result[t] = a;
		  
	  }
	  else if(k==now){
		  result[t] = a;
		  t++;
	  }
	  

  }
  
  Arrays.sort(result);
  for(int i =0; result[i]!=9999999; i++){
	  System.out.print(result[i]+" ");
  }
  
 }

}
