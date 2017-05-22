package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_6603 { // 6603_1 로 푸셈 
	static int arr[] = new int [13];
	static int printarr[] = new int [6];
	static int k;
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	while(true){
		StringTokenizer st = new StringTokenizer(bf.readLine());
		k = Integer.parseInt(st.nextToken());
		if(k==0){
			break;
		}
		for(int i =0; i<k; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0,0);
		System.out.println();
	}
 }
 
 static void func(int index , int count){
	 if(count == 6){ // 개수가 6이면 출력 하고 리턴 
		 print();
		 return;
	 }
	 if(index >=k){ //인덱스가 배열 크기 이상이면 리턴 
		 return;
	 }
	 printarr[count] = arr[index]; 
	 func(index+1,count+1); // 해당인덱스 숫자를 선택했을 
	 func(index+1,count); // 해당인덱스 숫자를 선택 안했을 때
 }
 
 static void print(){
	 for(int i =0; i<6; i++){
		 System.out.print(printarr[i]+" ");
	 }
	 System.out.println();
 }
 
}
