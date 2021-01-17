package __Jungol;

import java.util.Scanner;

//Main
public class _2074_홀수마방진 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		arr = new int[N][N];
		fill(0, N / 2, 1);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		sc.close();
	}

	static void fill(int x, int y, int num) {
		if (num > N * N)
			return; // 수가 범위를 벗어나면 종료
		if (x < 0)
			x = N - 1; // x가 0이면 n으로
		else if (x % N == 0)
			x = 0;
		if (y < 0)
			y = N - 1; // y가 0이면 n으로
		arr[x][y] = num; // 배열 채우기
		if (num % N == 0)
			fill(x + 1, y, num + 1); // num이 n의 배수이면 바로 아래 호출
		else
			fill(x - 1, y - 1, num + 1); // 아니면 왼쪽 위 호출
	}

}
