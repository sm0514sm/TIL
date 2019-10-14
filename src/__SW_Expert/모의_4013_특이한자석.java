package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 모의_4013_특이한자석 {
	static int rotateCnt;
	static Magnetic[] magnetics;
	static boolean[] visited;
	
	static class Magnetic{
		int point;	// 빨간 화살표가 가르키는 위치
		int num;	// S극이면 얻을 점수
		int[] arr;	// N,S극 배열 (N = 0, S = 1)
		
		public Magnetic(int num, int[] arr) {
			this.point = 0;
			this.num = num;
			this.arr = arr;
		}
		
		public void rotate(boolean isClock) {
			Magnetic leftMag = null, rightMag = null;
			if(num != 0) leftMag = magnetics[num - 1];
			if(num != 3) rightMag = magnetics[num + 1];
			visited[num] = true;
			if(leftMag != null && !visited[leftMag.num] && leftMag.arr[getPoint(leftMag.point + 2)] != arr[getPoint(point - 2)])
				leftMag.rotate(!isClock);
			if(rightMag != null && !visited[rightMag.num] && rightMag.arr[getPoint(rightMag.point - 2)] != arr[getPoint(point + 2)])
				rightMag.rotate(!isClock);
			
				
			if(isClock)	point = getPoint(point - 1);
			else		point = getPoint(point + 1);
		}

		private int getPoint(int point) {
			if(point >= 8) point %= 8;
			if(point < 0) point += 8;
			return point;
		}
	}
	
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_4013.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			rotateCnt = Integer.parseInt(br.readLine());
			magnetics = new Magnetic[4];
			
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				int[] tempArr = new int[8];
				for (int j = 0; j < 8; j++)
					tempArr[j] = Integer.parseInt(st.nextToken());
				magnetics[i] = new Magnetic(i, tempArr);
			}
			for (int i = 0; i < rotateCnt; i++) {
				visited = new boolean[4];
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken()) - 1;
				boolean rotateDir = Integer.parseInt(st.nextToken()) == 1? true: false;
				magnetics[number].rotate(rotateDir);
			}
			int totalScore = 0;
			for(int i = 0; i < 4; i++) {
				int score = magnetics[i].arr[magnetics[i].point];
				totalScore += (1 << (i)) * score;
			}
			System.out.println("#" + test_case + " " + totalScore);
		}
	}
}
