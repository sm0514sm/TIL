package __SW_Expert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_4014_활주로건설 {
	static int map[][];
	static int N, X, cnt;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			cnt = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				} 
			}
			nextLine:
			for (int i = 0; i < N; i++) {
				boolean 활주로[] = new boolean[N];
//				>> 검사
				int needCnt = X-1;
				int val = map[i][0];
				for (int j = 1; j < N; j++) {
					if(Math.abs(map[i][j] - val) >= 2)	continue nextLine;
					else if(map[i][j] == val) {
						needCnt--;
						continue;
					}
					else if(map[i][j] > val) {
						if(needCnt <= 0) {
							val = map[i][j];
							needCnt = X - 1;
							// 활주로 건설
							for (int k = 1; k <= X; k++) 활주로[j-k] = true;
						}
						else continue nextLine;
					}
					else if(map[i][j] < val){
						needCnt = X - 1;
						val = map[i][j];
					}
				}
//				<< 검사
				needCnt = X-1;
				val = map[i][N-1];
				for (int j = N-2; j >= 0; j--) {
					if(Math.abs(map[i][j] - val) >= 2) continue nextLine;
					else if(val == map[i][j]) {
						needCnt--;
						continue;
					}
					else if(map[i][j] > val) {
						if(needCnt <= 0) {
							// 활주로 건설 가능 여부 검사
							for (int k = 1; k <= X; k++)
								if(활주로[j+k]) continue nextLine;
							val = map[i][j];
							needCnt = X - 1;
						}
						else continue nextLine;
					}
					else if(map[i][j] < val) {
						val = map[i][j];
						needCnt = X - 1;
					}
				}
				cnt++;
			}
//			/////////////////////
			nextLine:
			for (int j = 0; j < N; j++) {
				boolean 활주로[] = new boolean[N];
//				아래 검사
				int needCnt = X-1;
				int val = map[0][j];
				for (int i = 1; i < N; i++) {
					if(val == map[i][j]) {
						needCnt--;
						continue;
					}
					else if(Math.abs(map[i][j] - val) >= 2)	continue nextLine;
					else if(map[i][j] > val) {
						if(needCnt <= 0) {
							val = map[i][j];
							needCnt = X - 1;
							// 활주로 건설
							for (int k = 1; k <= X; k++) 활주로[i-k] = true;
						}
						else {
							needCnt = X - 1;
							continue nextLine;
						}
					}
					else {
						needCnt = X - 1;
						val = map[i][j];
					}
				}
//				위 검사
				needCnt = X-1;
				val = map[N-1][j];
				for (int i = N-2; i >= 0; i--) {
					if(Math.abs(map[i][j] - val) >= 2) {
						needCnt = X-1;
						continue nextLine;
					}
					else if(val == map[i][j]) {
						needCnt--;
						continue;
					}
					else if(map[i][j] > val) {
						if(needCnt <= 0) {
							// 활주로 건설 가능 여부 검사
							for (int k = 1; k <= X; k++)
								if(활주로[i+k]) continue nextLine;
							val = map[i][j];
							needCnt = X - 1;
						}
						else continue nextLine;
					}
					else if(map[i][j] < val){
						val = map[i][j];
						needCnt = X - 1;
					}
				}
				cnt++;
			}
			
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
