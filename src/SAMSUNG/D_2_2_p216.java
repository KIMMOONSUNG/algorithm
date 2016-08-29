package SAMSUNG;

import java.util.Scanner;

public class D_2_2_p216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 사람수
		int ele[] = new int[N*2]; // 엘리베이터 시작층도착층시작층...이런식
		for (int a = 0; a < N*2; a++) {
				ele[a] = sc.nextInt();
		}
		int now = 0; //현위치 
		int count = 0;//운행거리 
		for (int a = 0; a < N*2; a++) {
			now = ele[a]; //현재위치 
			
			if(a!=(N*2)-1){ 
			while(true){
				if (now > ele[a+1]){ 
					now--;
					count++;
				} 
				else if (now < ele[a+1]){
					now++;
					count++;
				}
				else if (now == ele[a+1]){
					break;
				}
			 }
		    }
		}
		System.out.println(count);
	}
}
