import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10430 {
 public static void main(String[] args) throws IOException {
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String str[] = bf.readLine().split(" ");
	 int n[] = new int[3];
	 n[0] = Integer.parseInt(str[0]);
	 n[1] = Integer.parseInt(str[1]);
	 n[2] = Integer.parseInt(str[2]);
	 System.out.println((n[0]+n[1])%n[2]);
	 System.out.println(((n[0]%n[2]) + (n[1]%n[2]))%n[2]);
		System.out.println((n[0]*n[1])%n[2]);
		System.out.println(((n[0]%n[2])*(n[1]%n[2]))%n[2]);
	/*  
	Scanner sc = new Scanner(System.in);
	int A = sc.nextInt();
	int B = sc.nextInt();
	int C = sc.nextInt();
	System.out.println((A+B)%C);
	System.out.println(((A%C) + (B%C))%C);
	System.out.println((A*B)%C);
	System.out.println(((A%C)*(B%C))%C);
	*/
}
}
