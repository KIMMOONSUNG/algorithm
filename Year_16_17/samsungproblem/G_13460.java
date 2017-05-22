package samsungproblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_13460{ // 째로탈출 2  -> 완전탐색 
	static int n;
	static int m;
	static char map[][];
    static boolean state;
    static int ans =1000000;
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		boolean rfinish=false;
		boolean bfinish=false;
		
		for(int i =1; i<=4; i++){
			func(i,1,map,rfinish,bfinish);
		}
		if(state == false){
			ans =-1;
		}
		
		System.out.println(ans);
		
	}
	
	static void func(int dir, int cnt, char t[][] , boolean r, boolean b ){
		if(cnt==11){
			return;
		}
		//
		char arr[][] = new char [n][m];
		
		for(int i =0; i<n; i++){
			for(int j =0; j<m; j++){
				arr[i][j] = t[i][j];
			}
		}
		//
		if(dir==1){ // left로 밀어주기 
			for(int i =1; i<n-1; i++){
				for(int j=1; j<m-1 ; j++){
					if(j!=1){
						if(arr[i][j]=='B' || arr[i][j]=='R'){ //B 나 R일시에 
							for(int v=j-1; v>=0; v--){ // 그 부부분에서 감소하면서 검사 
								if(arr[i][v]!='.'){  // 빈공간이 아닌 벽이나 다른부분이 나왔을시 
									if(arr[i][v] =='O'){ // 구멍일  경우 
									 if(arr[i][j]=='B'){  
										 b= true;
									 }
									 else if(arr[i][j]=='R'){
										 r = true;
									 }
									 arr[i][j] = '.'; // 빠진부분은 . 으로 바꿔준다 
									}
									else{ // 구멍이 아닌 벽이나 R 이면 B B이면 R 일 경우에는 그지점 바로 전까지 이동하게 함 (맞교환) 
									 char ch = arr[i][v+1];  
									 arr[i][v+1] = arr[i][j];
									 arr[i][j] = ch;
									}
									
									break;
								}
							}
							
						}
					}
				}
			}
		}
	
		else if(dir==2){ // right 
			 
			for(int i =1; i<n-1; i++){
				for(int j=m-2; j>=0 ; j--){
					if(j!=m-2){
						if(arr[i][j]=='B' || arr[i][j]=='R'){
							for(int v=j+1; v<m; v++){
								if(arr[i][v]!='.'){
									if(arr[i][v] =='O'){
									 if(arr[i][j]=='B'){
										 b= true;
									 }
									 else if(arr[i][j]=='R'){
										 r = true;
									 }
									 arr[i][j] = '.';
									}
									else{
									 char ch = arr[i][v-1];
									 arr[i][v-1] = arr[i][j];
									 arr[i][j] = ch;
									}
									break;
								}
							}
							
						}
					}
				}
			}
			
		}
		
		else if(dir==3){ //down 

			for(int i =1; i<m-1; i++){ 
				for(int j=n-2; j>=0 ; j--){
					if(j!=n-2){
						if(arr[j][i]=='B' || arr[j][i]=='R'){
							for(int v=j+1; v<n; v++){
								if(arr[v][i]!='.'){
									if(arr[v][i] =='O'){
									 if(arr[j][i]=='B'){
										 b= true;
									 }
									 else if(arr[j][i]=='R'){
										 r = true;
									 }
									 arr[j][i] = '.';
									}
									else{
									 char ch = arr[v-1][i];
									 arr[v-1][i] = arr[j][i];
									 arr[j][i] = ch;
									}
									break;
								}
							}
							
						}
					}
				}
			}
			
		}
		
		else if(dir==4){ // up
		
			for(int i =1; i<m-1; i++){ 
				for(int j=1; j<n ; j++){
					if(j!=1){
						if(arr[j][i]=='B' || arr[j][i]=='R'){
							for(int v=j-1; v>=0; v--){
								if(arr[v][i]!='.'){
									if(arr[v][i] =='O'){
									 if(arr[j][i]=='B'){
										 b= true;
									 }
									 else if(arr[j][i]=='R'){
										 r = true;
									 }
									 arr[j][i] = '.';
									}
									else{
									 char ch = arr[v+1][i];
									 arr[v+1][i] = arr[j][i];
									 arr[j][i] = ch;
									}
									break;
								}
							}
							
						}
					}
				}
			}
			
		}

		if(r == true && b==false){ // 레드 만 빠졌을 경우 
			ans = Math.min(ans, (cnt));
			state = true;
            return;
		}
		else if( r==true && b==true){ // 둘다 빠졌을 경우 
			return;
		}
		else if(b==true && r==false){ // 블루 만 빠졌을 경우 
			return;
		}
		
		
		for(int i=1; i<=4; i++){

			func(i,(cnt+1), arr,r,b);
			
		}
		
	}
}