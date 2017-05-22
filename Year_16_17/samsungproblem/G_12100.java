package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_12100 { // 12100 2046(Easy) -> 삼성기출문제 
	static int n;
	static int map[][];
	static long max ;    
	
	public static void main(String args[]) throws IOException {
     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     n =Integer.parseInt(bf.readLine());
 	map = new int [n][n];
 	StringTokenizer st ;
 	for(int i =0; i<n; i++){
 		st = new StringTokenizer(bf.readLine());
 		for(int j =0; j<n; j++){
 			map[i][j] = Integer.parseInt(st.nextToken());
  			max = Math.max(map[i][j], max);
 		}
 	}
 	for(int i =1; i<=4; i++){
 		func(i,1,map); 		
 	}
 	System.out.println(max);
 	
  }
	
static void func(int dir, int count,int m[][]){
	
	if(count>5){
		return;
	}
	///// -> 배열그때그때 상태 //////
	int arr[][] = new int[n][n];
    for(int i =0; i<n; i++){
    	for(int j=0; j<n; j++){
    		arr[i][j] = m[i][j];
    	}
    }
    /////////////////////////////
    
    
	///
    

    if(dir==1){ // right 
		for(int i=0;i<n;i++){
			int val = n-1;
			for(int j=n-1;j>=0;j--){
				if(val != j &&arr[i][j] !=0 ){
					if(arr[i][val] == arr[i][j]){
						arr[i][val] = arr[i][j]*2;
						max = Math.max(max, arr[i][val]);
						arr[i][j] = 0;
						val--;
					}
					else if(arr[i][val]==0){
						arr[i][val] = arr[i][j];
						arr[i][j] = 0;
					}
					else if(arr[i][val] != arr[i][j]){
						val--;
						int t = arr[i][j];
						arr[i][j] = 0;
						arr[i][val] = t;
					}
				}
			}
		}
	}
    else if(dir==2){ // left 
		for(int i=0;i<n;i++){
			int val = 0;
			for(int j=0;j<n;j++){
				if(val != j && arr[i][j] !=0 ){
					
					if(arr[i][val] == arr[i][j]){
						arr[i][val] = arr[i][j]*2;
						max = Math.max(arr[i][val], max);
						arr[i][j] = 0;
						val++;
					}
					else if(arr[i][val]==0){ // 빈공간 
						arr[i][val] = arr[i][j];
						arr[i][j] = 0;
					}
					else if(arr[i][val] != arr[i][j]){
						val++;
						int t = arr[i][j];
						arr[i][j] = 0;
						arr[i][val] = t;
					}
					
				}
			}
		}
	}
    
	else if(dir==3){ // down 
		for(int i=0;i<n;i++){
			int val = n-1;
			for(int j=n-1;j>=0;j--){
				if(val != j &&arr[j][i] !=0 ){
					
					if(arr[val][i] == arr[j][i]){
						arr[val][i] = arr[j][i]*2;
						max = Math.max(max, arr[val][i]);
						arr[j][i] = 0;
						val--;
					}
					else if(arr[val][i]==0){
						arr[val][i] = arr[j][i];
						arr[j][i] = 0;
					}
					else if(arr[val][i] != arr[j][i]){
						val--;
						int t = arr[j][i];
						arr[j][i] = 0;
						arr[val][i] = t;
					}
					
				}
			}
		}
	}
    
	else if(dir==4){ // up
		for(int i=0;i<n;i++){
			int val = 0;
			for(int j=0;j<n;j++){
				if(val != j && arr[j][i] !=0 ){
					
					if(arr[val][i] == arr[j][i]) {
						arr[val][i] = arr[j][i]*2;
						max = Math.max(arr[val][i],max);
						arr[j][i] = 0;
						val++;
					}
					else if(arr[val][i]==0) { //빈공간일시에 
						arr[val][i] = arr[j][i];
						arr[j][i] = 0;
					}
					else if(arr[val][i] != arr[j][i]) {
						val++;
						int t = arr[j][i];
						arr[j][i] = 0;
						arr[val][i] = t;
					}
					
				}
				
			}
		}
	}
    
        for(int i =1; i<=4; i++){
		 func(i,count+1,arr); 
        }
        
 }

 
}
