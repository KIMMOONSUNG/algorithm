package set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class n10815 { //set// 또는 이분탐색 or 배열 
	public static void main(String[] args) throws IOException{
		BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<Integer>();
		 int n = Integer.parseInt(bf.readLine());
		 StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i =0; i<n; i++){
		 hs.add(Integer.parseInt(st.nextToken()));
		}
		 int m = Integer.parseInt(bf.readLine());
		 st = new StringTokenizer(bf.readLine());
		 StringBuilder sb = new StringBuilder();
		for(int i =0; i<m; i++){
			int num = Integer.parseInt(st.nextToken());
		 if(hs.contains(num)){
			 sb.append("1 ");
		 }
		 else{
			 sb.append("0 ");
		 }
		}
		

		System.out.println(sb);
	 }
}
