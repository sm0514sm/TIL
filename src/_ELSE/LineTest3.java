package _ELSE;

import java.util.Arrays;
import java.util.Scanner;

//Solution
public class LineTest3 {
	public static class TESTER implements Comparable<TESTER>{
		int start, end;

		public TESTER(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(TESTER o) {
			int val = this.start - o.start;
			if(val == 0)
				val = this.end - o.end;
			return val;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		TESTER[] testers = new TESTER[N];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			testers[i] = new TESTER(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(testers);
		int end = testers[0].end;
		for (int i = 0; i < N; i++) {
			if(testers[i].start >= end) {
				end = Math.min(testers[i].end, end);
			}
			else {
				cnt++;
				end = Math.min(testers[i].end, end);
			}
		}
		System.out.println(cnt);
			
	}
}
