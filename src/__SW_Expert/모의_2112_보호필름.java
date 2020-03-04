package __SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모의_2112_보호필름 {
	public static int D, W, K, cnt, answer;
	public static int[][] map, tmp;
	public static int[] numbers, val;
	static boolean[] visited;
	static boolean find;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			answer = 0;
			find = false;
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			tmp = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < D; i++) {
				tmp[i] = map[i].clone();
			}
			if (!possible()) {
				next:
				for (int cnt = 1; cnt <= D; cnt++) {
					for (int i = 0; i < cnt; i++) {
						numbers = new int[cnt];
						combination(i, 0, cnt);
						if(find) break next;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}

	private static boolean possible() {
		next:
		for (int j = 0; j < W; j++) {
			int zero = 0;
			int one = 0;
			for (int i = 0; i < D; i++) {
				if(tmp[i][j] == 0) {
					zero ++;
					one = 0;
				}
				else {
					zero=0;
					one++;
				}
				if(zero == K || one == K) continue next;
				if(zero + D-i < K && one + D-i < K) 
					return false;
			}
			return false;
		}
		return true;
	}

	private static void combination(int before, int index, int cnt) {
		if(find) return;
		if(index == cnt) {
			//System.out.println(Arrays.toString(numbers));
			
			int loopCnt = 1 << cnt;
			for(int i = 0; i < loopCnt; i++) {
				val = new int[cnt];
				for (int ii = 0; ii < D; ii++)	tmp[ii] = map[ii].clone();
				for (int j = 0; j < cnt; j++) {
					if((i & 1 << j) > 0) {
						val[j] = 1;
					}
				}
				for (int num = 0; num < cnt; num++) {
					for (int w = 0; w < W; w++) {
						tmp[numbers[num]][w] = val[num];
					}
				}
				if (possible()) {
					answer = cnt;
					find = true;
					return;
				}
			}
			return;
		}
		for(int i = before + 1; i <= D; i++) {
			if(find) return;
			numbers[index] = i-1;
			combination(i, index + 1, cnt);
		}
	}
}
