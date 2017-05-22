package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1261_2 { // 알고스팟 - dfs 
	                     //stack은배열로 
	static int n ;
	static int m;
	static int map[][];
	static int num[][];
	static int sx[];
	static int sy[];
	static int index;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		m = Integer.valueOf(str[0]);
		n = Integer.valueOf(str[1]);
		map = new int[n][m];
		num = new int[n][m];
		sx = new int[10001];
		sy = new int[10001];
		index =0; 
		for (int i = 0; i < n; i++) {
			char ch[] = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = ch[j] - 48;
				num[i][j] = 10001;
			}
		}
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		st(0,0);
		index = 1; //1로시작해야 처음 pop에서  --해서 0 부터 pop
	    num[0][0] = 0;
	    
	    while(true){
	    	if(n==1 && m==1){ // 1*1 인경우 막고 
				if(map[0][0]==1){
				 num[0][0] = 1;	
				}
				else{
				 num[0][0] =0;
				}
				break;
			}
	    	
	    	// pop
	    	index--;
	    	int xx = sx[index];
	    	int yy = sy[index];
	    
	    	for(int i =0; i<4; i++){
	    		int x = xx+dx[i];
	    		int y = yy+dy[i];
	    		if(x>=0 && y>=0 && x<n && y<m ){
	    			if(num[x][y]>num[xx][yy]+map[x][y]){
	    				num[x][y] = num[xx][yy] + map[x][y];
	    			st(x,y);
	    			index++;
	    			}
	    		}
	    	}
	    	
	    	if(index==0){
	    		break;
	    	}
	    	
	    	
	    }
	    System.out.println(num[n-1][m-1]);
	}
	static void st(int a, int b){
		sx[index] = a;
		sy[index] = b;
	}
}
