package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S12100 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int map[][];
	static int max = -1;
 public static void main(String[] args) throws IOException {
	 
	 bf = new BufferedReader(new InputStreamReader(System.in));
	 bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 n = Integer.parseInt(bf.readLine());
	 map = new int[n][n];
	 for(int i=0; i<n; i++){
	   st = new StringTokenizer(bf.readLine());
	  for(int j=0; j<n; j++){
		map[i][j] = Integer.parseInt(st.nextToken());
		max = Math.max(max, map[i][j]);
	  }
	 }
	 for(int i =1; i<=4; i++){
		 dfs(i,1,map);
	 }
	 bw.write(Integer.toString(max));
	 bw.close();
	 bf.close();
 }
 static void dfs(int dir, int count,int arr[][]){
	 int mm [][] = new int[n][n];
	 for(int i =0; i<n; i++){
		 for(int j =0; j<n; j++){
			 mm[i][j] = arr[i][j];
		 }
	 }
   if(dir==1){ // rigth sort 
	   for(int i =0; i<n; i++){
		 for(int j=n-1; j>=0 ; j--){
			 
			 if(mm[i][j] !=0){
				 for(int k= j-1; k>=0; k--){
					if(mm[i][j] == mm[i][k]){
						mm[i][j] = mm[i][j]*2;
						max = Math.max(mm[i][j], max);
						mm[i][k] = 0;
						break;
					}
					else if(mm[i][k] ==0){
						int t = mm[i][j];
						mm[i][j] = mm[i][k];
						mm[i][k] =t;
					}
					else{
						break;
					}
				 }
			 }
			 
		 }
		 for(int j=n-1; j>=0; j--){
			 if(mm[i][j]==0){
				 for(int k=j-1; k>=0; k--){
					 if(mm[i][k] !=0){
						 int temp = mm[i][j];
						 mm[i][j] = mm[i][k];
						 mm[i][k] = temp;
						 break;
					 }
				 }
			 }
		 }
		 
	   }
   }
   else if(dir==2){
	   for(int i =0; i<n; i++){
		   for(int j =0; j<n; j++){
			   if(mm[i][j] != 0){
				   for(int k=j+1; k<n; k++){
					   if(mm[i][j]==mm[i][k]){
						   mm[i][j] = mm[i][j]*2;
						   max =Math.max(max,mm[i][j]);
						   mm[i][k] = 0;
						   break;
					   }
					   else if(mm[i][k] ==0){
						   int t = mm[i][j];
						   mm[i][j] = mm[i][k];
						   mm[i][k] = t;
					   }
					   else {
						   break;
					   }
				   }
			   }
		   }
		   
		   for(int j =0; j<n; j++){
			   if(mm[i][j] ==0){
				   for(int k=j+1; k<n; k++){
					   if(mm[i][k] !=0){
						   int temp = mm[i][j];
						   mm[i][j] = mm[i][k];
						   mm[i][k] = temp;
						   break;
					   }

				   }
			   }
		   }
	   }
   }
   
   else if(dir==3){
	   
	   for(int i =0; i<n; i++){
			 for(int j=n-1; j>=0 ; j--){
				 
				 if(mm[j][i] !=0){
					 for(int k= j-1; k>=0; k--){
						if(mm[j][i] == mm[k][i]){
							mm[j][i] = mm[j][i]*2;
							max = Math.max(mm[j][i], max);
							mm[k][i] = 0;
							break;
						}
						else if(mm[k][i] ==0){
							int t = mm[j][i];
							mm[j][i] = mm[k][i];
							mm[k][i] = t;
						}
						else{
							break;
						}
					 }
				 }
				 
			 }
			 for(int j=n-1; j>=0; j--){
				 if(mm[j][i]==0){
					 for(int k=j-1; k>=0; k--){
						 if(mm[k][i] !=0){
							 int temp = mm[j][i];
							 mm[j][i] = mm[k][i];
							 mm[k][i] = temp;
							 break;
						 }
					 }
				 }
			 }
			 
		   }
	   
   }
   else if(dir==4){
	   
	   for(int i =0; i<n; i++){
		   for(int j =0; j<n; j++){
			   if(mm[j][i] != 0){
				   for(int k=j+1; k<n; k++){
					   if(mm[j][i]==mm[k][i]){
						   mm[j][i] = mm[j][i]*2;
						   max =Math.max(max,mm[j][i]);
						   mm[k][i] = 0;
						   break;
					   }
					   else if(mm[k][i] ==0){
						   int t = mm[j][i];
						   mm[j][i] = mm[k][i];
						   mm[k][i] = t;
					   }
					   else {
						   break;
					   }
				   }
			   }
		   }
		   
		   for(int j =0; j<n; j++){
			   if(mm[j][i] ==0){
				   for(int k=j+1; k<n; k++){
					   if(mm[k][i] !=0){
						   int temp = mm[j][i];
						   mm[j][i] = mm[k][i];
						   mm[k][i] = temp;
						   break;
					   }
					   
				   }
			   }
		   }
		   
	   }
	   
   }
   if(count>=5){
	   return;
   }
   
   for(int i =1; i<=4; i++){
	   dfs(i,count+1,mm);
   }
   
 }
 
}
