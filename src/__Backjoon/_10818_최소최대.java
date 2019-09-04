package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _10818_최소최대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int min = 1000000;
		int max = -1000000;
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			min = Math.min(min, val);
			max = Math.max(max, val);
		}
		System.out.println(min + " " + max);
	}
}
