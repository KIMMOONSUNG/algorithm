  package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class colleections_N1764{
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String Line [] = bf.readLine().split(" ");
		int n = Integer.parseInt(Line[0]);
		int m = Integer.parseInt(Line[1]);
		HashMap<String , Integer> hm = new HashMap<String,Integer>();
		
		for(int i =0; i<n; i++){
		 String name = bf.readLine();
		 hm.put(name, 1);
		}
		
		for(int j=0; j<m; j++){
		 String name2 = bf.readLine();
		 Integer v = hm.get(name2);
		 if(v == null){
			 v = 0;
		 }
		 v+=2;
		 hm.put(name2,v);
		 
		}
		
		ArrayList<String> al = new ArrayList<String>(); 
		//for(int )
	}
}
