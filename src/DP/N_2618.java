package DP;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class a123{
	int x;
	int y;
	int cnt;
}
public class N_2618{
	static int n;
	static int help;
	static int car[];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int nowx ;
	static int nowy ;
	static int nowx2 ;
	static int nowy2 ;
	static int result=0;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		help = sc.nextInt();		 
	  	car = new int[help];
	  	nowx = 1;
	  	nowy = 1;
	  	nowx2 = n;
	  	nowy2 = n;
	  	int xx =0;
	  	int yy =0;
	  	result =0;
	  	StringBuilder sb = new StringBuilder();
	  	for(int i =0; i<help; i++){
	  		boolean visited[][] = new boolean[n+1][n+1];
	  		xx =sc.nextInt();
	  		yy =sc.nextInt();
	  		Queue<a123> q = new LinkedList<a123>();
	  		a123 p = new a123();
	  		p.x = xx;
	  		p.y = yy;
	  		p.cnt= 0;
	  		q.offer(p);
	  		while(!q.isEmpty()){
	  			p = q.poll();
	  			if(p.x == nowx && p.y == nowy){
	  				result +=p.cnt;
	  				nowx = xx;
	  				nowy = yy;
	  				sb.append("1");
	  				sb.append("\n");
	  				break;
	  			}
	  			if(p.x == nowx2 && p.y == nowy2){
	  				result +=p.cnt;
	  				nowx2 = xx;
	  				nowy2 = yy;
	  				sb.append("2");
	  				sb.append("\n");
	  				break;
	  			}
	  			for(int a =0; a<4; a++){
	  				int x = p.x + dx[a];
	  				int y = p.y + dy[a];
	  				int cnt = p.cnt + 1;
	  				if(x>0 && y>0 && x<=n && y<=n && visited[x][y] == false){
	  					visited[x][y] = true;
	  					a123 p2 = new a123();
	  					p2.x =x;
	  					p2.y =y;
	  					p2.cnt = cnt;
	  					q.offer(p2);
	  				}
	  			}
	  		}

	  	}
	  	System.out.println(result);
  		System.out.println(sb);
	 }	
	}