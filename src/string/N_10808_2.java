package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10808_2 {
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	char str[] = bf.readLine().toCharArray();
	int arr[] = new int[26];
	for(int i =0; i<str.length; i++){
	   arr[str[i]-97] +=1;
	}
	StringBuilder sb = new StringBuilder();
	for(int i =0; i<arr.length; i++){
		sb.append(arr[i]+" ");
	}
	System.out.println(sb);
}
}
