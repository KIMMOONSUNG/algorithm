package DP;
import java.util.Scanner;

public class exam_1 {
	public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int num = sc.nextInt();
       int d[] = new int[1000001]; // 10 의 6승 범위니까
		d[1]=0; //1이면 연산횟수 0
		for(int i=2; i<=num; i++){
			
			d[i]=d[i-1]+1;
			
			if(i%2==0&&d[i]>d[i/2]+1){
				d[i] = d[i/2]+1;
			}
			
			if(i%3==0&&d[i]>d[i/3]+1){
				d[i] = d[i/3]+1;
			}
			
		}
		System.out.println(d[num]);
       
	}
}