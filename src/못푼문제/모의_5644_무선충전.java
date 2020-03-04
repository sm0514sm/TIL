package 못푼문제;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 모의_5644_무선충전 {
	static int M, A; 	// 총 이동시간, BC개수
	static int[][] DIR = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static int[] dir1, dir2;
	static BC[] bcs;
	static class Person{
		int x, y;
	}
	static class BC implements Comparable<BC>{
		int x, y;
		int range;
		int	power;
		
		public BC(int x, int y, int range, int power) {
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}

		@Override
		public int compareTo(BC o) {
			return Integer.compare(power, o.power);
		}
	}
		// X가 Column, Y가 Row
		//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int ans = 0;
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			bcs = new BC[A];
			dir1 = new int[M];
			dir2 = new int[M];
			Person one = new Person();
			Person two = new Person();
			two.x = two.y = 9;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dir1[i] = Integer.parseInt(st.nextToken()); 
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				dir2[i] = Integer.parseInt(st.nextToken()); 
			}
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bcs[i] = new BC(Integer.parseInt(st.nextToken()) - 1,
								Integer.parseInt(st.nextToken()) - 1,
								Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()));
			}
			PriorityQueue<BC> onePossible;
			PriorityQueue<BC> twoPossible;
			for (int time = 0; time <= M; time++) {
				// 거리 확인
				onePossible = new PriorityQueue<>();
				twoPossible = new PriorityQueue<>();
				int oneSum = 0;
				int twoSum = 0;
				for (int i = 0; i < A; i++) {
					if(Math.abs(one.x - bcs[i].x) + Math.abs(one.y - bcs[i].y) <= bcs[i].range) {
						onePossible.add(bcs[i]);
						oneSum += bcs[i].power;
					}
					if(Math.abs(two.x - bcs[i].x) + Math.abs(two.y - bcs[i].y) <= bcs[i].range) {
						twoPossible.add(bcs[i]);
						twoSum += bcs[i].power;
					}
				}
				// 가능한 개수가 다르면 개수가 적은 애부터 선택
				if(onePossible.size() != twoPossible.size()) {
					BC pick = null;
					BC pick2 = null;
					
					PriorityQueue<BC> min = onePossible.size() < twoPossible.size() ? onePossible : twoPossible;
					PriorityQueue<BC> max = onePossible.size() < twoPossible.size() ? twoPossible : onePossible;
					if(!min.isEmpty()) {
						pick = min.poll();
						ans += pick.power;
					}
					while(true) {
						pick2 = max.poll();
						if(pick != pick2) {
							ans += pick2.power;
							break;
						}
					}
				}
				else {
					// 가능한 개수가 같지만 합이 다르면 합이 작은 애 부터
					if(oneSum != twoSum) {
						BC pick = null;
						BC pick2 = null;
						
						if(!onePossible.isEmpty()) {
							pick = onePossible.poll();
							ans += pick.power;
						}
						while(true) {
							pick2 = twoPossible.poll();
							if(pick != pick2) {
								ans += pick2.power;
								break;
							}
							if(twoPossible.isEmpty())
								break;
						}
					}
					// 가능한 개수가 같고 합도 같다면 큰거 두개 선택하기
					else {
						if(oneSum != 0) {
							BC pick = null;
							
							if(!onePossible.isEmpty()) {
								pick = onePossible.poll();
								ans += pick.power;
							}
						}
					}
				}
				// 이동
				if(time == M) break;
				one.x += DIR[dir1[time]][0];
				one.y += DIR[dir1[time]][1];
				two.x += DIR[dir2[time]][0];
				two.y += DIR[dir2[time]][1];
			}
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
