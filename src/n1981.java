
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class node {
	int x, y;

	node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class n1981 {
	static int n;
	static int map[][];
	static int num[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int Min = 200;
	static int Max = 0;
	static int Ans = 300;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		for(int i =0; i<n; i++){
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for(int j =0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] <Min){
					Min = map[i][j] ;
				}
				if(map[i][j] >Max){
					Max = map[i][j];
				}
			}
		}
		
		int t = Min;
		int left , right , mid , pmid;

		for (t = Min; t < Max; t++) {
			//tMin일때 최소 tMax 값을 이분법으로 찾을때까지
			left = t;
			right = Max;
			mid = right ;
			while(right > left){
				num = new int[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (map[i][j] >= t && map[i][j] <= mid)
							num[i][j] = map[i][j];
						else
							num[i][j] = -1;
					}
				}
				if(func(0,0)==true){
					if(Ans > (mid - t))
						Ans = mid- t;
					
					right = mid;
				}
				else{
					left = mid;
				}

				pmid = mid;
				mid = (left + right) / 2;

				if (pmid == mid) 
					break;
				
			}	
		}
		System.out.println(Ans);

	}

	static boolean func(int a, int b) { //틀린메소드 
		boolean result = false;
		Queue<node> q = new LinkedList<>();
		q.offer(new node(a,b));
		while(!q.isEmpty()){
			node p = q.poll();
			if(p.x == n-1 && p.y == n-1){
				result = true;
				return true;
			}
		    for(int i =0; i<4; i++){
		    	int x = p.x+dx[i];
		    	int y = p.y+dy[i];
		    	if(x>=0 && y>=0 && x<n && y<n &&num[x][y]!=-1){
		    		num[x][y] = -1;
		    		q.offer(new node(x,y));
		    	}
		    	
		    }
		}
		if(result ==true){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static boolean chk(int x, int y) { // 맞는 메소
		boolean a, b, c, d;
		if (x < 0 || y < 0 || x > n-1 || y > n-1 || num[x][y] == -1)
			return false;
 
		if (x == n-1 && y == n-1)
			return true;
 
	    num[x][y] = -1;
		a = chk(x, y + 1);
		b = chk(x, y - 1);
		c = chk(x + 1, y);
		d = chk(x - 1, y);
 
		if (a || b || c || d){
			return true;
		}else{
			return false;
		}
 
	}
	
}
