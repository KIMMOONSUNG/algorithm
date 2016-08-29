package bfs;
import java.util.Scanner;

public class N2178_2 { //bfs 미로찾기(최단경로)
	public static Scanner sc = new Scanner(System.in);
	public static int y = sc.nextInt();
	public static int x = sc.nextInt();
	public static int arr[][] = new int[y+1][x+1];
	public static int qx[] = new int[10000]; //
	public static int qy[] = new int[10000];
	public static int ql[] = new int[10000];
	public static int cnt = 0;
	 

	public static void main(String[] args) {
        String str= null;
		for (int a = 1; a < y+1; a++) {
			str = sc.next();
			for (int b = 1; b < x+1; b++) {
				arr[a][b] = (int) str.charAt(b-1) - 48; //문자열쓴거 나눠 배열에 넣음 
			}
			
		}
		BFS(1, 1); //BFS호출
	}
	
	public static void enqueue(int _x, int _y, int _l) {
		qx[cnt] = _x; //앞 좌표
		qy[cnt] = _y; //뒤 좌표
		ql[cnt] = _l; // 길이
        arr[qx[cnt]][qy[cnt]] = 0; //지나간 위치(큐배열에 들어간 곳)에 0 
		cnt++; //배열 큐 인덱스 증가 
	}

	public static void BFS(int i, int j) {
		int pos = 0; //현재 인덱스 
		enqueue(i, j, 1); //배열 큐에 출발 좌표와 길이 넣는다 .(0이면 출발위치길이 포함 1이면 미포함)
		while (pos < cnt && (qx[pos] != y || qy[pos] != x)) { // 현위치가 도착지점 도착했을때 종료됨 

			if (qy[pos] < x && arr[qx[pos]][qy[pos] + 1] == 1) { // 오른 
				enqueue(qx[pos], qy[pos] + 1, ql[pos] + 1); 
			}
			if (qx[pos] < y && arr[qx[pos] + 1][qy[pos]] == 1) { // 아래
				enqueue(qx[pos] + 1, qy[pos], ql[pos] + 1);
			}
			if (qy[pos] > 0 && arr[qx[pos]][qy[pos] - 1] == 1) { // 왼
				enqueue(qx[pos], qy[pos] - 1, ql[pos] + 1);
			}
			if (qx[pos] > 0 && arr[qx[pos] - 1][qy[pos]] == 1) { // 위
				enqueue(qx[pos] - 1, qy[pos], ql[pos] + 1);
			}

			pos++; 

		}
			System.out.println(ql[pos]);

	}
}
