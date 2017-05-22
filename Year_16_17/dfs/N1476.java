package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1476 { // 날짜 
public static void main(String[] args) throws IOException{
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int E = Integer.parseInt(st.nextToken()); //1 ~ 15
	int S = Integer.parseInt(st.nextToken());//1 ~ 28
	int M = Integer.parseInt(st.nextToken()); // 1~ 19
	int e=0,s=0,m=0;
	int cnt =0;
	while(true){
		
		if(E==e && S==s && M==m){
			break;
		}
		cnt++;
		e++;s++;m++;
		if(e>15){
			e = 1;
		}
		if(s>28){
			s=1;
		}
		if(m>19){
			m=1;
		}
	}
	System.out.println(cnt);
	
}
}
