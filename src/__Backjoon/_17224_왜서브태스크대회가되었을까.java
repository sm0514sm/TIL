package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _17224_왜서브태스크대회가되었을까 {
	static class prob implements Comparable<prob>{
		int easy, hard;

		public prob(int easy, int hard) {
			super();
			this.easy = easy;
			this.hard = hard;
		}

		@Override
		public int compareTo(prob o) {
			int result = hard - o.hard;
			if(result == 0)
				result = easy - o.easy;
			return result;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//문제의 개수
		int L = Integer.parseInt(st.nextToken());	//현정이의 역량
		int K = Integer.parseInt(st.nextToken());	//풀 수 있는 문제 수
		int ans = 0;
		int k = 0;
		prob[] prob = new prob[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int easy = Integer.parseInt(st.nextToken());
			int hard = Integer.parseInt(st.nextToken());
			prob[i] = new prob(easy, hard);
		}
		Arrays.sort(prob);
		for (int i = 0; i < N; i++) {
			if(L >= prob[i].hard && k < K) {
				ans += 140;
				k++;
			}
			else if(L >= prob[i].easy && k < K) {
				ans += 100;
				k++;
			}
		}
		System.out.println(ans);
	}
}
