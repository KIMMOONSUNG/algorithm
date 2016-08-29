package SCPC2016_1;

import java.util.Scanner;

public class abc {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int Testcase = sc.nextInt();
	int CASE = 1;
	for(int i =0; i<Testcase; i++){
		long MAX = 1;
		long MIN = 1;
		int t = sc.nextInt();
		long num = 1;
		if(num==0){
			MIN=1;
			MAX=1;
		}
		for(int j=0; j<t; j++){ //최대
		 num=num*2;
		 MAX=num;
		}
		num=1;
		int kk=3;
		long n1=1;
		for(int j=0; j<t; j++){ //최소
		if((num!=1&&num!=4&&(num-1)%3==0)){
			if(num==10){
				n1= num*2;
				kk=1;
			}
			num=(num-1)/3;
		}
		else{
			num=num*2;
		}

		if(n1!=1&&n1!=4&&(n1-1)%3==0){
			n1=(n1-1)/3;
		}
		else{
			if(kk==3){
			n1=n1*2;
			
			}
			kk=3;
		}
		System.out.print("n:"+n1+"//" );
		System.out.println("num:"+num+"//");
		if(n1>num){
			MIN=num;
		}
		else{
			MIN=n1;
		}
	}	
		System.out.println("Case #"+CASE);
		System.out.println(MIN+" "+MAX);
		CASE++;
	}
}
}