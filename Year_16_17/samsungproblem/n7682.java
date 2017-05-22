package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n7682 {
	static final int n = 3;
	static char map[][];
	static BufferedReader bf;
	static BufferedWriter bw;	
	static int xcount=0;
	static int ocount=0;
	static boolean visit[][][];
	static int dx[]= {0,0,1,-1,-1,1,-1,1 };
	static int dy[]= {1,-1,0,0,1,-1,-1,1 };	
	
 public static void main(String[] args) throws IOException {
	 
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	String str = "";
	
	while(true){
		str = bf.readLine();
		if(str.equals("end")){
			break;	
		}
		int xcnt=0;
		int ocnt=0;
		visit = new boolean[n][n][10];
		map = new char[n][n];
		xcount =0;
		ocount =0;
		for(int i =0; i<n ; i++){ // 맵에 넣는다 
			String str2 = str.substring(i*3,(i+1)*3);
			for(int j =0; j<n; j++){
				map[i][j] = str2.charAt(j);
				if(map[i][j]=='O'){
					ocnt++;
				}
				else if(map[i][j] =='X'){
					xcnt++;
				}
			}
		}
		
		boolean check = false;

		for(int i =0; i<n; i++){ // 빈공간의 여부를 파악한다 
			for(int j =0; j<n; j++){
				if(map[i][j] =='.'){
					check =true;
				}
			}
		}
		
		if(check==true){ // 빈공간있을시에 
			if(xcnt==ocnt || xcnt==(ocnt+1)){  // 이조건이 만족해야함 
				
				for(int i =0; i<n; i++){
					for(int j =0; j<n; j++){
						if(map[i][j]!='.'){
						func(i,j);
						}
					}
				}
				
			   if(xcnt == ocnt){ //o가 이겨야함
				 if(xcount==0 && ocount!=0){
						bw.write("valid\n");
				 }
				 
				 else{
					 bw.write("invalid\n");
				 }
			   }
			 
			   else if(xcnt == (ocnt+1)){ // x가 이겨야함 
				 if(xcount!=0 && ocount==0){
						bw.write("valid\n");
					}
				 else{
					 bw.write("invalid\n");
				 }
			   }
			 
			   else{ 
				 bw.write("invalid\n");
			   }

			}
			
			
			else{
				bw.write("invalid\n");
			}
			
		}
		
		else if(check == false){ // 빈공간 하나도 없을시에 

		  if(xcnt==(ocnt+1)){  //항상 X가 더 많아야 함 
				for(int i =0; i<n; i++){
					for(int j =0; j<n; j++){
						if(map[i][j]!='.'){
							func(i,j);
						}
					}
				}
				
			  if(ocount!=0){ // O가 이기면안됨 
				  bw.write("invalid\n");
			  }

			  else {
			      bw.write("valid\n");
			  }
			  
		  }
			
		  else{
				bw.write("invalid\n");
			  }
		}
		
	}
	
	bf.close();
	bw.close();

} 
 
 static void func(int a, int b) {  //3 차원 으로 방향까지 해서 역방향 까지true로 바꿔서 중복 방지 
	 int xcnt =0;
	 int ocnt =0;
	 int xc=0;
	 int oc=0;
	  if(map[a][b]== 'X'){
		  xc++;
	  }
	  
	  else if(map[a][b]=='O'){
		  oc++;
	  }
	  
	 for(int i =0; i<8; i++){
		 xcnt = xc;
		 ocnt = oc;
		 visit[a][b][i] = true;
		 visit[a][b][reverse(i)] = true;
		 for(int k=1; k<=2; k++){
			 int x = a+dx[i]*k;
			 int y = b+dy[i]*k;
			 
		     if(x>=0 && y>=0 && x<n && y<n){
		    	 
		      if(visit[x][y][i]==false){
		    	  visit[x][y][i] = true;
		    	  visit[x][y][reverse(i)] = true;
		     	if(map[x][y]=='X'){
		     		xcnt++;
		     	}
		     	else if(map[x][y]=='O'){
		     		ocnt++;
		     	}
		      }
		      
		     }
		     
		 }
		     if(xcnt == 3){
				 xcount++;
			 }
			 else if(ocnt==3){
				 ocount++;
			 }
		 
	 }
	
	 
 }
 static int reverse(int dir){
	 if( dir==0){
		 return 1;
	 }
	 else if(dir==1){
		 return 0;
	 }
	 else if(dir==2){
		 return 3;
	 }
	 else if(dir==3){
		 return 2;
	 }
	 else if(dir==4){
		 return 5;
	 }
	 else if(dir==5){
		 return 4;
	 }
	 else if(dir==6){
		 return 7;
	 }
	 else if(dir==7){
		 return 6;
	 }
	 else {
		 return -999;
	 }
 }
 
 
}
