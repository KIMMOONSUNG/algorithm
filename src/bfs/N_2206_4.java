package bfs;

import java.util.Scanner;

class N22{
	int x;
	int y;
	int cnt;
	int len;
}

public class N_2206_4 {
	static int qx[];
	static int qy[];
	static int len[];
	static int cnt[];
	static int index;
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m =sc.nextInt();
	int map[][] = new int[n][m];
	boolean visit[][][] = new boolean[n][m][2];
	for(int i =0; i<n; i++){
		String str= sc.next();
		for(int j=0; j<m; j++){
			map[i][j] = str.charAt(j)-48;
		}
	}
	qx = new int[101];
	qy = new int[101];
	len=new int[101];
	cnt=new int[101];
	index =0;
	N22 s = new N22();
	s.x = 0;
	s.y = 0;
	s.len =1;
	s.cnt =0;
	qu(s);
	
	int index2 =0;
	int dx[] = {0,0,1,-1};
	int dy[] = {1,-1,0,0};
	while(true){
		s.x = qx[index2];
		s.y = qy[index2];
		s.len = len[index2];
		s.cnt = cnt[index2];

		if(s.x==n-1 && s.y==m-1){
			System.out.println(s.len);
			break;
		}
		for(int i =0; i<4; i++){
			int x = s.x +dx[i];
			int y = s.y +dy[i];
			int cnt = s.cnt ;
			int len = s.len+1;
			if(x>=0 && y>=0 && x<n && y<m && visit[x][y][cnt]==false
					&& (map[x][y]==0 || (map[x][y]==1 && cnt==0))){
				visit[x][y][cnt] =true;
				N22 s2 = new N22();
				s2.x = x;
				s2.y =y;
				s2.len = len;
				if(map[x][y]==1){
				  s2.cnt = cnt+1;
				}
				else{
					s2.cnt = cnt;
				}
				qu(s2);
				
			}
		}
		index2++;
		if(index2>100){
			index2= 0;
		}

	}

	
 }
  static void qu(N22 p){
	  if(index >100){
		  index =0;
	  }
	  qx[index] = p.x;
	  qy[index] = p.y;
	  len[index] =p.len;
	  cnt[index] =p.cnt;
	  index++;
  }
}
