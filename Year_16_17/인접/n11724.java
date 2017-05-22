package 인접;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11724 { // 인접행렬 
	static int n;
	static int m;
	static boolean map[][];
	static boolean visit[];
 public static void main(String[] args) throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st= new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 map = new boolean[n+1][n+1];
	 visit = new boolean[n+1];
	 for(int i =1; i<=m; i++){
		 st = new StringTokenizer(bf.readLine());
		 int a=  Integer.parseInt(st.nextToken());
		 int b = Integer.parseInt(st.nextToken());
		 map[a][b] = true;
		 map[b][a] = true;
	 }
	 int count=0;
	 for(int i =1 ; i<=n; i++){
		 if(visit[i] ==false){
			 visit[i] = true;
			 count++;
			 dfs(i);
		 }
	 }
	 System.out.println(count);
 }
 static void dfs(int num){
	 visit[num] = true;
	 for(int i=1; i<=n; i++){
		 if(map[num][i] == true && visit[i] == false){
			 dfs(i);
		 }
	 }
 }
}
