package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Main
public class _08958_OX퀴즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int answer = 0;
			String OX = br.readLine();
			int cnt = 0;
			for (int i = 0; i < OX.length(); i++) {
				if(OX.charAt(i) == 'O') {
					cnt++;
					answer+=cnt;
				}
				else
					cnt = 0;
			}
			System.out.println(answer);
		}
	}
}
