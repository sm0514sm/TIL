package ___Essential;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 배열마름모넓이구하기 {
	static int K, arr[][];
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			K = N/2 + 1;
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp.charAt(j) - '0';
				}
			}
			
			answer = get마름모Value(0, K-1);
			
			bw.append(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}

	private static int get마름모Value(int r, int c) {
		int sum = 0;
		int rr = r;
		int cc = c;
		for (int j = 0; j < K; j++) {
			for (int i = 0; i < K; i++) {
				sum += arr[rr+i][cc+i];
			}
			rr++;
			cc--;
		}
		rr = r + 1;
		cc = c;
		for (int j = 0; j < K-1; j++) {
			for (int i = 0; i < K-1; i++) {
				sum += arr[rr+i][cc+i];
			}
			rr++;
			cc--;
		}
		return sum;
	}
	
	/* 옛날 코드 */
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
//			int answer = 0;
//			int N = Integer.parseInt(br.readLine());
//			
//			int start = N/2;
//			int readCount = 1;
//			
//			for(int i=0; i < N/2; i++) {
//				String tempLine = br.readLine();
//				for(int j = 0; j < readCount; j++) 	answer += Integer.parseInt(tempLine.charAt(start + j)+"");
//				start--;
//				readCount += 2;
//			}
//			// 모두 더하기
//			String tempLine = br.readLine();
//			for(int j = 0; j < N; j ++)				answer += Integer.parseInt(tempLine.charAt(j)+"");
//			for(int i=N/2 +1 ; i < N; i++) {
//				readCount -= 2;
//				start++;
//				tempLine = br.readLine();
//				for(int j = 0; j < readCount; j++) 	answer += Integer.parseInt(tempLine.charAt(start + j)+"");
//			}
//			
//			bw.write("#"+test_case+" "+answer+"\n");
//			bw.flush();
//		}
//	}

}
