package DP;

import java.util.Scanner;

public class D_1912{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);       
        int n=sc.nextInt();
        int[] a = new int[n];
        int[] d =new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        max=a[0];
        d[0]=a[0];
        for(int i=1;i<n;i++){  
        	d[i]=d[i-1]+a[i]; // 
            if(a[i]>=d[i-1]+a[i]){ // 더해져온값 + 현재값이 현재값보다 작거나 같을경우에는 그냥 현재값을 넣어버림   
                d[i]=a[i];
            } 
        }   
        for(int i=0;i<n;i++){
             
            if(max<=d[i]){
                max=d[i];
            }
        }   
        System.out.println(max);   
    }
}