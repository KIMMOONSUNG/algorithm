package SCPC;

import java.util.Scanner;

public class gaguri_D_11060 { // 점프점프
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int jump[] = new int[n+1];
		int d[] = new int[n+1];
		int a =0;
		for (int i = 1; i <=n; i++){
			d[i]= sc.nextInt(); //K
		}
		for(int i =1; i<=n; i++){
			  a = a+d[i];
		      jump[i]=a;
		}
		for(int i =1; i<=n; i++){
			System.out.print(jump[i]+"/"); 
		}
		int count=0;
		int k = d[1];
		int cur = jump[1];
		for(int i=1; i<=n; i++){
			k = d[i]; //최대점프거리바뀜
			if(jump[i]-jump[i-1]>k){
 				count = -1;
 				break;
			}
			if(cur +k < jump[i]){
				cur = jump[i-1];
				count+=1;
			}
		}
		System.out.println(count);
		/*
		//첫시작세팅
		int count = 0;
		int now = 1; // 현위치 (인덱스라생각)
		int k = d[1];//최대점프거리 (for문돌때마다 인덱스증가시키며 바뀜)
		//
	    for (int i =2 ; i<=n ; i++){ //i는 인덱스
	    	if((now + k)<i) // 현위치와 최대점프거리더한것이 그 인덱스가 안될때
	       { 
	    	 System.out.println("now값:"+ now + "k값:"+k +"i값:"+i);	    
	    	 now = i-1;
	    	 count+=1;
	    	 if(k==0){
	    		count=-1;
	    		break;
	    	 }
	       }
	    	k = d[i]; //최대점프거리바뀜
	    }
	    
	    if(count!=-1){
	    	count+= 1;
	    }
	    System.out.println(count);
	    */
	    
  }
}
