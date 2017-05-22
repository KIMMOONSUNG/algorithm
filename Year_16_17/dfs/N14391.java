package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14391 {
	static int n;
	static int m;
	static int map[][];
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	for(int i =0; i<n; i++){
		String str=  bf.readLine();
		for(int j=0; j<m; j++){
			map[i][j] = str.charAt(j)-48;
		}
	}
	int result = 0;
	// 0 : - // 1 : | 
	// 0: -, 1 : |
    for (int s=0; s<(1<<(n*m)); s++) {
        int sum = 0;
        for (int i=0; i<n; i++) {
            int cur = 0;
            for (int j=0; j<m; j++) {
                int k = i*m+j;
                if ((s&(1<<k)) == 0) {
                    cur = cur * 10 + map[i][j];
                } else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        for (int j=0; j<m; j++) {
            int cur = 0;
            for (int i=0; i<n; i++) {
                int k = i*m+j;
                if ((s&(1<<k)) != 0) {
                    cur = cur * 10 + map[i][j];
                } else {
                    sum += cur;
                    cur = 0;
                }
            }
            sum += cur;
        }
        
        result = Math.max(result,sum);
    }
    
    System.out.println(result);
	
 }
 
}
