package simulation;

import java.util.Scanner;

public class N_1063 { // 킹 
	 // 킹은 움직이고 돌은 그냥 가만히있는것.
	// 킹이 움직이다 돌이랑 겹치면 돌을 킹이 이동하는 방향으로 1칸 이동한다.
	// 킹은 움직이다 map범위를 벗어나면 안되고 킹이 돌을 밀었는데 돌도 범위를 벗어나면 안된다.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String K = sc.next(); // 킹 처음위치
		String D = sc.next(); // 돌의 처음위치

		int kingx = (int) K.charAt(0) - 64;  // 대문자 A->1 B->2 ... 
		int kingy = (int) K.charAt(1) - 48; // 숫자 

		int stonex = (int) D.charAt(0) - 64;
		int stoney = (int) D.charAt(1) - 48;

		int count = sc.nextInt();
		int dir[] = new int[count];

		// 0->오 ,1->왼,2->아래,3->위
		// ,4->오위대 ,5->왼위대 ,6->오아대,
		// 7->왼아대
		int dx[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
		int dy[] = { 0, 0, -1, 1, 1, 1, -1, -1 };

		for (int i = 0; i < count; i++) {
			String str = sc.next();
			switch (str) {
			case "R":
				dir[i] = 0;
				break;
			case "L":
				dir[i] = 1;
				break;
			case "B":
				dir[i] = 2;
				break;
			case "T":
				dir[i] = 3;
				break;
			case "RT":
				dir[i] = 4;
				break;
			case "LT":
				dir[i] = 5;
				break;
			case "RB":
				dir[i] = 6;
				break;
			case "LB":
				dir[i] = 7;
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < count; i++) {
			int kx = kingx + dx[dir[i]];
			int ky = kingy + dy[dir[i]];
			
			if (kx >= 1 && ky >= 1 && kx <= 8 && ky <= 8) {
				
				if (kx == stonex && ky == stoney) { // 킹이이동한자리에 돌이있을시★
					int stx = stonex + dx[dir[i]]; //돌을 킹이 이동할 같은방향으로  1칸이동
					int sty = stoney + dy[dir[i]]; 
					
					if(stx >=1 && sty>=1 && stx<=8 && sty<=8){  //돌범위가 넘어가지않는다면
						kingx = kx; // king도 움직인다 
						kingy = ky;
						stonex=stx ; 
						stoney=sty ;
					}
				}
				else{
					kingx = kx;
				    kingy = ky;
				}
			}
			
		}
		
		int a[] = new int[2]; 
		String result[] = new String[2];
		a[0] = kingx;
		a[1] = stonex;
		for (int i = 0; i < 2; i++){
			switch (a[i]) {
			case 1:
				result[i] = "A";
				break;
			case 2:
				result[i] = "B";
				break;
			case 3:
				result[i] = "C";
				break;
			case 4:
				result[i] = "D";
				break;
			case 5:
				result[i] = "E";
				break;
			case 6:
				result[i] = "F";
				break;
			case 7:
				result[i] = "G";
				break;
			case 8:
				result[i] = "H";
				break;
			default:
				break;
			}
		}
		
		String king = (result[0] + Integer.toString(kingy));
		String stone = (result[1] + Integer.toString(stoney));

		System.out.println(king);
		System.out.println(stone);

	}
}
