package __Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _17143_낚시왕 {
	static class POINT {
		ArrayList<SHARK> sharks;
		SHARK BIGSHARK = null;
		public POINT() {
			sharks = new ArrayList<>();
		}
		public void addShark(SHARK sk) {
			sharks.add(sk);
			if(BIGSHARK == null) {
				BIGSHARK = sk;
			}
			else {
				if(BIGSHARK.size < sk.size)
					BIGSHARK = sk;
			}
		}
		@Override
		public String toString() {
			int answer = 0;
			if(sharks.size() != 0)
				answer = sharks.size();
			return answer + "";
		}
		
	}
	static class SHARK {
		int id;
		int r, c; // 위치
		int speed; // 속도
		int dir, size;

		public SHARK(int id, int r, int c, int speed, int dir, int size) {
			this.id = id;
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		public void go() {
			if (speed == 0)
				return;
			int nr = r + DIR[dir][0] * speed;
			int nc = c + DIR[dir][1] * speed;
			while (nc <= 0 || nc > C) {
				if (nc <= 0) {
					nc = Math.abs(nc) + 2;
					dir--;
				}
				if (nc > C) {
					nc = 2 * C - nc;
					dir++;
				}
			}
			while (nr <= 0 || nr > R) {
				if (nr <= 0) {
					nr = Math.abs(nr) + 2;
					dir++;
				}
				if (nr > R) {
					nr = 2 * R - nr;
					dir--;
				}
			}
			r = nr;
			c = nc;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("SHARK [id=");
			builder.append(id);
			builder.append(", r=");
			builder.append(r);
			builder.append(", c=");
			builder.append(c);
			builder.append(", speed=");
			builder.append(speed);
			builder.append(", dir=");
			builder.append(dir);
			builder.append(", size=");
			builder.append(size);
			builder.append("]");
			return builder.toString();
		}

	}

	static int[][] DIR = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static POINT[][] arr;
	static ArrayList<SHARK> list;
	static int R, C, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 상어의 수
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list.add(new SHARK(i + 1, r, c, speed, dir, size));
		}
		arr = new POINT[R + 1][C + 1];
		for (int i = 0; i <= R; i++) {
			arr[i] = new POINT[C+1];
			for (int j = 0; j <= C; j++) {
				arr[i][j] = new POINT();
			}
		}
		for (int i = 1; i <= C; i++) {
			setMAP();
			for (int j = 1; j <= R; j++) {
				if (arr[j][i].BIGSHARK == null)	continue;
				SHARK findShark = arr[j][i].BIGSHARK;
				answer += findShark.size;
				list.remove(findShark);
				break;
			}
			// 상어들이 움직인다
			for (int j = 0; j < list.size(); j++) {
				list.get(j).go();
			}
		}

		bw.write(String.format("%d \n", answer));
		bw.flush();
	}

	private static void setMAP() {
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= C; j++) {
				arr[i][j] = new POINT();
			}
		}
		ArrayList<POINT> collPnt = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			SHARK temp = list.get(i);
			POINT pnt = arr[temp.r][temp.c];
			pnt.addShark(temp);
			if(pnt.sharks.size() >= 2) 
				collPnt.add(pnt);
		}
		for (int i = 0; i < collPnt.size(); i++) {
			POINT pnt = collPnt.get(i);
			for (int j = 0; j < pnt.sharks.size(); j++) {
				if(pnt.BIGSHARK == pnt.sharks.get(j)) continue;
				list.remove(pnt.sharks.get(j));
			}
		}
	}
}
