package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem {
	static int n;
    static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			arr = new int[n];
			for(int i =0; i<n; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			func("",0,0);
		}
		
	}
	static void func(String num , int count, int index){
		
		if(count>=n){
			return;
		}
		if(count==6){
			System.out.println(num);
			return;			
		}
		if(index>=n){
			return;
		}
		
		func(num+arr[index]+" ", count+1, index+1);
		func(num, count , index+1);
		
	}

}