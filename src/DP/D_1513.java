package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_1513 {
	 public static void main(String[] args) throws IOException{
		   BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		   StringTokenizer st = new StringTokenizer(bf.readLine());
		   int n = Integer.parseInt(st.nextToken());
		   int m = Integer.parseInt(st.nextToken());
		   int joy = Integer.parseInt(st.nextToken());
		   int map[][] = new int[51][51];
		   int d[][][][] = new int[51][51][51][51];
		    //[x],[y],[오락실len개],[마지막방문오락실]
		   int result[] = new int[51];
		   int mod = 1000007;
		   
		   for(int i =0; i<51; i++){
				for(int j=0; j<51; j++){
					map[i][j]=-1;
		     }
			}
			
		   for(int i =0; i<joy; i++){
		   st = new StringTokenizer(bf.readLine());
		     int x = Integer.parseInt(st.nextToken());
		     int y = Integer.parseInt(st.nextToken());
		     map[x][y] = i;
		   }
		   
		   d[1][0][0][0] = 1;
		   
		   for(int i=1; i<=n; i++){ //(1,1)부터 
			  for(int j=1; j<=m; j++){
				  if(map[i][j] == -1){
					  d[i][j][0][0] += d[i-1][j][0][0] + d[i][j-1][0][0];
					  d[i][j][0][0] %= mod;
				  }
				  
				  for(int len =1 ; len<=joy; len++){ //오락실개수만큼 (마지막오락실번호라생각)
					  if(map[i][j] == -1)
					  { // 오락실아닌경우 
						  for(int k=0; k<joy; k++){ //오르막수처럼 더해주는거 그니까
							                        // 오락실넘버라생각 오락실가려면 오락실넘버가 다음 오락실보다 적어야ㅏ기때문에 <이거
							  d[i][j][k][len] += d[i-1][j][k][len] + d[i][j-1][k][len];
			                  d[i][j][k][len] %=mod;
						  }
					  }
					  else
					  { //오락실인경우
						  int lastjoy = map[i][j]; // 마지막방문오락실
						  if(len==1){//마지막오락실넘버가 1일때 k = 0 이고 len 0인 그 전꺼를 더해주면되니까  
							  d[i][j][lastjoy][len] += d[i-1][j][0][0]+d[i][j-1][0][0];
							  d[i][j][lastjoy][len] %= mod;
						  }
						  else{// 마지막오락실넘버가 2이상일때 
							  for(int k=0; k<lastjoy; k++){ //오르막수처럼 더해주는데 마지막 방문오락실넘버보다 적어야 갈수있으니까 < 이거임 , 
								 d[i][j][lastjoy][len] += d[i-1][j][k][len-1] + d[i][j-1][k][len-1];
								 d[i][j][lastjoy][len] %= mod;
							  }
						  }
					  }
				  }
			  }
		   }
		   StringBuilder sb = new StringBuilder();
		   for(int cnt =0; cnt<=joy; cnt++){ // 마지막오락실넘버 0~joy
			   for(int k=0; k<Math.max(1, joy); k++){//// joy가 0 즉 오락실이 하나도 없는경 1번은 이 for문돌아야해서
				   result[cnt] +=d[n][m][k][cnt];
				   result[cnt] %=mod;
			   }
			   sb.append(result[cnt]+" ");
		   }
		   System.out.println(sb);
		   
		 }
 }
