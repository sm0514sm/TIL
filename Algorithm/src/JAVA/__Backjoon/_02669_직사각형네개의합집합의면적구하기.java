package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _02669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int answer = 0;
		int[][] arr = new int[101][101];
		for(int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			int fromX = Integer.parseInt(st.nextToken())+1; 
			int fromY = Integer.parseInt(st.nextToken())+1; 
			int toX = Integer.parseInt(st.nextToken()); 
			int toY = Integer.parseInt(st.nextToken()); 
			for(int x = fromX; x <= toX; x++) {
				for(int y = fromY; y <= toY; y++) {
					arr[x][y] = 1;
				}
			}
		}
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(arr[i][j] == 1)
					answer++;
			}
		}
		System.out.println(answer);
		
		
	}
}
