package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class set_N_10815_2 {
	public static void main(String[] args) throws IOException{
	 	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 	int n = Integer.parseInt(bf.readLine());
	 	HashSet<Integer> hs = new HashSet<Integer>();
	 	StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	 	for(int i =0; i<n; i++){
	 		hs.add(Integer.parseInt(st.nextToken()));
	 	}
	 	int m = Integer.parseInt(bf.readLine());
	 	st = new StringTokenizer(bf.readLine().trim());
	 	StringBuilder sb = new StringBuilder();
	 	for(int i=0; i<m; i++){
	 		if(hs.contains(Integer.parseInt(st.nextToken()))){
	 			sb.append("1 ");
	 		}
	 		else{
	 			sb.append("0 ");
	 		}
	 	}
	 	System.out.println(sb);
	 	
	}
}
