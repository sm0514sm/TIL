package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _01011_FlymetotheAlphaCentauri {
	static int to, min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			min = 1000000;
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			to -= from + 1;
			doit(0, to, 1);
			System.out.println(min);
		}
		
	}
	private static void doit(int move, int remain, int cnt) {
		if(remain == 0) {
			min = Math.min(min, cnt);
			return;
		}
		else if(remain < 0) return;
		for(int i = move - 1; i <= move + 1; i++) {
			if(i <= 0) continue;
			doit(i, remain - i, cnt+1);
		}
	}
}
