package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class n1021 { // 회전하는 큐.
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			deque.offerLast(i); //뒤부터 넣고 
		}

		int totalCnt = 0;
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < m; i++) {
			int key = Integer.parseInt(st.nextToken()) ;
			int cnt = 0;
			while (deque.peekFirst()!= key) {
				deque.offerLast(deque.pollFirst());
				cnt++;
			}
			if (cnt > deque.size() / 2){ //조건 2번을 했는데 카운트 값이 덱 사이즈의 반을 넘어간 경우는 3번조건 만족하면 되므로 
				
				cnt = deque.size() - cnt; // 3번조건은 덱 사이즈에서 카운트 값 뺴면 됨..
			}
			deque.pollFirst();
			totalCnt += cnt;
		}

		System.out.println(totalCnt);
	}

}
