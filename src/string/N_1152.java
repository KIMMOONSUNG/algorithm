package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1152 {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int count =0;
		while(st.hasMoreTokens()){
			st.nextToken();
			count++;
		}
		System.out.println(count);
	}	

}
