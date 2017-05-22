package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2965 { // 캥거루세마리
 public static void main(String[] args) throws IOException{
	 // 가장 큰 수와 중간 수의 차와 중간수와 처음수의 차이 중 큰수에서 작은 수를 뺀거에 -1 해주면 답.
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int e = Math.max(Math.max(a,b), c);
    int s = Math.min(Math.min(a,b), c);
    int m = a+b+c - e - s;
    System.out.println(Math.max(e-m, m-s)-1);
   }
 
}
