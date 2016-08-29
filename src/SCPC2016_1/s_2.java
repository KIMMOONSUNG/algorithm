package SCPC2016_1;

import java.util.Scanner;

public class s_2 {
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int Testcase = sc.nextInt();
	
	long mod = 1000000000L;
    for(int i=0; i<Testcase; i++){
    	int n = sc.nextInt(); // 돌 수
    	int d[] = new int[n];
    	int d2[] = new int[n];
    	int k = sc.nextInt(); // 한번최대이동거리
    	int L = sc.nextInt(); // 지뢰개수
    	int Lnum = 0;
    	if(L>0){
    		for(int a=0; a<L; a++){
    	     Lnum = sc.nextInt(); // 지뢰 돌번호. 인덱스는 -1로 해서 계산
    	   }
    	}
    	for(int a=0; a<n; a++){
    		d[a] = a;
    	}
    	int con=0;
    	int p=0;
    	for(int j=0; j<n; j++){ // 현위치
    		for(p=0; p<n; p+=k){ // 이동거리만큼 이동
    		 if(Lnum!=0&&d[j+p]==Lnum-1)
    		 {
    			 break;
    		 }
    		 if(d[j+p]==d[n-1]){
    			 con=con+1;
    		 }
    		}
    		System.out.println(con);
    		System.out.println("마지막값"+p);
    		for( p=0; p<n; p+=(k-1)){
    			if(k-1<1)
    			{
    				break;
    			}
    		}
    	}

    }
}
}
