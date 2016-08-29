package ms;

import java.util.Scanner;

//행렬 경로 문제 (n*n)
//오른쪽이나 아래쪽으로만 이동할 수 있다.
// 왼쪽, 위 , 대각선 이동은 허용하지 않는다.
// (1,1)에서 (n,n)으로 이동하는 모든 경로의 점수 중 가장 높은점수를 구하는문제.


public class dp12 {
	static Scanner sc = new Scanner(System.in);
	static int i = sc.nextInt();
	static int j = sc.nextInt();
	static int arr[][] = new int[i + 1][j + 1];
	static int arr2[][] = new int[i+1][j+1];
	
	public static void main(String[] args) {
		for (int a = 1; a < i + 1; a++) {
			for (int b = 1; b < i + 1; b++) {
				arr[a][b] = sc.nextInt();
			}
		}
		
		
		System.out.println("합:"+matrix(i)); // 총 합
		
	}
	
	static int matrix(int n){  // 거꾸로 아닌 첨부터 더해가며 중복을 없애기위해서  
		                       // 한번 나온값은 arr2로정해준 변수배열에 넣어주고 필요할때
		                       // 꺼내서 쓰므로 중복이 제거 -> 동적프로그래밍 메모제이션
		arr2[1][1]= arr[1][1]; 
		
		for(int i =2; i<=n; i++){ 
			arr2[i][1] = arr[i][1]+arr2[i-1][1];
		}
		for(int j=2; j<=n; j++){
			arr2[1][j] = arr[1][j]+arr2[1][j-1];
		}
		for(int i=2; i<=n; i++){
			for(int j=2; j<=n; j++){
				if(arr2[i-1][j]>=arr2[i][j-1]){ 
					arr2[i][j] = arr[i][j]+arr2[i-1][j] ;
				}
				else{
					arr2[i][j] = arr[i][j]+arr2[i][j-1];
					}
			}
		}
		/*////////////arr2변수배열 보기 //////////////
		for(int i=1; i<=n; i++){
			for(int j=1; j<=n; j++){
				System.out.print(arr2[i][j]+"/");
				
			}
			System.out.println();
		}
		*////////////////////////////////////////
		return arr2[n][n];
	}
}
