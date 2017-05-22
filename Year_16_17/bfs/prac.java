package bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class pr{
	int x,y,len,cnt;
	pr(int x, int y, int len , int cnt){
		this.x =x ;
		this.y = y;
		this.len = len;
		this.cnt = cnt;
		
	}
}
public class prac {
	static int n;
	static int m;
	static int k;
	static int map[][];
	static boolean visit[][][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(bf.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    map = new int[n][m];
	    visit=  new boolean[n][m][k+1];
	    for(int i =0; i<n; i++){
	    	String str=  bf.readLine();
	    	for(int j =0; j<m; j++){
	    		map[i][j] = str.charAt(j)-48;
	    	}
	    }
	    Queue<pr> q=  new LinkedList<>();
	    q.offer(new pr(0,0,1,0));
        boolean result = false;
	    while(!q.isEmpty()){
	    	pr p = q.poll();
	    	if(p.x==n-1 && p.y==m-1){
	    		System.out.println(p.len);
                result = true;
	    		break;
	    	}
	    	for(int i=0; i<4; i++){
	    		int x = p.x+dx[i];
	    		int y = p.y+dy[i];
	    		int cnt = p.cnt;
	    		int len = p.len;
	    		if(x>=0 && y>=0 && x<n && y<m && (map[x][y]==0 || cnt<k && map[x][y]==1 )){ // **
	    			if(visit[x][y][cnt]==false){
	    			visit[x][y][cnt]= true;
	    			if(map[x][y]==1){
	    			  q.offer(new pr(x,y,len+1,cnt+1));
	    			}
	    			else if(map[x][y]==0){
	    				q.offer(new pr(x,y,len+1,cnt));
	    			}
	    		  }
	    		}
	    	}
	    }
        if(result==false){
            System.out.println(-1);
        }
	    
	}
}