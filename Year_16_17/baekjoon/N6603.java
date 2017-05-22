package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6603 { // 로또 -> 백트래킹
static int printArr[] = new int [6];
static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int arr[ ] = new int [13];
		
		while (true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			for (int i = 0; i < k; i++) {
               arr[i] = Integer.parseInt(st.nextToken());
			}
               func(arr,0,0);
               System.out.println();
			
		}
		
	}
	
	static void func(int arr[], int idx, int count) {
		
        if(count == 6) { // 개수 6 채워지면 - > 출력 //리턴 
            print();
            return;
        }

        if(idx >= k) // 인덱스가 배열크기 이상이면 -> 리턴 
            return;

        printArr[count] = arr[idx];
        func(arr, idx+1, count+1); //해당 인덱스 숫자 선택했을 때 
        func(arr, idx+1, count);   //숫자 선택 안했을 때 
        
    }
	
	static void print() {
        for(int i = 0; i < 6; i++)
            System.out.print(printArr[i] + " ");
        System.out.println();
    }
	
}
