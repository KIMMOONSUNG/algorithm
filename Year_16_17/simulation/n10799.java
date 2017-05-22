package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
1.여는 괄호가 나오면 스택에 넣는다
2.닫는 괄호가 나오면 스택에서 뺀다 
그때 닫는 괄호 전 이 여는 괄호일 경우 
 남아 있는 스택의 크기만큼 카운트에 더해준다  
그렇지 않을 경우는 카운트 즉  파이프 개수  1개를 더한다

*/
public class n10799 { // 쇠막대기 
	public static void main(String[] args) throws IOException{
		 BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int cnt = 0;
        Stack<Character> sc = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ')') { // 닫는괄호가 나왔을때 
                sc.pop(); // 스택에서 꺼냄 
 
                if(str.charAt(i-1) == '(') { // 그 전이 바로 여는괄호였을 경우 레이저 니까 스택 사이즈만큼 더함.
                    cnt += sc.size();
                }
                
                else { // 그렇지 않을 경우는 쇠막대기 끝 을 나타내는것이므로 1만 더해줌 .
                    cnt += 1;
                }
 
            }
            
            else { // 여는괄호일경우 스택에 더해줌 
                sc.push(ch);
            }
        }
 
        System.out.println(cnt);
    }
}
