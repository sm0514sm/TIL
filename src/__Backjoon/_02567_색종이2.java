package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _02567_색종이2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					arr[j][k]=1;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			boolean iswhite = true;
			for (int j = 0; j < 101; j++) {
				if(arr[i][j] == 1 && iswhite) {
					answer++;
					iswhite = false;
				}
				else if(arr[i][j] == 0) {
					iswhite = true;
				}
			}
			iswhite = true;
			for (int j = 100; j >= 0; j--) {
				if(arr[i][j] == 1 && iswhite) {
					answer++;
					iswhite = false;
				}
				else if(arr[i][j] == 0) {
					iswhite = true;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			boolean iswhite = true;
			for (int j = 0; j < 101; j++) {
				if(arr[j][i] == 1 && iswhite) {
					answer++;
					iswhite = false;
				}
				else if(arr[j][i] == 0) {
					iswhite = true;
				}
			}
			iswhite = true;
			for (int j = 100; j >= 0; j--) {
				if(arr[j][i] == 1 && iswhite) {
					answer++;
					iswhite = false;
				}
				else if(arr[j][i] == 0) {
					iswhite = true;
				}
			}
		}
		System.out.println(answer);
		
	}
}
