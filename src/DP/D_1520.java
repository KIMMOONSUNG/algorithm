package DP;

import java.util.Scanner;

public class D_1520 { // 재귀 문제에 가깝다  내리막길 -> 재귀호출
    static int dx[] = { 0, 0, 1, -1 };
    static int dy[] = { 1, -1, 0, 0 };
    static int N,M;
    static int[][] a;
    static int[][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        a = new int[N][M];
        d = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(func(0, 0));
    }
    private static int func(int x, int y) {
        if (x == N - 1 && y == M - 1){ //시작지점이 마지막전이면  그니까 밑에 dfs(nx,ny)에서 
        	                          //호출한nx , ny 값이 길에 끝이면 길 +1 추가 
        	                          //그래서 밑에 1이 더해져 d[x][y]에넣어짐 
            return 1;                   // 길이 하나씩 추가된다고 생각하면 된다.
        }
        if (d[x][y] == 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < N && ny < M && nx >= 0 && ny >= 0 && a[nx][ny] < a[x][y]){
                
                    d[x][y] += func(nx, ny);
                }
            }
        }
        return d[x][y];
    }
}