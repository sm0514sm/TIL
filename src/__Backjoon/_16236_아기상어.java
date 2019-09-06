package __Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _16236_아기상어 {
	static int N;
	static class POINT{
		int r, c;

		public POINT(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("POINT [r=");
			builder.append(r);
			builder.append(", c=");
			builder.append(c);
			builder.append("]");
			return builder.toString();
		}
		
	}
	static class FISH implements Comparable<FISH> {
		int r, c;
		int dif;
		int size;

		public FISH(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.size = size;
		}

		public int getDif() {
			int minDif = Math.abs(R-r) + Math.abs(C-c);
			Queue<POINT> Q = new LinkedList<POINT>();
			boolean[][] visited = new boolean[N][N];
			boolean find = false;
			int staR = R;
			int staC = C;
			int dis = 0;
			Q.offer(new POINT(staR, staC));
			FIND: while(!Q.isEmpty()) {
				dis++;
				int size = Q.size();
				for (int SIZE = 0; SIZE < size; SIZE++) {
					POINT pop = Q.poll();
					visited[pop.r][pop.c] = true;
					for (int i = 0; i < 4; i++) {
						int nr = pop.r + DIR[i][0];
						int nc = pop.c + DIR[i][1];
						if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
						if(visited[nr][nc]) continue;
						if(MAP[nr][nc] > sharkSize) continue;
						if(nr == r && nc == c) {
							find = true;
							break FIND;
						}
						visited[nr][nc] = true;
						Q.offer(new POINT(nr, nc));
					}
				}
			}
			if(!find) return dif = 100000;
			
			return dif = Math.max(minDif, dis);
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("FISH [r=");
			builder.append(r);
			builder.append(", c=");
			builder.append(c);
			builder.append(", dif=");
			builder.append(dif);
			builder.append(", size=");
			builder.append(size);
			builder.append("]");
			return builder.toString();
		}

		@Override
		public int compareTo(FISH o) {
			int answer = this.dif - o.dif; // 거리가 가까운 물고기
			if(answer == 0)
				answer = (this.r - o.r); //그러한 물고기가 여러마리라면, 가장 위에 있는 물고기
			if(answer == 0)
				answer = (this.c - o.c); //거리가 가까운 물고기가 많다면, 가장 왼쪽에 있는 물고기
			return answer;
		}
		
	}

	static ArrayList<FISH>[] fishes; // 사이즈 별 물고기 리스트
	static PriorityQueue<FISH> eatableFish; // 상어가 먹을 수 있는 물고기 리스트
	static int[][] MAP;
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int sharkSize;	// 상어의 크기
	static int eatSize;		// eatSize == sharkSize면 sharkSize++;
	static int R, C;		// 상어의 현재 위치

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		fishes = new ArrayList[7];
		for (int i = 0; i < 7; i++)
			fishes[i] = new ArrayList<FISH>();
		int timer = 0;

		/* 데이터 입력 */
		sharkSize = 2;
		eatSize = 0;
		N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				MAP[i][j] = temp;
				if(temp == 9) {
					R = i;
					C = j;
					MAP[R][C] = 0;
				}
				else if(temp != 0)
					fishes[temp].add(new FISH(i, j, temp));
			}
		}
		
		/* 거리 설정 */
		for (int i = 1; i < sharkSize; i++)
			for (int j = 0; j < fishes[i].size(); j++) 
				fishes[i].get(j).getDif();
		
		eatableFish = new PriorityQueue<>();
		eatableFish.addAll(fishes[sharkSize - 1]);
		while(!eatableFish.isEmpty()) {
			// 먹을 수 있는 애들 중 가장 가까운 애 선택(여러개면 위, 좌 순)
			FISH target = eatableFish.poll();
			if(target.dif > 10000) break;
//			System.out.println(target);
			// 이동하기 (timer 설정 피료)
			R = target.r;
			C = target.c;
			timer += target.dif;

			// 먹기 && list설정
			MAP[R][C] = 0;
			eatSize++;
			if(eatSize == sharkSize) {
				sharkSize++;
				eatSize = 0;
//				System.out.println("level up! size : " + sharkSize);
			}
			fishes[target.size].remove(target);
			
			//priority Queue 초기화
			eatableFish.clear();
			for (int i = 1; i < Math.min(sharkSize, 7); i++)
				for (int j = 0; j < fishes[i].size(); j++) 
					fishes[i].get(j).getDif();
			for (int i = 1; i < Math.min(sharkSize, 7); i++) {
				eatableFish.addAll(fishes[i]);	// 무게 i짜리 물고기 Q에 추가
			}
		}
		System.out.println(timer);
	}
}
