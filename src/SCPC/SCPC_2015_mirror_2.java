package SCPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SCPC_2015_mirror_2 { // 방속의 거울 bufferdReader로 품 
	static int dx[] = {0,0,1,-1}; //오 ,왼,아래 ,위
	static int dy[] = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		
		for (int a = 0; a < t; a++) {
			int n = Integer.parseInt(bf.readLine());
			int map[][] = new int[n][n];
			boolean visit[][] = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				char[] ch = bf.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = (ch[j]-48);
				}
			}
			int dir = 0;
			int x =0;
			int y =0;
			while(x>=0 && y>=0 && x<n && y<n ){
			  if(map[x][y]!=0){
                visit[x][y] = true;
                dir = ms(dir,map[x][y]);
			  }
			  x = x+dx[dir];
			  y = y+dy[dir];
			}
			int count =0;
			for(int i =0; i<n; i++){
				for(int j=0; j<n; j++){
					if(visit[i][j]==true){
						count +=1;
					}
				}
			}
			System.out.println("Case #"+(a+1));
			System.out.println(count);
		}

	}
	static int ms(int d, int mirror){ // dir방향이 정해져서 나감 
		if(mirror == 1){ // 1일때 
			return (3-d);
		}
		else {           // 2일때 
			return (d+2)%4; 
		}
	}
}
