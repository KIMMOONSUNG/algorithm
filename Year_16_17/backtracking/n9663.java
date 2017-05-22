package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9663 { // N-Queen 
	static int n;
	static int result = 0;
    static boolean check1[];
    static boolean check2[];
    static boolean check3[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		// 1차원으로 
		check1 = new boolean [n+1]; // 열에 퀸이놓여있나 체크 
		check2 = new boolean [40]; //  '/'에 퀸이 놓여있나 체크  (row+col)
		check3 = new boolean [40]; // '\'에 퀸이 놓여있나 체크   (row -col +n)
        cal(0,0);
        System.out.println(result);
	}
	
	static void cal(int r, int count) { // row행의퀸을 어디에 놓을지 결정 하는
		//0번 row부터 n-1 row 까지 모두 퀸을 놓게 되면 
		if(r == n){ //n 을 찾는거니 끝까지 간거 -> 정답을 찾은거 따라서 1을 증가 
			result += (count+1);
		}
		for(int c =0 ; c<n; c++){
			if(check (r,c)== false){ // 체크했는데 3방향(열 ,대각선 2방향 )중 킹이 없다면 
				check2[r+c] = true; 
				check3[r-c+n] = true;
				check1[c] = true;

				cal(r+1,count); // 행 하나 증가 시킴 
				
				//다시 false해줘야 가능한지 확인 끝났으니 원래상태로 -> 백트래킹 
				check1[c] = false;
				check2[r+c] = false;
				check3[r-c+n] = false;

			}
		}
	}
	
	static boolean check(int r, int c) {
       if(check1[c]==true){
    	   return true;
       }
       //왼쪽 위 대각선 
       if(check2[r+c] == true){
    	   return true;
       }
       if(check3[r-c+n]==true){
    	   return true;
       }
       return false;
	}

}
