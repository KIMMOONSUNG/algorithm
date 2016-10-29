package code_plus;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sort_N11651_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for(int i =0; i<n; i++){
        	arr[i][0] = sc.nextInt();
        	arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int []>(){
        	public int compare(int a[] , int b[]){
        		if(a[1]>b[1]){
        			return 1;
        		}
        		else if(a[1]==b[1]){
        			if(a[0]>b[0]){
        				return 1;
        			}
        			else if(a[0]==b[0]){
        				return 0;
        			}
        			else{
        				return -1;
        			}
        		}
        		else{
        			return -1;
        		}
        	}
        });
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
        	sb.append(arr[i][0]+" "+arr[i][1]);
        	sb.append("\n");
        }
        System.out.println(sb);
	}

}
