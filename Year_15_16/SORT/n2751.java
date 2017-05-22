package SORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n2751 {// -도 포함됨  절대값이 1000000보다 작거나같지만 -나올시 -부터 출력
	  public static void main(String args[]) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int a = Integer.parseInt(br.readLine());
          int[] arr = new int[2000001];
          for(int i = 0; i < a; i++){
              arr[Integer.parseInt(br.readLine())+1000000]++;
          }
          
          StringBuilder sb = new StringBuilder();
          for(int i = 0; i < 2000001; i++){
              if(arr[i] == 1) sb.append((i-1000000)+"\n");
          }
          
          System.out.println(sb);
      }
}
