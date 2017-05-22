package JG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_9095 { //재귀함수
	  // 불가능한 경우 / 가능한 경우 / 다음의 경우로 구함
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		for(int i =0; i<n; i++){
			int m = Integer.parseInt(bf.readLine());
			System.out.println(go(0,m));
		}
	}
	static int go(int sum, int goal){
		if(sum>goal) return 0; // 불가능한경우 0 리턴
		if(sum==goal) return 1; // 가능한 경우 1 리턴
		int now = 0; 
		for(int i =1; i<=3; i++){ //다음에 오는경우로
			                      // 1인경우 go(sum+1  
			//2인경우  go(sum+2
			// 3인경우 go(sum+3
			now +=go(sum+i , goal); 
		}
		return now ;
	}
	

}
