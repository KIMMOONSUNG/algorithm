package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class N_1726 {
 
    private static int maxY, maxX;
 
    private static int[][] map;
 
    private static boolean[][][] visited;
 
    static final int[] dy = { 0, 0, 0, 1, -1 };
    static final int[] dx = { 0, 1, -1, 0, 0 };
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        maxY = sc.nextInt();
        maxX = sc.nextInt();
 
        map = new int[maxY][maxX];
        visited = new boolean[maxY][maxX][5];
 
        for (int i = 0; i < maxY; i++) {
 
            for (int j = 0; j < maxX; j++) {
 
                map[i][j] = sc.nextInt();
            }
        }
 
        int startY = sc.nextInt()-1;
        int startX = sc.nextInt()-1;
        int startDir = sc.nextInt();
        int destY = sc.nextInt()-1;
        int destX = sc.nextInt()-1;
        int destDir = sc.nextInt();
 
        System.out.println(move(startY, startX, startDir, destY, destX, destDir));
        
    }
 
    private static int move(int startY, int startX, int startDir, int destY, int destX, int destDir) {
 
        Queue<Point> q = new LinkedList<>();
 
        q.add(new Point(startY, startX, startDir, 0));
 
        visited[startY][startX][startDir] = true;
 
        while (!q.isEmpty()) {
 
            int hereY = q.peek().y;
            int hereX = q.peek().x;
            int hereDir = q.peek().dir;
            int count = q.remove().count;
 
            if (hereY == destY && hereX == destX && hereDir == destDir)
                return count;
 
 
            // 직진 1~3
            for (int j = 1; j <= 3; j++) {
                 
                int nextY = hereY + dy[hereDir] * j;
                int nextX = hereX + dx[hereDir] * j;
                 
                if (!check(nextY, nextX))   break;
                if (visited[nextY][nextX][hereDir]) continue;
                visited[nextY][nextX][hereDir] = true;
                q.add(new Point(nextY, nextX, hereDir, count+1));
            }
 
            // 회전
            for (int j = 1; j <= 4; j++) {
 
                if (j == reverse(hereDir))  continue;
                if (j == hereDir)   continue;
                if (visited[hereY][hereX][j])   continue;
                 
                visited[hereY][hereX][j] = true;
                q.add(new Point(hereY, hereX, j, count + 1));                
            }
 
        }
        return -1;
    }
 
    private static boolean check(int y, int x) {
        if (y < maxY && y >= 0 && x < maxX && x >= 0 && map[y][x] != 1) {
            return true;
        }
        return false;
    }
 
    private static int reverse(int dir){
 
        if (dir == 1)   return 2;
        if (dir == 2)   return 1;
        if (dir == 3)   return 4;
        if (dir == 4)   return 3;
 
        return -1;
    }
 
    private static class Point {
        public int y, x, dir, count;
 
        public Point(int y, int x, int dir, int count) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.count = count;
        }
    }
}