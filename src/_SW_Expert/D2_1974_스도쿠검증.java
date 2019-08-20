package _SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D2_1974_스도쿠검증 {
	static int arr[][];
	static boolean isCorrect;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			isCorrect = true;
			int answer = 0;
			arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if(isCorrect)	verifySquare();
			if(isCorrect)	verifyRow();
			if(isCorrect)	verifyCol();
			
			
			if(isCorrect)
				System.out.printf("#%d 1\n", test_case);
			else
				System.out.printf("#%d 0\n", test_case);
				
		}
	}
	private static boolean sumSqu45(int i, int j) {
		int sum = 0;
		for(int row = i; row < i + 3; row++) {
			for(int col = j; col < j + 3; col++) {
				sum += arr[row][col];
			}
		}
		if(sum == 45) return true;
		else return false;
	}
	
	private static void verifySquare() {
		if(!sumSqu45(0, 0)) { isCorrect = false; return; }
		if(!sumSqu45(3, 0)) { isCorrect = false; return; }
		if(!sumSqu45(6, 0)) { isCorrect = false; return; }
		if(!sumSqu45(0, 3)) { isCorrect = false; return; }
		if(!sumSqu45(3, 3)) { isCorrect = false; return; }
		if(!sumSqu45(6, 3)) { isCorrect = false; return; }
		if(!sumSqu45(0, 6)) { isCorrect = false; return; }
		if(!sumSqu45(3, 6)) { isCorrect = false; return; }
		if(!sumSqu45(6, 6)) { isCorrect = false; return; }
	}

	private static boolean sumRow45(int i) {
		int sum = 0;
		for(int j = 0; j < 9; j++) {
			sum += arr[i][j];
		}
		if(sum == 45) return true;
		else return false;
	}
	
	private static void verifyRow() {
		for(int i = 0; i < 9 ; i++) {
			if(!sumRow45(i)) {
				isCorrect = false; return;
			}
		}
	}
	
	private static boolean sumCol45(int i) {
		int sum = 0;
		for(int j = 0; j < 9; j++) {
			sum += arr[j][i];
		}
		if(sum == 45) return true;
		else return false;
	}

	private static void verifyCol() {
		for(int i = 0; i < 9 ; i++) {
			if(!sumCol45(i)) {
				isCorrect = false; return;
			}
		}
	}
}
