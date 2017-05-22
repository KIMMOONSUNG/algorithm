package code_plus;

import java.util.HashSet;
import java.util.Scanner;

public class set_N_10815 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<n; i++){
			hs.add(sc.nextInt());
		}
		int m = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<m; j++){
			if(hs.contains(sc.nextInt())){
				sb.append("1 ");
			}
			else{
				sb.append("0 ");
			}
		}
		System.out.println(sb);
		
		
		
	}

}
