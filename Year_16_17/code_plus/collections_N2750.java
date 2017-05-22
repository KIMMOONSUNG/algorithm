package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class collections_N2750 {
	
	/*
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); 
    int T = sc.nextInt();
    int arr[] = new int[T];
    for(int i =0; i<T; i++){
    	arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    for(int i =0; i<T; i++){
     System.out.println(arr[i]);
    }
}
*/ 

 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(bf.readLine());
	//StringBuilder sb= new StringBuilder();
	int text[] = new int[t];
	
	for(int i =0; i<t; i++){
		text[i] = Integer.parseInt(bf.readLine());
		//sb.append(text[i] +" "); //입력이 엔터 누르고 하는거라 필요없음
	}
	
	Arrays.sort(text);
	for(int i =0; i<t; i++){
		System.out.println(text[i]);
	}
}
 
	/*
	public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n =sc.nextInt();
     ArrayList<Integer> arr = new ArrayList<Integer>();
     for(int i =0; i<n; i++){
    	 int t = sc.nextInt();
         arr.add(t);
     }
     Collections.sort(arr);
     for(int i=0; i<n; i++){
    	 System.out.println(arr.get(i));
     }
	}*/
	
	/*
	public static void main(String[] args)throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int n = Integer.parseInt(bf.readLine());
		for(int i =0; i<n; i++){
			arr.add(Integer.parseInt(bf.readLine()));// 엔터로 넘어가니까 배열하나하나에 드러감
		}
		Collections.sort(arr);
		for(int i =0; i<n; i++){
			System.out.println(arr.get(i));
		}
	}
	*/
}
