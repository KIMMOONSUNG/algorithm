package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class n_1987_2{
	int x;
	int y;
	int length;
	String str ="";
}
public class N_1987 {
	 public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String map[][] = new String[n][m];
			for(int i =0; i<n; i++){
				String str= bf.readLine();
				for(int j=0; j<m; j++){
					map[i][j] = String.valueOf(str.charAt(j));
				}
			}
			int result=0;
			Stack<n_1987_2> s = new Stack<n_1987_2>();
			n_1987_2 p = new n_1987_2();
			p.x = 0;
			p.y =0;
			p.length =1;
			p.str =map[0][0];
			int dx[] = {0,0,1,-1};
			int dy[] = {1,-1,0,0};
			s.add(p);
			while(!s.isEmpty()){
				p = s.pop();
				for(int i =0;i<4; i++){
					int x = p.x +dx[i];
					int y = p.y +dy[i];
					int count =p.length;
					String str= p.str;
					if(x>=0 && y>=0 && x<n && y<m){
						n_1987_2 p2 = new n_1987_2();
						p2.x= x;
						p2.y=y;
						if(!str.contains(map[x][y])){
							p2.str=str+map[x][y];
							p2.length = count+1;
							s.add(p2);
						}
						else{ // 다를때 결과 비교 
							result = Math.max(count, result);
						}						
					}
				}
			}
			System.out.println(result);
		}
}

