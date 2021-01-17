package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _07568_덩치 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int[][] people = new int[N][2];
		arr = new int[N];
		Arrays.fill(arr, 1);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.parseInt(st.nextToken()); 
			people[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		for (int i = 0; i < people.length; i++) {
			for (int j = 0; j < people.length; j++) {
				if(i == j) continue;
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1])
					arr[i]++;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
