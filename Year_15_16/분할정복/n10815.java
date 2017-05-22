package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n10815 { //이분탐색 //or set
 public static void main(String[] args) throws IOException{
  BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(bf.readLine());
  StringTokenizer st = new StringTokenizer(bf.readLine());
  int num[] = new int[n];
  for(int i =0; i<n; i++){
	  num[i] = Integer.parseInt(st.nextToken());
  }
  Arrays.sort(num); //이분탐색할때 핵심은 정렬이 되어있어야한다 !!!!
  int m = Integer.parseInt(bf.readLine());
  st = new StringTokenizer(bf.readLine());
  StringBuilder sb = new StringBuilder();
  for(int i =0; i<m; i++){
	  int number = Integer.parseInt(st.nextToken());
	  boolean result = binary_search(num,number);
	  if(result==true){
		  sb.append("1 ");
	  }
	  else{
		  sb.append("0 ");
	  }
  }
  System.out.println(sb);
}
 static boolean binary_search(int a[], int number) {
     int n = a.length;
     int left = 0;
     int right = n-1;
     while (left <= right) {
         //int mid = (left+right)/2;
         int mid = left +(right - left)/2; // 나중에 오버플로우안나기위해
         if (a[mid] == number) {
             return true;
         } else if (a[mid] > number) {
             right = mid-1;
         } else {
             left = mid+1;
         }
     }
     return false;
 }
 
}
