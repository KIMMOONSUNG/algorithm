package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class N_1726 {
 
    private static int maxX, maxY;
    private static int[][] map;
    private static boolean[][][] visited;
     
    // dir 1 , 2, 3 , 4 -> 동 , 서, 남 , 북
    static final int[] dx = { 0, 0, 0, 1, -1 };
    static final int[] dy = { 0, 1, -1, 0, 0 };
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxX = sc.nextInt();
        maxY = sc.nextInt();
        map = new int[maxX][maxY];
        visited = new boolean[maxX][maxY][5];
 
        for (int i = 0; i < maxX; i++) {
            for (int j = 0; j < maxY; j++) {
                map[i][j] = sc.nextInt();
            }
        }
  
        //(1,1)이아닌 (0,0)으로해주기위해 -1 한거임  //
        int startX = sc.nextInt()-1;
        int startY = sc.nextInt()-1;
        int startDir = sc.nextInt();
        int destX = sc.nextInt()-1;
        int destY = sc.nextInt()-1;
        int destDir = sc.nextInt();
 
        System.out.println(move(startX, startY, startDir, destX, destY, destDir));
        
    }
 
     static int move(int startX, int startY, int startDir, int destX, int destY, int destDir) {
 
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(startX, startY, startDir, 0));
        visited[startX][startY][startDir] = true; // 첫 시작과 방향은 TRUE
 
        while (!q.isEmpty()) {
            Point p = q.poll();
            int hereX = p.x;
            int hereY = p.y;
            int hereDir = p.dir;
            int count = p.count; //명령카운트
        	        	
            if (hereX == destX && hereY == destY && hereDir == destDir) // 마지막 목적지와 방향이 다같으면 끝
                return count;
 
 
            // 직진 1~3만큼만 갈수있음 
            for (int j = 1; j <= 3; j++) {                
                int nextX = hereX + dx[hereDir] * j; //현재위치에서 현재방향으로  j만큼 
                int nextY = hereY + dy[hereDir] * j;                 
                if ( nextX >= 0 && nextY >= 0 &&nextX < maxX && nextY < maxY && map[nextX][nextY] != 1) { //범위안벗어났을때랑 맵의 값이 1이아닐때 
                	//범위안벗어났으면 그때 방문했는지 검사해서 방문안했으면 
                	if (visited[nextX][nextY][hereDir]==false){ 
                		visited[nextX][nextY][hereDir] = true;
                		q.add(new Point(nextX, nextY, hereDir, count+1));//직진했으니 COUNT+1
                	}
                }
                else{ //범위벗어나면 바로 직진하는 반복문 멈춰야함!!
                	break;
                }               
            } 
            
            // ★★ 회전
            for(int j = 1; j <= 4; j++) {
            	//회전할 방향이 반대방향이아니여야하고(90도만회전되야하니까)
            	//회전할 방향이 현재 방향이 아니여야하며 
            	//방문한적이없어야한다.
            	if (j != reverse(hereDir) && j!=hereDir && visited[hereX][hereY][j] == false){ 
            		visited[hereX][hereY][j] = true;
                    q.add(new Point(hereX, hereY, j, count + 1));//회전했으니 COUNT+1	
            	}
            }
        }
        return 0;  
    }
 
    private static int reverse(int dir){
        if (dir == 1)   return 2;
        if (dir == 2)   return 1;
        if (dir == 3)   return 4;
        if (dir == 4)   return 3;
        return -1;
    }
 
    private static class Point {
        public int x, y, dir, count;
        public Point(int x, int y, int dir, int count) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count; // 명령 COUNT
        }
    }
}