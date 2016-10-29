package Greedy;

import java.util.Arrays;
import java.util.Scanner;

class aaaaa implements Comparable<aaaaa> {
	int x;
	int y;

	aaaaa(int x, int y) {
		this.x = x;
		this.y = y;
	}
 // y기준 즉 끝나는시간으로 정렬
	public int compareTo(aaaaa c) {
		if (this.y > c.y) {
			return 1;
		} else if (this.y == c.y) {
			if (this.x > c.x) {
				return 1;
			} else if (this.x == c.x) {
				return 0;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}

public class N_1931_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
	    aaaaa[] a=  new aaaaa[T];
		for (int i = 0; i < T; i++) {
			a[i] = new aaaaa(sc.nextInt(),sc.nextInt());
		}
        Arrays.sort(a);
        
		int cnt = 1;
		int endt =a[0].y;
		for (int i = 1; i < T; i++) {
			if (endt <= a[i].x) {
				endt = a[i].y;
				cnt++;
			}
		}
		System.out.println(cnt);

	}
}
