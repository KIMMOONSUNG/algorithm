package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2644 { // 촌수계산문제 재귀호출 로 
	static boolean map[][];
    static boolean visit[];
    static int n;
    static int k;
    static int man1;
    static int man2;
    static boolean ans ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
	    StringTokenizer st = new StringTokenizer(bf.readLine());
	    man1 = Integer.parseInt(st.nextToken());
	    man2 = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(bf.readLine());
	    map = new boolean[n+1][n+1];
	    visit = new boolean[n+1];
	    
	    for(int i =0; i<k; i++){
	       st = new StringTokenizer(bf.readLine());
	       int x = Integer.parseInt(st.nextToken());
	       int y = Integer.parseInt(st.nextToken());
	       map[x][y] = true;
	       map[y][x] = true;
	    }
	    func(man1,0);
	    
	    if(ans == false){
	    	System.out.println(-1);
	    }
	}
	
	static void func(int num, int cnt) {
		if(num==man2){
			System.out.println(cnt);
			ans = true;
			return;
		}
		for(int i =1; i<=n; i++){
			if(map[i][num]==true && visit[i] == false){
				visit[i]= true;
				func(i,cnt+1);
			}
		}
	}


	}

