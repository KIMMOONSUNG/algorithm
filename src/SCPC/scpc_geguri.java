package SCPC;

import java.util.Scanner;

public class scpc_geguri {   // -> 11060 점프점프 문제와 비슷.
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int Testcase = sc.nextInt();
	int CASE = 1;
	for(int i = 0 ; i<Testcase; i++){
		int t = sc.nextInt();
		int arr[] = new int[t+1];
		
		for(int j=1; j<=t; j++){
			arr[j] = sc.nextInt();			
		}
		int count =0;//최소횟수
		int K = sc.nextInt(); //최대점프거리
		int cur = arr[0]; // 개구리가 처음있는칸
		
		for(int q=1; q<=t; q++){
			if(arr[q]-arr[q-1]>K){ // 두점 거리사이가 최대점프거리 보다 크면  -1 로 하고 끝
				count =-1;
				break;
			}
			if(cur + K < arr[q]){ // a[i] 까지 점프로 갈 수 없으면
				System.out.println("들cur값:"+cur +"값:"+ arr[q]);
				cur = arr[q-1];  // ★갈수있는 그 전칸으로 이동 빨리 많이가야하니 그전으로 이동하는것.
				count +=1; //점프 1 증가
			}
			System.out.println("난:"+cur);
		}
		if(count != -1){
		count += 1; // 마지막에 도착을 못했으니까 무조건 +1 해줌
		}
		System.out.println("Case #"+CASE);
		System.out.println(count);
		CASE++;
	}
	//이건 각 TESTCASE 마다 바로 출력되는 거임 
 }
}
