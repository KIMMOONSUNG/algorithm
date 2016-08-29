package DP;

import java.util.Scanner;

public class D_1932 { //2096문제와 비슷 
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int a[][] = new int[N][N];
	int d[][] = new int[N][N];
	int count =0;
	for(int i=0; i<N; i++){
		for(int j =0; j<count+1; j++){
		  a[i][j] = sc.nextInt();
		}
		count++;
	}
	//거꾸로 보고 품.
	for(int i=0; i<N; i++){ //배열 마지막 라인은 자기 자신을 d에넣는다 
		d[N-1][i] = a[N-1][i];
	}
	count =N-1;
    for(int i=N-2; i>=0; i--){  //거꾸로 보고 품
    	for(int j =0; j<count; j++){ // 현재 [3][0] 이면 계속적 합인 d[4][0] d[4][1] 중에 큰거를 d에넣는다./ 
    	  d[i][j] = d[i+1][j]+a[i][j]; 
    	  if(d[i][j]<d[i+1][j+1]+a[i][j]){
    		 d[i][j] = d[i+1][j+1]+a[i][j];
    	  }
    	}
    	count--;
    }
    System.out.println(d[0][0]); //마지막 도달인 0,0에  계속적인 합인 d값을 출력
}
}
