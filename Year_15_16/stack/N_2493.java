package stack;

import java.util.Scanner;
import java.util.Stack;

public class N_2493 { // 스텍  / 탑
 public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
      Stack<Integer> st = new Stack<Integer>();
      int N = sc.nextInt();
      int[] height = new int[N+1];
      int[] result = new int[N+1];
              
      for(int i=1;i<=N;i++){
          height[i] = sc.nextInt();
      }
 
      for(int i=N;i>0;i--){
          while(!st.isEmpty() && height[st.peek()] < height[i]){
              result[st.pop()] = i;
          }
          st.push(i);
      }      
      for(int i=1;i<=N;i++){
          System.out.print(result[i]+" ");
      }
  }
 
 //////////////////////////////////////////////////
 /*
 static int n;
 static int[] height;
 static Stack<Integer> Q = new Stack<Integer>();
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     StringBuilder sb = new StringBuilder();
     n = sc.nextInt();
     height = new int[n];
      
     for(int i=0; i<n; i++)
         height[i] = sc.nextInt();
      
     for(int i=0; i<n; i++) {
         while(!Q.isEmpty() && height[Q.peek()] < height[i])
             Q.pop();
         if(Q.isEmpty()) sb.append("0 ");
         else sb.append(Q.peek()+1+" ");
         Q.push(i);
     }
      
     System.out.println(sb);
     sc.close();
 }
 */
 /////////////////////////////////
}
 
