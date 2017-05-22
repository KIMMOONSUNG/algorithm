package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_1026 { // 보물
	public static void main(String[] args)throws IOException {
	BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());	
	int a[] = new int[n];
	int b[] = new int[n];
	String str[] = bf.readLine().split(" ");
	String str2[] = bf.readLine().split(" ");
	// a 정렬 b정렬  a 첫인덱스와 b마지막인덱스 곱해서 a 인덱스는증가 b인덱스는 감소 이렇게 곱해서 쭊쭊 더해나감 
	for(int i =0; i<n; i++){
	  a[i] = Integer.valueOf(str[i]);
	  b[i] = Integer.parseInt(str2[i]);
	}
	Arrays.sort(a);
	Arrays.sort(b);
	int k =n-1;
	int sum =0;
    for(int i =0; i<n; i++){
    	sum += (a[i]*b[k]);
    	k--;
    }
    System.out.println(sum);
	
  }
}
