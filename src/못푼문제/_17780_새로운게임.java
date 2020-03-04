package 못푼문제;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Main
public class _17780_새로운게임 {
	static int N, K;	// 체스판 크기, 말 개수
	static int[][] map;
	static int[][] DIR = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	static ArrayList<Mass> massList;
	static Horse[] horses;
	
	static class Horse{
		int dir, height;
		Mass mass;

		public Horse(int dir) {
			this.dir = dir;
			height = 1;
		}
		
		public void doit() {
			mass.move();
		}
	}
	
	static class Mass{
		int r, c;
		ArrayList<Horse> horseList;

		public Mass(int r, int c) {
			this.r = r;
			this.c = c;
			this.horseList = new ArrayList<>();
		}
		
		public void add(Horse horse) {
			horseList.add(horse);
			horse.height = horseList.size();
			setting();
		}
		
		public void setting() {
			for (Horse horse : horseList) {
				horse.mass = this;
			}
		}
		
		public void move() {
			int dir = getDir();
			int nr = r + DIR[dir][0];
			int nc = c + DIR[dir][1];
			if(nr >= N || nc >= N || nr < 0 || nc < 0) {
				turn();
				return;
			}
			if(map[nr][nc] == 2) {
				turn();
				return;
			}
			
			
			
		}
		
		
		
		// red
		public void reverse() {
			int size = horseList.size();
			ArrayList<Horse> tempList = new ArrayList<>();
			horseList.addAll(tempList);
			horseList.clear();
			for (int i = size-1; i >= 0; i--) {
				horseList.add(tempList.get(i));
			}
		}
		
		public int getDir() {
			return horseList.get(0).dir;
		}
		
		// blue
		public void turn() {
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		horses = new Horse[K];
		massList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			} 
		}
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			Mass mass = new Mass(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			massList.add(mass);
			Horse horse = new Horse(Integer.parseInt(st.nextToken()));
			mass.horseList.add(horse);
			horses[i-1] = horse;
		}
		for (int turn = 0; turn < 30; turn++) {
			for (int h = 0; h < K; h++) {
				if(horses[h].height != 1) continue;
				
			}
		}
	}
}
