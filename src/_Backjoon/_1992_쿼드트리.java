package _Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992_쿼드트리 {
	static int[][] arr = null;

	// 백준은 Main
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = null;
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = br.readLine();
			for (int j = 0; j < N; j++)
				arr[i][j] = st.charAt(j) - '0';
		}
		System.out.println(doit(0, 0, N));

	}

	private static String doit(int row, int col, int n) {
		if(n == 1) return arr[row][col] + "";
		
		boolean isAllOne  = true;
		boolean isAllZero = true;
		for(int i = row; i < n + row; i++) {
			for(int j = col; j < n + col; j++) {
				if(arr[i][j] == 0)	isAllOne  = false;
				if(arr[i][j] == 1)	isAllZero = false;
			}
		}
		if(isAllOne)  return "1";
		if(isAllZero) return "0";
		
		String answer = "";
		answer += "("+doit(row, col, n/2);
		answer += doit(row, col + n/2, n/2);
		answer += doit(row + n/2, col, n/2);
		answer += doit(row + n/2, col + n/2, n/2)+")";
		return answer; 
	}
}
