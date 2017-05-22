package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G12100_2 {
	 static int n;
	 static int map[][];
	 static int ans = -1;
	 public static void main(String[] args) throws IOException {
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	   n= Integer.parseInt(bf.readLine());
	   StringTokenizer st ;
	   map = new int[n][n];
	   for(int i =0; i<n; i++){
		   st = new StringTokenizer(bf.readLine());
		  for(int j=0; j<n; j++){
		   map[i][j] = Integer.parseInt(st.nextToken());
		   ans = Math.max(map[i][j], ans);
		  }
	   }
	    for(int i =0; i<4; i++){
	    	func(map,i,0);
	    }
	    System.out.println(ans);
	   
	 }
	 static void func(int a[][], int dir, int count){
		 int arr[][] = new int[n][n];
		 for(int i =0; i<n; i++){
			 for(int j=0; j<n; j++){
				 arr[i][j] = a[i][j];
			 }
		 }

		if(dir== 0){ // Right 
			for(int i=0; i<n; i++){
				for(int j=n-1; j>=0; j--){
					if(arr[i][j] !=0){
						for(int k=j-1; k>=0; k--){
							if(arr[i][j] == arr[i][k]){
								arr[i][j] = arr[i][j]*2;
								ans = Math.max(arr[i][j], ans);
								arr[i][k] = 0;
								break;
							}
							else if(arr[i][k] ==0){
								int t = arr[i][j];
	                            arr[i][j] = arr[i][k];
								arr[i][k] = t;
							}
							else{
								break;
							}
						}
					}
					
				}
				
				for(int j=n-1; j>=0 ;j--){
					if(arr[i][j]==0){
	                    for(int p = j-1; p>=0 ; p--){
							if(arr[i][p]!=0){
								int t = arr[i][j];
								arr[i][j] = arr[i][p];
								arr[i][p] = t;
								break;
							}
						}
					}
				}
				
			}
			
		}
		
		
		else if(dir==1){ //Left
			for(int i=0; i<n; i++){
				for(int j=0;j<n; j++){
					if(arr[i][j] !=0){
						for(int k=j+1; k<n; k++){
							if(arr[i][j] == arr[i][k]){
								arr[i][j] = arr[i][j]*2;
								ans = Math.max(arr[i][j], ans);
								arr[i][k] = 0;
								break;
							}
							else if(arr[i][k] ==0){
								int t = arr[i][j];
	                            arr[i][j] = arr[i][k];
								arr[i][k] = t;
							}
							else{
								break;
							}
						}
					}
					
				}
				
				for(int j=0; j<n ;j++){
					if(arr[i][j]==0){
	                    for(int p = j+1; p<n ; p++){
							if(arr[i][p]!=0){
								int t = arr[i][j];
								arr[i][j] = arr[i][p];
								arr[i][p] = t;
								break;
							}
						}
					}
				}
				
			}
			
		}
		else if(dir ==2){ // Down
			
			for(int i=0; i<n; i++){
				for(int j=n-1; j>=0; j--){
					if(arr[j][i] !=0){
						for(int k=j-1; k>=0; k--){
							if(arr[j][i] == arr[k][i]){
								arr[j][i] = arr[j][i]*2;
								ans = Math.max(arr[j][i], ans);
								arr[k][i] = 0;
								break;
							}
							else if(arr[k][i] ==0){
								int t = arr[j][i];
	                            arr[j][i] = arr[k][i];
								arr[k][i] = t;
							}
							else{
								break;
							}
						}
					}
					
				}
				
				for(int j=n-1; j>=0 ;j--){
					if(arr[j][i]==0){
	                    for(int p = j-1; p>=0 ; p--){
							if(arr[p][i]!=0){
								int t = arr[j][i];
								arr[j][i] = arr[p][i];
								arr[p][i] = t;
								break;
							}
						}
					}
				}
				
			}
			
		}
		else if(dir==3){ // Up
			
			for(int i=0; i<n; i++){
				for(int j=0;j<n; j++){
					if(arr[j][i] !=0){
						for(int k=j+1; k<n; k++){
							if(arr[j][i] == arr[k][i]){
								arr[j][i] = arr[j][i]*2;
								ans = Math.max(arr[j][i], ans);
								arr[k][i] = 0;
								break;
							}
							else if(arr[k][i] ==0){
								int t = arr[j][i];
	                            arr[j][i] = arr[k][i];
								arr[k][i] = t;
							}
							else{
								break;
							}
						}
					}
					
				}
				
				for(int j=0; j<n ;j++){
					if(arr[j][i]==0){
	                    for(int p = j+1; p<n ; p++){
							if(arr[p][i]!=0){
								int t = arr[j][i];
								arr[j][i] = arr[p][i];
								arr[p][i] = t;
								break;
							}
						}
					}
				}
			}
			
		}
		
		if(count>=4){
			return;
		}
		for(int i =0; i<4; i++){
			func(arr,i,count+1);
		}
		
		
	 }
}
