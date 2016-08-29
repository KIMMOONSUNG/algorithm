package ms;

import java.util.Scanner;

//행렬 경로 문제 (n*n)
//오른쪽이나 아래쪽으로만 이동할 수 있다.
// 왼쪽, 위 , 대각선 이동은 허용하지 않는다.
// (1,1)에서 (n,n)으로 이동하는 모든 경로의 점수 중 가장 높은점수를 구하는문제.


public class dp1 {
	static Scanner sc = new Scanner(System.in);
	static int i = sc.nextInt();
	static int j = sc.nextInt();
	static int arr[][] = new int[i + 1][j + 1];
	
	public static void main(String[] args) {
		for (int a = 1; a < i + 1; a++) {
			for (int b = 1; b < j + 1; b++) {
				arr[a][b] = sc.nextInt();
			}
		}
		
		
		System.out.println("합:"+matrix(i,j)); // 총 합
		
	}
	static int matrix(int i,int j){ // 재귀호출  //(i,j)에서 거꾸로올라감 1,1까지  
                                    // 중복많음.
		
		if(i==1 && j==1){ //(1,1)일때의 값은 당연 (1,1)이 총값
			return arr[1][1];
			
		}
		else if(i==1){ //행고정 
			return (arr[1][j]+matrix(1,j-1));
		}
		else if(j==1){ //열고정 
			return (arr[i][1]+matrix(i-1,1));
		}
		else{
				if(matrix(i-1,j)>=matrix(i,j-1)){ //둘중 큰거와 마지막배열을 더한게 최종 합 
					return arr[i][j]+matrix(i-1,j);
				}
				else{
					return arr[i][j]+matrix(i,j-1);
					}
			} 
		
	}
}
