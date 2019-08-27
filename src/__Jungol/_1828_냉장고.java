package __Jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1828_냉장고 {
	static int[] tm;
	static int max, min;
	static class C{
		int x, y;

		public C(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public void setPlus() {
			for(int i = x; i <= y; i++)
				tm[i]++;
		}
		
		public void setMinus() {
			for(int i = x; i <= y; i++)
				tm[i]--;
		}
		
		public boolean isBetween(int bet) {
			if(bet >= x && bet <= y)
				return true;
			else
				return false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 모든 왼족 오른쪽을 하나의 객체로 두기
		// 객체는 왼쪽인지 오른쪽인지 판단가능한 변수 필요
		// 자신의 짝의 값을 알아야함
		// 모든 값들을 오름차순두기
		// 맥스 인덱스 찾아서 모든 객체들에 대해 짝과 자신 사이라면 없애기
		StringTokenizer st = null;
		tm = new int[10000+270];
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		C[] cs = new C[N];
		min = 10270;
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) + 270;
			min = Math.min(min, x);
			int y = Integer.parseInt(st.nextToken()) + 270;
			max = Math.max(max, y);
			cs[i] = new C(x, y);
			cs[i].setPlus();
		}
		
		while(true) {
			if(isAllZero()) break;
			answer++;
			int goodIndex = findGoodIndex();
			for(int i = 0; i < N; i++) {
				if(cs[i].isBetween(goodIndex)) {
					cs[i].setMinus();
				}
			}
		}
		System.out.println(answer);
	}
	private static int findGoodIndex() {
		int index = 0;
		int mmax = 0;
		for(int i = min; i <= max; i++) {
			if(tm[i] > mmax) {
				mmax = tm[i];
				index = i;
			}
		}
		return index;
	}
	private static boolean isAllZero() {
		for(int i = min; i <= max; i++) {
			if(tm[i] != 0) return false;
		}
		return true;
	}
}
