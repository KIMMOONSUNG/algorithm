package code_plus;

import java.util.*;

//스택 
public class collections_N10828 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		sc.nextLine(); // 정수 뒤에 빈칸이 있어서 필요합니다
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			String[] s = str.split(" ");
			String cmd = s[0];
			if (cmd.equals("push")) { //집어넣는거
				int num = Integer.parseInt(s[1]);
				stack.push(num);
			} 
			else if (cmd.equals("top")) { // 가장위에있는거확인 
				if (stack.empty()) {
					System.out.println("-1");
				} else {
					System.out.println(stack.peek());
				}
			} 
			else if (cmd.equals("size")) { //size
				System.out.println(stack.size());
			} 
			else if (cmd.equals("empty")) { // 비었는지 
				if (stack.empty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} 
			else if (cmd.equals("pop")) { //빼네는거 
				if (stack.empty()) {
					System.out.println("-1");
				} else {
					System.out.println(stack.pop());
				}
			}
		}
	}
}
