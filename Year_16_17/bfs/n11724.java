package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_11724{
	int num;
	n_11724(int num){
		this.num = num;
	}
	
}
public class n11724 { // 연결요소의 개수 -> 촌수계산 과 비슷 
	
	static boolean map[][];
	static boolean visit[];
	static int n;
	
 public static void main(String[] args) throws IOException {
	 
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	map = new boolean [n+1][n+1];
	visit = new boolean [n+1];
	
	for(int i =1; i<=m; i++){
	 st = new StringTokenizer(bf.readLine());
	 int x = Integer.parseInt(st.nextToken());
	 int y = Integer.parseInt(st.nextToken());
	 map[x][y] = true;
	 map[y][x] = true;
	}
	int count =0;
	for(int i =1; i<=n; i++){
		if(visit[i] == false){
		   func(i);
		   count++;
		}	
	}
	System.out.println(count);
 }
 
 static void func(int start){
	 
    Queue<n_11724> q=  new LinkedList<>();
    q.offer(new n_11724(start));
    visit[start] = true;
    while(!q.isEmpty()){
    	n_11724 p = q.poll();
    	for(int i =1; i<=n; i++){
    		if(visit[i]==false && map[p.num ][i]==true){
    	
    		  visit[i] = true;
    		  q.offer(new n_11724(i));
    		}
    	}
    }
    
 }
 
}
