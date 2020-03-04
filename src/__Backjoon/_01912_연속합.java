package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _01912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int tempsum = Integer.parseInt(st.nextToken());
		int max = tempsum;
		for (int i = 1; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			tempsum += temp;
			tempsum = Math.max(tempsum, temp);
			max = Math.max(tempsum, max);
		}
		System.out.println(max);
	}
}
