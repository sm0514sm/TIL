package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _10250_ACM호텔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int H, W, N;
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int xx = N / H + 1;
			if(N%H == 0)
				xx -= 1;
			int yy = N % H == 0 ? H : N % H;
			String strXX = xx + "";
			if (strXX.length() == 1)
				strXX = "0" + strXX;
			System.out.println(yy + strXX);
		}
	}
}
