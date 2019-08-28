package _ELSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test {
	static int[][] DIR = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},	//상 하 좌 우
						  {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};	//좌상 우하 우상 좌하
	static int[][][] searchDIR = {{{0, 1}, {-1, 1}, {1, 1}}, // 상일때 검사
								  {{0, -1}, {-1, -1}, {1, -1}},	// 하일때 검사
								  {{-1, 0}, {-1, 1}, {-1, -1}},	// 좌일때 검사
								  {{1, 0}, {1, 1}, {1, -1}}};	// 우일때 검사
	static class ATOM{
		int x, y, dir, energy, index;

		public ATOM(int x, int y, int dir, int energy, int index) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;	// energy == -1이면 없어진 것
			this.index = index;		// 고유 번호(1부터 N)
		}
		
		@Override
		public String toString() {
			return "ATOM [x=" + (x-1000) + ", y=" + (y-1000) + ", dir=" + dir + ", energy=" + energy + ", index=" + index + "]";
		}

		public ArrayList<ATOM> findUP() {
			ArrayList<ATOM> getAtoms = new ArrayList<>();
			int[][] searchD = searchDIR[0];
			int minIdx = 10000;
			int min = 10000;
			for(int i = 0; i < 3; i++) {
				int cnt = 0;
				while(true) {
					cnt++;
					int nr = x + searchD[i][0] * cnt;
					int nc = y + searchD[i][1] * cnt;
					if(nr < 0 || nc < 0 || nr >= 2000 || nc >= 2000) break;
					if(MAP[nr][nc] == 0) continue;
					ATOM temp = list.get(MAP[nr][nc]-1);
					if(temp.energy==-1) continue;
					if(i == 0 && temp.dir == 0) break;
					if(i == 0 && temp.dir == 1) {
						if(min > Math.abs(temp.y - y)/2) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.y - y)/2;
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.y - y)/2) {
							getAtoms.add(temp);
						}
					}
					else if(i == 1 && temp.dir == 3) {
						if(min > Math.abs(temp.y - y)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.y - y);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.y - y)) {
							getAtoms.add(temp);
						}
					}
					else if(i == 2 && temp.dir == 2) {
						if(min > Math.abs(temp.y - y)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.y - y);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.y - y)) {
							getAtoms.add(temp);
						}
					}
				}
			}
			if(minIdx == 10000) return null;
			return getAtoms;
		}
		public ArrayList<ATOM> findDown() {
			ArrayList<ATOM> getAtoms = new ArrayList<>();
			int[][] searchD = searchDIR[1];
			int minIdx = 10000;
			int min = 10000;
			for(int i = 0; i < 3; i++) {
				int cnt = 0;
				while(true) {
					cnt++;
					int nr = x + searchD[i][0] * cnt;
					int nc = y + searchD[i][1] * cnt;
					if(nr < 0 || nc < 0 || nr >= 2000 || nc >= 2000) break;
					if(MAP[nr][nc] == 0) continue;
					ATOM temp = list.get(MAP[nr][nc]-1);
					if(temp.energy==-1) continue;
					if(i == 0 && temp.dir == 1) break;
					if(i == 0 && temp.dir == 0) {
						if(min > Math.abs(temp.y - y)/2) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.y - y)/2;
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.y - y)/2) {
							getAtoms.add(temp);
						}
					}
					else if(i == 1 && temp.dir == 3) {
						if(min > Math.abs(temp.y - y)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.y - y);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.y - y)) {
							getAtoms.add(temp);
						}
					}
					else if(i == 2 && temp.dir == 2) {
						if(min > Math.abs(temp.y - y)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.y - y);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.y - y)) {
							getAtoms.add(temp);
						}
					}
				}
			}
			if(minIdx == 10000) return null;
			return getAtoms;
		}
		public ArrayList<ATOM> findLeft() {
			ArrayList<ATOM> getAtoms = new ArrayList<>();
			int[][] searchD = searchDIR[2];
			int minIdx = 10000;
			int min = 10000;
			for(int i = 0; i < 3; i++) {
				int cnt = 0;
				while(true) {
					cnt++;
					int nr = x + searchD[i][0] * cnt;
					int nc = y + searchD[i][1] * cnt;
					if(nr < 0 || nc < 0 || nr >= 2000 || nc >= 2000) break;
					if(MAP[nr][nc] == 0) continue;
					ATOM temp = list.get(MAP[nr][nc]-1);
					if(temp.energy==-1) continue;
					if(i == 0 && temp.dir == 2) break;
					if(i == 0 && temp.dir == 3) {
						if(min > Math.abs(temp.x - x)/2) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.x - x)/2;
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.x - x)/2) {
							getAtoms.add(temp);
						}
					}
					else if(i == 1 && temp.dir == 1) {
						if(min > Math.abs(temp.x - x)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.x - x);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.x - x)) {
							getAtoms.add(temp);
						}
					}
					else if(i == 2 && temp.dir == 0) {
						if(min > Math.abs(temp.x - x)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.x - x);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.x - x)) {
							getAtoms.add(temp);
						}
					}
				}
			}
			if(minIdx == 10000) return null;
			return getAtoms;
		}
		public ArrayList<ATOM> findRight() {
			ArrayList<ATOM> getAtoms = new ArrayList<>();
			int[][] searchD = searchDIR[3];
			int minIdx = 10000;
			int min = 10000;
			for(int i = 0; i < 3; i++) {
				int cnt = 0;
				while(true) {
					cnt++;
					int nr = x + searchD[i][0] * cnt;
					int nc = y + searchD[i][1] * cnt;
					if(nr < 0 || nc < 0 || nr >= 2000 || nc >= 2000) break;
					if(MAP[nr][nc] == 0) continue;
					ATOM temp = list.get(MAP[nr][nc]-1);
					if(temp.energy==-1) continue;
					if(i == 0 && temp.dir == 3) break;
					if(i == 0 && temp.dir == 2) {
						if(min > Math.abs(temp.x - x)/2) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.x - x)/2;
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.x - x)/2) {
							getAtoms.add(temp);
						}
					}
					else if(i == 1 && temp.dir == 1) {
						if(min > Math.abs(temp.x - x)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.x - x);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.x - x)) {
							getAtoms.add(temp);
						}
					}
					else if(i == 2 && temp.dir == 0) {
						if(min > Math.abs(temp.x - x)) {
							getAtoms.clear();
							getAtoms.add(temp);
							min = Math.abs(temp.x - x);
							minIdx = MAP[nr][nc] - 1;
						}
						else if(min == Math.abs(temp.x - x)) {
							getAtoms.add(temp);
						}
					}
				}
			}
			if(minIdx == 10000) return null;
			return getAtoms;
		}
		
	}
	static ArrayList<ATOM> list ;
	static int[][] MAP;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc <= T; tc++) {
			int answer = 0;
			list = new ArrayList<>();
			MAP = new int[1000+1000+1][1000+1000+1];
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) + 1000;
				int y = Integer.parseInt(st.nextToken()) + 1000;
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				list.add(new ATOM(x, y, dir, energy, i+1));
				MAP[x][y] = i+1;
			}
			for(int i = 0; i < N; i++) {
				ATOM temp = list.get(i);
				if(temp.energy == -1) continue;
				ArrayList<ATOM> getAtoms = null;
				switch (temp.dir) {
				case 0:
					getAtoms = temp.findUP();
					break;
				case 1:
					getAtoms = temp.findDown();
					break;
				case 2:
					getAtoms = temp.findLeft();
					break;
				case 3:
					getAtoms = temp.findRight();
					break;
				}
				if(getAtoms == null) continue;
				answer += temp.energy;
				temp.energy = -1;
				for(int j = 0; j < getAtoms.size(); j++) {
					answer += getAtoms.get(j).energy;
					getAtoms.get(j).energy = -1;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}

}
