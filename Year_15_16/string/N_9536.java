package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_9536 { //여우
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(bf.readLine());
		for (int a = 0; a < num; a++) {
			int cnt = 0;
			String arr[][] = new String[100][2];
			StringTokenizer st = new StringTokenizer(bf.readLine().trim());
			while (st.hasMoreTokens()) {
				arr[cnt][0] = st.nextToken();
				cnt++;
			}
			while (true) {
				st = new StringTokenizer(bf.readLine().trim());
				if (st.nextToken().equals("what")) {
					break;
				}
				st.nextToken();
				String str = st.nextToken().toString();
				for (int i = 0; i < cnt; i++) {
					if (arr[i][0].equals(str)) {
						arr[i][1] = "G";
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cnt; i++) {
				if (arr[i][1] != "G") {
					sb.append(arr[i][0] + " ");
				}
			}
			System.out.println(sb);
		}
	}
}
