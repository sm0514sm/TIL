package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _03985_롤케이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int L = Integer.parseInt(br.readLine());	// 롤케이크 길이
		int N = Integer.parseInt(br.readLine());	// 방청객 수
		int[] Roll = new int[L+1];
		int maxExpectWho = 0;
		int maxExpectVal = 0;
		int maxRealWho = 0;
		int maxRealVal = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if(maxExpectVal < K-P) {
				maxExpectVal = K-P;
				maxExpectWho = i;
			}
			int val = 0;
			for (int j = P; j <= K; j++) {
				if(Roll[j] == 0) {
					Roll[j] = i;
					val++;
				}
			}
			if(val > maxRealVal) {
				maxRealVal = val;
				maxRealWho = i;
			}
		}
		System.out.println(maxExpectWho);
		System.out.println(maxRealWho);
	}
}
