import java.util.Scanner;

public class dpN2579_1 {
	static int memo[] ;
	static int array[] ;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int step = sc.nextInt();
		array = new int[step + 1];	
	    memo = new int[step + 1];
		for (int i = 1; i < step+1; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println(steps(step));
	}
	
	public static int steps(int n){
		memo[1] = array[1];
		memo[2] = array[1] + array[2];
		for (int i = 3; i <n+1; i++) {
			memo[i] = array[i] + memo[i - 2];
			if ((array[i] + array[i - 1] + memo[i - 3]) > memo[i])
				memo[i] = array[i] + array[i - 1] + memo[i - 3];
		}
		return memo[n];
	}
}
