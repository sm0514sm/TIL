package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _01592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 사람 수
		int M = Integer.parseInt(st.nextToken());	// 몇번 받으면 끝나는지
		int L = Integer.parseInt(st.nextToken());	// 던지는 개수			// 홀수는 반시계, 짝수는 시계 (index 0부터 할거라서)
		
		int[] receiveCnt = new int[N];
		int receiveIdx = 0;
		int cnt = 0;
		while(true) {
			receiveCnt[receiveIdx]++;	//0번이 받고 시작
			if(receiveCnt[receiveIdx] == M) break;
			cnt++;
			if(receiveCnt[receiveIdx] % 2 ==0) {
				receiveIdx = (receiveIdx + L) % N;
			}
			else {
				receiveIdx = (N + (receiveIdx - L)) % N;
			}
		}
		System.out.println(cnt);
	}
}
