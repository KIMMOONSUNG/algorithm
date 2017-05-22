package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1100 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    char map[][] = new char[8][8];    
	    for(int i =0; i<8; i++){
	    	String str = bf.readLine();
	    	for(int j =0; j<8; j++){
	    		map[i][j] = str.charAt(j);
	    	}
	    }
	    int ans = 0;
	    int holejjack = 0;
	    for(int i =0; i<8; i++){
	    	if(i%2==0){
	    		holejjack = 0;	
	    	}
	    	else{
	    		holejjack = 1;
	    	}
	    	for(int j=holejjack; j<8; j+=2){
	    		if(map[i][j] == 'F'){
	    			ans++;
	    		}
	    	}
	    }
	    System.out.println(ans);   
	 }
}
