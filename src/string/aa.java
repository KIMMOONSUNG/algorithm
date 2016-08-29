package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class aa {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine());
			int rank[] = new int[N+1];
			int index =0;
			int min =0;
			for(int j=1; j<=N; j++){
				String str[] = bf.readLine().split(" ");
				index = Integer.parseInt(str[0]);
				rank[index] = Integer.parseInt(str[1]);
			}
			int cnt =1;
             min = rank[1];
             for(int j=2; j<=N; j++){
            	 if(rank[j]<min){
            		 cnt++;
            		 min = rank[j];
            	 }
             }
             System.out.println(cnt);
		}
	}
}
