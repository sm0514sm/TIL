package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _02798_블랙잭 {
	static int N, M, difmin, ans;
	static int[] arr;
	static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		difmin = 300000;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		order = new int[3];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		combi(-1, 0);
		System.out.println(ans);
	}
	private static void combi(int before, int index) {
		if(index == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++)
				sum += arr[order[i]];
			if(sum > M) return;
			else {
				if(difmin > M - sum) {
					ans = sum;
					difmin = M - sum;
				}
			}
			return;
		}
		for (int i = before + 1; i < N; i++) {
			order[index] = i;
			combi(i, index + 1);
		}
	}
}
