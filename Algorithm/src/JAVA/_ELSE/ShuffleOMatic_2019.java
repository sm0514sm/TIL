package _ELSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShuffleOMatic_2019 {
	static int[] arr, testArr, order, left, right;
	static int N, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			answer = 10000;
			arr = new int[N];
			left = new int[N/2];
			right = new int[N/2];
			order = new int[5];
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			left = Arrays.copyOfRange(arr, 0, N/2);
			right = Arrays.copyOfRange(arr, N/2, N);
			if(isINC() || isDEC())
				answer = 0;
			else
				P(0);
			if(answer == 10000)
				answer = -1;
			System.out.println("#" + testCase + " " + answer);
		}
	}
	
	public static void P(int index) {
		if(index == 5) {
			testArr = Arrays.copyOf(arr, N);
			left = Arrays.copyOfRange(arr, 0, N/2);
			right = Arrays.copyOfRange(arr, N/2, N);
			for(int i = 1; i <= 5; i++) {
				if(order[i-1] == 0) continue;
				doSuffle(order[i-1]);
				if(isINC() || isDEC()) {
					answer = Math.min(answer, i);
					break;
				}
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			order[index] = i;
			P(index+1);
		}
	}

	private static boolean isDEC() {
		for(int i = 0; i < N/2; i++)	if(left[i] != N - i)		return false;
		for(int i = 0; i < N/2; i++)	if(right[i] != N - i - N/2)	return false;
		return true;
	}

	private static boolean isINC() {
		for(int i = 0; i < N/2; i++)	if(left[i] != i+1)			return false;
		for(int i = 0; i < N/2; i++)	if(right[i] != i+1 + N/2)	return false;
		return true;
	}

	private static void doSuffle(int index) {
		int size = N*2-2;
		int[] tempArr = new int[size];
		
		for(int i = 0; i < N ;i+=2)	tempArr[i+index] 		= left[i/2];
		for(int i = 0; i < N ;i+=2)	tempArr[size/2-index+i] = right[i/2];
		
		int idx = 0;
		for(int i = 0; i < tempArr.length; i++) {
			if(tempArr[i] != 0)	testArr[idx++] = tempArr[i];
		}
		left  = Arrays.copyOfRange(testArr, 0, N/2);
		right = Arrays.copyOfRange(testArr, N/2, N);
	}
}

/*
5
4
1 2 3 4
4
4 2 3 1
6
6 6 5 4 2 3 1
8
6 1 4 7 2 5 8 3
12
2 7 4 1 3 5 8 10 12 9 6 11

 * */
