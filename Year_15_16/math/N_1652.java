package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1652 {
	 public static void main(String[] args) throws IOException{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(bf.readLine());
		    char map[][] = new char[n][n];
		    for(int i =0; i<n; i++){
		    	String str = bf.readLine();
		    	for(int j =0; j<n; j++){
		    	 map[i][j] = str.charAt(j);
		    	}
		    }
		    int w_result =0;
		    int h_result =0;
		    for(int i =0; i<n; i++){
		    	int w_ans =0;
		    	int h_ans =0;
		    	boolean w = false; // 2개 이상 되서 return하고 끝내면 ..X.. 이런경우 체크를 못하기때문에 체크해주려고 
				boolean h = false;
		    	for(int j =0; j<n; j++){ // 가로 
		    		if(map[i][j]=='X'){
		    			w_ans =0;
		    			w = false; 
		    		}
		    		else{
		    			w_ans++;
		    		}
		    		if(w_ans>=2&& w==false){ 
		    			w = true;
		    			w_result ++;
		    		}
		    		
		    	}
		    	for(int j=0; j<n; j++){ // 세로
		    		if(map[j][i]=='X'){
		    			h_ans =0;
		    			h= false;
		    		}
		    		else{
		    			h_ans++;
		    		}
		    		if(h_ans>=2 && h == false){
		    			h=true;
		    			h_result ++;    		    
		    		}
		    	}
		    }
		    System.out.println(w_result+" "+ h_result);
		 } 
}
