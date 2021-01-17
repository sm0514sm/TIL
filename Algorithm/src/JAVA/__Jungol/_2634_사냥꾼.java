package __Jungol;
//8983
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2634_사냥꾼 {
	static class ANIMAL{
		long x, y;

		public ANIMAL(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		public long dis(long fromX) {
			return Math.abs(fromX - x) + y;
		}
		
		public int get젤가까운사수() {
			long temp = 10000000;
			int tempIdx = 0;
			int left = 0;
			int right = M - 1;
			int mid = M/2;
			while(left < right) {
				if(gunners[mid] == x) return mid;
				if(temp > Math.abs(gunners[mid] - x)) {
					temp = Math.abs(gunners[mid] - x);
					tempIdx = mid;
				}
				if(gunners[mid] < x) {
					left = mid + 1;
					mid = (left + right)/2;
				}
				else {
					right = mid - 1;
					mid = (left + right)/2;
				}
			}
			if(Math.abs(gunners[mid] - x) > temp)
				mid = tempIdx;
			return mid;
		}
		
		public boolean iCanLive() {
			if(dis(gunners[get젤가까운사수()]) > L)
				return true;
			else
				return false;
		}
	}

	static long[] gunners;
	static int M, N;
	static long L;

	public static void main(String[] args) throws IOException {
		ArrayList<ANIMAL> liveAnimals = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	// 사대 수
		N = Integer.parseInt(st.nextToken());	// 동물 수
		L = Integer.parseInt(st.nextToken()); 	// 사정거리
		gunners = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			gunners[i] = Integer.parseInt(st.nextToken()); 
		Arrays.sort(gunners);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ANIMAL ani = new ANIMAL(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			if(ani.iCanLive())
				liveAnimals.add(ani);
		}
		System.out.println(N - liveAnimals.size());
	}
}
