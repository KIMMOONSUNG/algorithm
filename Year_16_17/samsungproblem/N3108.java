package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N3108 { // 3108 로고 -> 단순 사각형 안겹치는 그룹 몇개인지 찾는거로 시뮬레이션으로 품 
	static int n;
	static int pan [][];
	static int res [];
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	 n = Integer.parseInt(bf.readLine());
	 pan = new int[1000+2][1000+2];
	 res = new int[n+1];
	 StringTokenizer st ;
	for(int cnt =1; cnt<=n; cnt++){
	 	st = new StringTokenizer(bf.readLine());
	 	int x1 = Integer.parseInt(st.nextToken())+500;
	 	int y1 = Integer.parseInt(st.nextToken())+500;
	 	int x2 = Integer.parseInt(st.nextToken())+500;
	 	int y2 = Integer.parseInt(st.nextToken())+500;
	 	res[cnt] = cnt;
	 	
	 	for(int i=x1; i<=x2; i++){ // 세로  쭉 
	 		for(int j=y1; j<=y2; j++){ // 가로 쭉 
	 			if(!(i>x1 && i<x2 && j>y1 && j<y2)){ //사각형 둘레에만 카운트 체크 
	 				if(pan[i][j] ==0){ //둘레가 안그려져있을시  
	 					pan[i][j] = cnt; // 둘레에 현재 사각형 번호 저장 
	 				}
	 				else{ //둘레가 그려져있을시 (즉 겹칠시 )
	 					int group = res[pan[i][j]]; // 사각형이 속한 그룹 번호 
	 					
	 					if(res[cnt] == cnt){// 있는 사각형이 아무 그룹에도 속하지 않을시에 (그냥 자기 자신만 그려져있을시 )
	 						res[cnt] = group;
	 					}
	 					
	 					else if(res[cnt]!=group){// 그룹에속해있는 즉 이미 겹치는거가 있는 사각형 만났을시에  
	 					  int pastNum = res[cnt];
	 					  for(int h=1; h<=cnt; h++){
	 						  if(res[h]==pastNum){
	 							  res[h] = group;
	 						  }
	 					  }
	 					}
	 				}
	 				
	 			}
	 		}
	 	} 	
	}
	
	
	
	
	Arrays.sort(res); //정렬 해줘야 비교하면서 다른 그룹이 몇개인지 알수있음 
	
	int k = res[1];
	int cnt = 0;
	for(int a =2; a<=n; a++){
		if(res[a] != k){
			cnt++;
			k = res[a];
		}
	}
	if(pan[500][500] == 0){ // 거북이는 펜을 내리고있어 출발지점에 사각형이 그려져 있지않으면 올려야해서 +1 
		System.out.println(cnt+1);
	}
	else{
		System.out.println(cnt);
	}
	
 }
}
