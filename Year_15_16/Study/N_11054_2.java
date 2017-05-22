package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_11054_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int arr[] = new int[n];
		int d1[] = new int[n]; // 앞
		int d2[] = new int[n]; // 뒤
		String st[] = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}

		// 앞
		for (int i = 0; i < n; i++) { // arr 즉 Sk값을 증가시키면서 ..
			d1[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && d1[i] < d1[j] + 1) { // +1해주는거 길이
					d1[i] = d1[j] + 1;
				}
			}
		}

		// 뒤
		for (int i = n - 1; i >= 0; i--) { // arr 즉 Sk값을 감소시키면서..
			d2[i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[i] && d2[i] < d2[j] + 1) {
					d2[i] = d2[j] + 1;
				}
			}
		}
		int result = -1;
		for (int i = 0; i < n; i++) {
			if (result < d1[i] + d2[i] - 1) {
				result = d1[i] + d2[i] - 1;
			}
		}
		System.out.println(result);

	}
}
