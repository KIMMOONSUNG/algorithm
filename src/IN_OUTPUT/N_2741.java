package IN_OUTPUT;

import java.util.Scanner;

//StringBuiider

public class N_2741 { 
	/* 1번째 방법
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
    for(int i =1; i<=N; i++){
    	System.out.println(i);
    }
}
*/
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	StringBuilder sb = new StringBuilder();
	for(int i =1; i<=N; i++){
		sb.append(i+"\n"); //잇고 한칸 띄우고 
	}
	System.out.print(sb);
}

}
