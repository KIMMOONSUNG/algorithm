package simulation;

import java.util.Scanner;

public class N_2979 { //트럭주차
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 주차요금 1분에 1대
		int B = sc.nextInt(); // 2대
		int C = sc.nextInt(); // 3대

		int car[][] = new int[4][2];
		
		int start = 100;
		int end = 0;
		for (int i = 1; i < 4; i++) {
			car[i][0] = sc.nextInt();
			if (start > car[i][0]) {
				start = car[i][0]; // 가장 맨처음 주차시작시간을 찾음
			}
			car[i][1] = sc.nextInt();
			if (end < car[i][1]) { // 가장 마지막 주차 나간시간
				end = car[i][1];
			}
		}
		int time[] = new int[end+1]; //인덱스를 시간으로보고 (분)
		
		for (int i = 1; i < 4; i++) { 
           for(int k=car[i][0]; k<car[i][1]; k++){ // 3가지경우를 다 봐서 첨부터 끝 시간까지 사이의 인덱스 즉 시간에 1씩 더해 넣는다 
        	   time[k] = time[k] +1;
           }
		}
		int result =0; //결과 
		
		for(int i =start; i<=end ; i++){ // 첫 시작부터 끝시작까지 검사해서
			if(time[i] ==1){   // 1대일때 
				result += time[i]* A;
			}
			else if(time[i] ==2){ //2대일때
				result += time[i] *B;
			}
			else if(time[i]==3){ // 3대일때 
				result += time[i] *C;
			}
		}
		System.out.println(result);
			
	}
}
