package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _05565_영수증 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = Integer.parseInt(br.readLine());
		for (int i = 0; i < 9; i++) {
			sum -= Integer.parseInt(br.readLine());
		}
		System.out.println(sum);
	}
}
