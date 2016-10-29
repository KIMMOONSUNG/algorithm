package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11728 { // 머지소트 로품  //arraylist로 collections.sort도 가능// 배열하나로도가능
	                  // Hashset은 시간초과남 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int arr2[] = new int[m];
		st = new StringTokenizer(bf.readLine());
		for(int i =0; i<m; i++){
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		int arr3[] = new int[n+m]; // 두배열 원소 합병할시의 배열. 크기도 합으로 

		int i = 0; //arr 배열 커서 0부터  
		int j = 0; //arr2 배열 커서 0부터
		
		int index = 0;
		
		while(i<n || j<m){ //범위 안에서 arr3에 집어넣는과정임  
			
			if(j>=m || (i<n && arr[i] <= arr2[j])){// j가 범위초과해서 i만남음 즉 arr만남았거나 
				                                   // i가 범위안에있고 arr이 더 작을시 
				arr3[index++] = arr[i++];
			}
			else{ // 그외에는 arr2를 넣는다 
				arr3[index++] = arr2[j++];
			}
		}
		StringBuilder sb= new StringBuilder();
		for(int a =0; a<n+m; a++){
			sb.append(arr3[a]+" ");
		}
		
		System.out.println(sb);
	}
}
