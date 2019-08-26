package __Jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*	시간초과남
 * 	쌤 풀이방식으로는 인접배열의 유향 그래프를 이용해 표시함
 * 	"강의필기/문제풀이/정올_1515_구슬찾기.md" 확인
 * 
 */




public class _1515_구슬찾기 {
	static int[] arr;		// 1, 2, 3, 4, ... 와 같이 저장됨
	static int[][] order;	// order[i][0] < order[i][1] 을 만족해야함
	static boolean[] ismid;	// 해당 값이 중앙값이 될 수 있다면 true
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ismid = new boolean[N];
		order = new int[M][2];

		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][1] = Integer.parseInt(st.nextToken()); // 순서 거꾸로 받음!
			order[i][0] = Integer.parseInt(st.nextToken());
		}/*-----데이터 입력 완료------*/
		
		
		do {
			if (ismid[arr[N / 2] - 1])	// 해당 배열 원소가 이미 중앙값 되어본적 있으면 넘어감
				continue;
			if (isOrderComplete())	// 모든 명령을 만족하면
				ismid[arr[N / 2] - 1] = true;
		} while (nextPer());

		System.out.println(booleanCnt());
	}
	
	/* 현재 상태(arr[] 배열)가 입력받은 명령어들을 모두 만족하면 true 반환 */
	private static boolean isOrderComplete() {
		next_order: 
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 명령의 작은 값(order[i][0])이 아닌 경우
				if (order[i][0] != arr[j])
					continue;

				// 작은 값 찾았으니 큰 값(order[i][1]) 찾자
				for (int k = j + 1; k < N; k++)
					if (order[i][1] == arr[k]) 
						continue next_order;	// 해당 명령 만족함
				
				// 큰 값을 못 찾은 경우
				return false;
			}
		}
		return true;
	}

	public static boolean nextPer() {
		int i = N - 1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = N -1;
		while(arr[i-1] >= arr[j]) j--;
		swap(i-1, j);
		
		j = N -1;
		while(i < j)
			swap(i++, j--);
		return true;
	}
	
	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/* ismid[] 배열에서 false인 원소의 개수를 반환 */
	public static int booleanCnt() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(!ismid[i]) cnt++;
		}
		return cnt;
	}
}
/*
5 4
2 1
4 3
5 1
4 2
*/