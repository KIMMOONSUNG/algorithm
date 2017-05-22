package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S13460 {	
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static char map[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static boolean finish = false;
	static int result =1000000 ;
	
 public static void main(String[] args) throws IOException{
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new char[n][m];	
	
	for(int i=0;i<n; i++){
		String str = bf.readLine();
		for(int j=0;j<m;j++){
			map[i][j] = str.charAt(j);
		}
	}
	boolean red = false;
	boolean blue = false;
	for(int i =0; i<4; i++){
	 dfs(red, blue,map,i ,1);
	}
	
	if(finish==false){
		result =-1;
	}
	bw.write(Integer.toString(result));
	bf.close();
	bw.close();
}
 static void dfs(boolean r,boolean b, char mm[][] ,int dir , int count){
	char arr[][] = new char[n][m]; 
	for(int i =0; i<n; i++){
		for(int j=0; j<m; j++){
			arr[i][j] = mm[i][j];
		}
	}
	
	if(dir==0){ //오른쪽정렬 
		for(int i =1; i<n-1; i++){
			for(int j =m-2; j>0; j--){
				if(arr[i][j] =='R' || arr[i][j] =='B'){
					for(int k=j+1; k<m; k++){
						if(arr[i][k]=='O'){
							if(arr[i][j] =='R'){
								r = true;
							}
							else if(arr[i][j] =='B'){
								b = true;
							}
							arr[i][j] = '.';
							break;
						}
						else if(arr[i][k] !='.'){
							char temp  = arr[i][j];
							arr[i][j] = arr[i][k-1];
							arr[i][k-1] = temp;
							break;
						}
					}
				}
			}
		}
	}
	else if(dir==1){ //  left sort
		for(int i =1; i<n-1; i++){
			for(int j=1; j<m-1; j++){
				if(arr[i][j] == 'R' || arr[i][j] =='B'){
				  for(int k=j-1 ; k>=0; k--){
					if(arr[i][k] =='O'){
						if(arr[i][j] =='R'){
							r = true;
						}
						else if(arr[i][j] =='B'){
							b = true;
						}
						arr[i][j] = '.';
						break;
					}
					else if(arr[i][k]!='.'){
						char temp = arr[i][j] ;
						arr[i][j] = arr[i][k+1];
						arr[i][k+1] = temp;
						break;
					}
				  }
				}
			}
		}
	}
	else if(dir==2){ // down sort
		for(int i =1; i<m-1; i++){
			for(int j =n-2; j>0; j--){
				if(arr[j][i] =='R' || arr[j][i] =='B'){
					for(int k=j+1; k<n; k++){
						if(arr[k][i]=='O'){
							if(arr[j][i] =='R'){
								r = true;
							}
							else if(arr[j][i] =='B'){
								b = true;
							}
							arr[j][i] = '.';
							break;
						}
						else if(arr[k][i] != '.'){
							char temp  = arr[j][i];
							arr[j][i] = arr[k-1][i];
							arr[k-1][i] = temp;
							break;
						}
					}
				}
			}
		}
	}
	else if(dir==3){ // up sort 
		for(int i =1; i<m-1; i++){
			for(int j=1; j<n-1; j++){
				if(arr[j][i] == 'R' || arr[j][i] =='B'){
				  for(int k=j-1 ; k>=0; k--){
					if(arr[k][i] =='O'){
						if(arr[j][i] =='R'){
							r = true;
						}
						else if(arr[j][i] =='B'){
							b = true;
						}
						arr[j][i] = '.';
						break;
					}
					else if(arr[k][i]!='.'){
						char temp = arr[j][i] ;
						arr[j][i] = arr[k+1][i];
						arr[k+1][i] = temp;
						break;
					}
				  }
				}
			}
		}
	}

	if(r==true && b==false){
		result = Math.min(result, count);
		finish =true;
		return;
	}
	if(b==true){
		return;
	}
	if(count>=10){
		return;
	}	
	
	for(int i =0; i<4; i++){
		dfs(r,b,arr,i,count+1);
	}
	
 }
 
}
