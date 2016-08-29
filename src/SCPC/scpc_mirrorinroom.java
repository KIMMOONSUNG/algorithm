package SCPC;

import java.util.Scanner;

//방속의 거울 
public class scpc_mirrorinroom { // - > 2344, 2151, 2347, 10725,10726, 4211 문제와 비슷
	//아래 , 위 , 오른쪽, 왼쪽
	public static int d1[] = { 1, -1, 0, 0 }; 
	public static int d2[] = { 0, 0, 1, -1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt(); // 전체 테스트 케이스
		int CASE=1;
		for (int i = 0; i < Testcase; i++) { //전체 테스트 케이스만큼 for문돌아감 
			int T = sc.nextInt(); // 테스트케이스
			
			int arr[][] = new int[T][T]; // 방 T * T 정사각형
			//int arr2[][] = new int[T][T]; //반사되는거울 세기위함 중복없이
			 boolean[][] c = new boolean[T][T]; // 처음은 다 false로 저장됨 
	            for (int a=0; a<T; a++) {
	                String s = sc.next();
	                for (int b=0; b<T; b++) {
	                    arr[a][b] = s.charAt(b)-48; //고른것이 char형이되니까 -48을 써 숫자로 바꾸던가 -'0'을써서 
	                	
	                }
	            }
			int row , col, dir;
			row = 0; //인덱스 앞
			col = 0; // 인덱스 뒤
			dir = 2; // 방향으로 오른쪽으로 이동한다는 뜻 그래서 dir(방향)을 2로 두었다.
			//0 = 아래 , 1 = 위 , 2 = 오, 3 = 왼
			while(0<= row && row <T && 0<=col && col<T){
				if(arr[row][col] !=0){ // 0이아닌거는 거울이 있다는뜻
					c[row][col] = true; //이미 한번 반사됬으니까 중복방지위해 true로 바꿔놓음
					dir = change_dir(dir , arr[row][col]);
				}
				row += d1[dir]; //이동
				col += d2[dir]; 
			}
			
			int ans = 0;
			   for (int k=0; k<T; k++) {
	                for (int h=0; h<T; h++) {
	                    if (c[k][h]) {
	                        ans += 1;
	                    }
	                }
	            }
	            System.out.println("Case #" + CASE);
	            System.out.println(ans);
	            CASE++;
			/*
			System.out.println("Case #"+CASE);
			System.out.println(count);
			CASE++;
			*/
		}
	}
	
	public static int change_dir(int dir, int mirror) { //dir 은 방향 , mirror 은 1이냐 2냐
		// 0 = 아래 , 1 = 위, 2 = 오른쪽 ,3 = 왼쪽
		if(mirror==1){ // 좌측 하단으로 45도 거울
			// 0-> 3, 1->2, 2->1, 3->0
			return 3-dir; // 반사되서 방향 바뀐거를 return 함 
		}
		else{ // 우측 하단으로 45도 거울
			// 0->2 , 1->3 , 2->0, 3->1
			return (dir+2)%4; // 반사되서 방향 바뀐거를 return 함
		}
	}
}
