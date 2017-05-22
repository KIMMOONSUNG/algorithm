package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n11728_2 { // 걍 배열 하나에 풀었음 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        int arr[] = new int[n+m];
        int i ;
        st = new StringTokenizer(bf.readLine());
        for(i =0; i<n; i++){
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for(int j=i; j<n+m; j++){ // i부터 그다음 배열 인덱스에 저장
        	arr[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int a =0; a<n+m; a++){
        	sb.append(arr[a]+" ");
        }
        System.out.println(sb);
        
	}
}
