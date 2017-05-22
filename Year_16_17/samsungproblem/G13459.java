package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G13459 { // 째로탈출 
	static int n;
	static int m;
	static char map [][];
	static int dx[]= {0,0,1,-1};
	static int dy[] ={1,-1,0,0};
	static boolean finish = false;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new char[n][m];
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j);
		}
	}
	 boolean red = false;
	 boolean blue = false;
	
	for(int i =0; i<4; i++){
		func(i,0,map,red,blue);
	}
	
	if(finish== true){
		bw.write("1");
	}
	else{
		bw.write("0");
	}
	 bw.close();
 }
 static void func(int dir, int cnt , char arr[][], boolean r , boolean b){	 
	 if(cnt>=10){
		 return;
	 }
	  char map[][] = new char[n][m];
	  for(int i =0; i<n; i++){
		  for(int j =0; j<m; j++){
			  map[i][j] = arr[i][j];
		  }
	  }
	  
	 if(dir==0){ // Left sort 
		 for(int i =1; i<n-1; i++){
			 for(int j =1; j<m-1; j++){
				
				 if(map[i][j] == 'B' || map[i][j] == 'R'){
				  for(int k=j-1; k>=0; k-- ){
					  if(map[i][k] == '#'|| map[i][k] == 'B' || map[i][k] == 'R'){  
						  char ch = map[i][k+1] ;
						  map[i][k+1] = map[i][j] ;
					      map[i][j] = ch;
					      break;
					  }
					  else if(map[i][k] =='O'){
						  if(map[i][j] == 'B'){
							  b = true;
						  }
						  else if(map[i][j] == 'R'){
							  r = true;
						  }
						  map[i][j] = '.';
						  break;
					  }
				   }
				 }
			  
			 }
		 }
	 }
	 
	 else if(dir==1) { // Right sort
		 for(int i =1; i<n-1; i++){
			 for(int j =m-2; j>=0; j--){
				
				 if(map[i][j] == 'B' || map[i][j] == 'R'){
					 for(int k= j+1 ; k<m; k++){
						 if(map[i][k] == '#'|| map[i][k] == 'B' || map[i][k] == 'R'){
							 char ch = map[i][k-1];
							 map[i][k-1] = map[i][j];
							 map[i][j] = ch;
							 break;
						 }
						 else if(map[i][k] == 'O'){
							 if(map[i][j] =='B'){
								 b = true;
							 }
							 else if(map[i][j] == 'R'){
								 r = true;
							 }
							 map[i][j] ='.';
							 break;
						 }
					 }
				 
				  
				 }
			 }
		 }
	 }
	 
	 else if(dir==2){  // down sort
		 
		 for(int i =1; i<m-1; i++){
			 for(int j =n-2; j>=0; j--){
				
					
				 if(map[j][i] == 'B' || map[j][i] == 'R'){
					 for(int k= j+1 ; k<n; k++){
						 if(map[k][i] == '#'|| map[k][i] == 'B' || map[k][i] == 'R'){
							 char ch = map[k-1][i];
							 map[k-1][i] = map[j][i];
							 map[j][i] = ch;
							 break;
						 }
						 else if(map[k][i] == 'O'){
							 if(map[j][i] =='B'){
								 b = true;
							 }
							 else if(map[j][i] == 'R'){
								 r = true;
							 }
							 map[j][i] ='.';
							 break;
						 }
					 }
				 }
				
			 }
		 }
		 
	 }
	 
	 else if(dir==3){
		 
		 for(int i =1; i<m-1; i++){
			 for(int j =1; j<n; j++){
				
				 if(map[j][i] == 'B' || map[j][i] == 'R'){
				  for(int k=j-1; k>=0; k-- ){
					  if(map[k][i] == '#' || map[k][i] == 'B' || map[k][i] == 'R'){  
						  char ch = map[k+1][i] ;
						  map[k+1][i] = map[j][i] ;
					      map[j][i] = ch;
					      break;
					  }
					  else if(map[k][i] =='O'){
						  if(map[j][i] == 'B'){
							  b = true;
						  }
						  else if(map[j][i] == 'R'){
							  r = true;
						  }
						  map[j][i] = '.';
						  break;
					  }
				   }
				 
				}
			 }
		 }
		 
	 }
	 
	 if(finish==true){
		 return;
	 }
	 if(r==true && b== false){
		 finish = true;
		 return;
	 }
	 else if(b==true){
		 return;
	 }
	 
	 
	 	 
	 for(int i =0; i<4; i++){
		 func(i,cnt+1,map,r,b);
	 }
	 
 }
 
}
