package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class n11723 { // 집합 -> syso로 출력 ->시간초과 // BufferedWriter로 출력 해야 시간초과 안남 
	static int testcase;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = 
	            new BufferedWriter(new OutputStreamWriter(System.out));
		testcase = Integer.parseInt(bf.readLine());
		
		TreeSet<Integer> ts = new TreeSet<>();

		for (int i = 0; i < testcase; i++) {
			String order[] = bf.readLine().split(" ");
			if (order[0].equals("add")) {
				int num = Integer.parseInt(order[1]);
				if (!ts.contains(num))
					ts.add(num);
			} else if (order[0].equals("remove")) {
				int num = Integer.parseInt(order[1]);
				if (ts.contains(num))
					ts.remove(num);
			} else if (order[0].equals("check")) {
				int num = Integer.parseInt(order[1]);
				if (ts.contains(num))
					bw.write("1\n");
				else {
					bw.write("0\n");
				}
			} else if (order[0].equals("toggle")) {
				int num = Integer.parseInt(order[1]);
				if (ts.contains(num))
					ts.remove(num);
				else
					ts.add(num);
			} else if (order[0].equals("all")) {
				ts.clear();
				for (int j = 0; j < 20; j++) {
					ts.add(j + 1);
				}
			} else
				ts.clear();

		}
		bw.close();
	}
	/*7
	add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
	remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
	check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
	toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
	all: S를 {1, 2, ..., 20} 으로 바꾼다.
	empty: S를 공집합으로 바꾼다. 
	*/
}
