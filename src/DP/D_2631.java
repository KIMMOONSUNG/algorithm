package DP;

import java.util.Scanner;

public class D_2631 { //11053과 비슷 ★ // 11722랑 비슷
	                  // 가장 길게 정열된길이를 찾고 아이들수에서 그 정열된 길이를 빼면 줄세우기위해 이동해야할 아이들 수가 정해진다.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // //아이들의 수
		int a[] = new int[N]; // 아이들 번호
		int d[] = new int[N]; // 자기포함해 정열된 길이 수를 저장
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		int max =0;
		for (int i = 0; i < N; i++) { //기준하는 인덱스값 i
			d[i]=1; // 자기 자신 포함해야해서 초기 1을 넣어주고 시작 
			for (int j = 0; j < i; j++) { // 비교하는 인덱스값 j 
				if (a[i] > a[j] && d[i]<d[j]+1) {  // 현재 자신보다 작은 거 중에서 그 작은거들 중 자기가 가지고있는 정열 길이가 가장큰거에  
					d[i] = d[j] +1;                // +1을 해준다 (현재 자신을 포함시키기위해 길이 1 늘림 )
				}
			}
		}
		for (int i = 0; i < N; i++) {// 넣어진 정열된 길이 수 중에서  최대값을 max에 넣는다.
			if(max<d[i]){
				max = d[i];
			}
		}
		  System.out.println(N-max); // ★★★★★★★★★★★		
	}
}
