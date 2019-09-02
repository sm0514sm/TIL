package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1258_행렬찾기 {
	static int[][] arr;

	static class BOX implements Comparable<BOX> {
		int row, col, area;

		public BOX(int row, int col) {
			super();
			this.row = row;
			this.col = col;
			this.area = row * col;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append(row);
			builder.append(" ");
			builder.append(col);
			builder.append(" ");
			return builder.toString();
		}

		@Override
		public int compareTo(BOX arg0) {
			int answer = this.area - arg0.area;
			if (answer == 0)
				answer = this.row - arg0.row;
			return answer;
		}
	}

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1258.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			BOX[] boxes = new BOX[N];
			int boxCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0)
						continue;
					int cntC = 0;
					int temp = j;
					while (arr[i][temp] != 0) {
						cntC++;
						temp++;
						if (temp >= N)
							break;
					}
					int cntR = 0;
					temp = i;
					while (arr[temp][j] != 0) {
						cntR++;
						temp++;
						if (temp >= N)
							break;
					}
					boxes[boxCnt++] = new BOX(cntR, cntC);
					setVisited(i, j, i + cntR - 1, j + cntC - 1);
				}
			}
			BOX[] answerArr = Arrays.copyOf(boxes, boxCnt);
			Arrays.sort(answerArr);
			StringBuilder builder = new StringBuilder();
			builder.append("#");
			builder.append(test_case);
			builder.append(" ");
			builder.append(boxCnt);
			builder.append(" ");
			for (int i = 0; i < boxCnt; i++) {
				builder.append(answerArr[i]);
			}
			builder.append("\n");
			bw.write(builder.toString());
			bw.flush();
		}
	}

	public static void setVisited(int fR, int fC, int tR, int tC) {
		for (int i = fR; i <= tR; i++) {
			for (int j = fC; j <= tC; j++) {
				arr[i][j] = 0;
			}
		}
	}
}
