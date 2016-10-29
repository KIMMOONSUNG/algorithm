package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2331_2 {
	static int check[] = new int[1000000]; // 0 이 아니면 이미 왔던 수 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int cnt = 1;
		int next = 0;
		while (check[a] == 0) {
			check[a] = cnt;
			int ans = 0;
			while (a > 0) {
				ans += pow(a % 10, p);
				a = a / 10;
			}
			next = ans;
			a = next;
			cnt++;
		}
		System.out.println(check[a] - 1);
	}

	static int pow(int x, int p) {
		int ans = 1;
		for (int i = 0; i < p; i++) {
			ans = ans * x;
		}
		return ans;
	}
}
