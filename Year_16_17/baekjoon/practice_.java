package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class practice_ {
	static int testcase;
	static int N; //응시자 수  
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	testcase = Integer.parseInt(bf.readLine());
	for(int a=1; a<=testcase; a++){
		N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N];
		int max =0;
		int result =0;
		for(int i =0; i<N; i++){
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);
		int next [] = new int[N];
		for(int i =0; i<N; i++){
			next[i] = arr[i] + (N-i);
			if(next[i]>max){
				max = next[i];
			}
		}
		for(int i =0; i<N; i++){
			if(arr[i]>=(max-N)){
				result++;
			}
		}
		System.out.println("Case #" + a);
		System.out.println(result);
	}
 }
 
}