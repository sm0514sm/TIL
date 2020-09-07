package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 모의_2382_미생물격리 {
	static class MICROBE {
		int r, c;
		int count;
		int dir;
		int id;

		public MICROBE(int id, int r, int c, int count, int dir) {
			this.id = id;
			this.r = r;
			this.c = c;
			this.count = count;
			this.dir = dir;
		}
		
		public void go() {
			int nr, nc;
			nr = r + DIR[dir][0];
			nc = c + DIR[dir][1];
			if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) {
				if(dir % 2 == 1) dir++;
				else dir--;
				count /= 2;
			}
			r = nr;
			c = nc;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("MICROBE [id=");
			builder.append(id);
			builder.append(", r=");
			builder.append(r);
			builder.append(", c=");
			builder.append(c);
			builder.append(", count=");
			builder.append(count);
			builder.append(", dir=");
			builder.append(dir);
			builder.append("]");
			return builder.toString();
		}
	}
	
	static int[][] DIR = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] MAP;
	static int N, M, K, ID;
	static ArrayList<MICROBE> microbes;
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 군집
			MAP = new int[N][N];
			microbes = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				microbes.add(new MICROBE(i+1, r, c, count, dir));
			}
			setMAP();
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < microbes.size(); j++) {
					microbes.get(j).go();
				}
				setMAP();
			}
			answer = getCnt();
			bw.append(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
	private static int getCnt() {
		int temp = 0;
		for (int i = 0; i < microbes.size(); i++) {
			temp += microbes.get(i).count;
		}
		return temp;
	}
	private static void setMAP() {
		for (int i = 0; i < MAP.length; i++) {	
			Arrays.fill(MAP[i], 0);
		}
		
		for (int i = 0; i < microbes.size(); i++) {
			MICROBE temp = microbes.get(i);
			int r = temp.r;
			int c = temp.c;
			if(MAP[r][c] == 0)
				MAP[r][c] = microbes.get(i).id;
			else {
				if(getMicrobe(MAP[r][c]) == temp) continue;
				ArrayList<MICROBE> collision = getCollision(r, c);
				MICROBE newOne = union(collision);
				for (int j = 0; j < collision.size(); j++) {
					microbes.remove(collision.get(j));
				}
				microbes.add(newOne);
				MAP[r][c]= newOne.id;
				i-=2;
			}
		}
	}
	private static ArrayList<MICROBE> getCollision(int r, int c) {
		ArrayList<MICROBE> temp = new ArrayList<MICROBE>();
		for (int i = 0; i < microbes.size(); i++) {
			if(microbes.get(i).r == r && microbes.get(i).c == c)
				temp.add(microbes.get(i));
		}
		return temp;
	}
	private static MICROBE getMicrobe(int id) {
		for (int i = 0; i < microbes.size(); i++) {
			if(microbes.get(i).id == id)
				return microbes.get(i);
		}
		return null;
	}
	private static MICROBE union(ArrayList<MICROBE> mics) {
		int dir = 0;
		int count = 0;
		int max = 0;
		for (int i = 0; i < mics.size(); i++) {
			MICROBE temp = mics.get(i);
			count += temp.count;
			if(temp.count > max) {
				max = temp.count;
				dir = temp.dir;
			}
		}
		return new MICROBE(mics.get(0).id, mics.get(0).r, mics.get(0).c, count, dir);
	}
	
}
