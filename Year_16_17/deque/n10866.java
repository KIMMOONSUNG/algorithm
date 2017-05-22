package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/
public class n10866 { // 덱 
  public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	Deque<Integer> dq = new LinkedList<>();
	
	for(int i =0; i<n; i++){
	 StringTokenizer st=  new StringTokenizer(bf.readLine());
	 String str = st.nextToken();
	 if(str.equals("push_back")){
		 dq.addLast(Integer.parseInt(st.nextToken()));
	 }
	 else if(str.equals("push_front")){
		 dq.addFirst(Integer.parseInt(st.nextToken()));
	 }
	 else if(str.equals("pop_back")){
		 if(dq.isEmpty()){
			 System.out.println(-1);
		 }
		 else{
		 System.out.println(dq.pollLast());
		 }
	 }
	 else if(str.equals("pop_front")){
		 if(dq.isEmpty()){
			 System.out.println(-1);
		 }
		 else{
		 System.out.println(dq.pollFirst());
		 }
	 }
	 
	 else if(str.equals("size")){
		 System.out.println(dq.size());
	 }
	 else if(str.equals("empty")){
		 if(dq.isEmpty()){
			 System.out.println(1);
		 }
		 else{
			 System.out.println(0);
		 }
	 }
	 else if(str.equals("front")){
		 if(dq.isEmpty()){
			 System.out.println(-1);
		 }else{
		 System.out.println(dq.peekFirst());
		 }
	 }
	 else if(str.equals("back")){
		 if(dq.isEmpty()){
			 System.out.println(-1);
		 }else{
		 System.out.println(dq.peekLast());
		 }
	 }
	 else{
		 
	 }
	}
}
}
