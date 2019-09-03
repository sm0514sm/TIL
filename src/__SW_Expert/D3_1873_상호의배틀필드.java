package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드 {
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());	// 높이
			int W = Integer.parseInt(st.nextToken());	// 넓이
			char[][] MAP = new char[H][W];
			int r = 0, c = 0, dir = 0;	// start position
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					MAP[i][j] = str.charAt(j);
					if	   (str.charAt(j) == '^') {	r = i;	c = j;	dir = 0;}
					else if(str.charAt(j) == 'v') {	r = i;	c = j;	dir = 1;}
					else if(str.charAt(j) == '<') {	r = i;	c = j;	dir = 2;}
					else if(str.charAt(j) == '>') {	r = i;	c = j;	dir = 3;}
				}
			}
			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();
			for (int i = 0; i < N; i++) {
				int nr, nc;
				if (command.charAt(i) == 'S') {
					int count = 1;
					while(true) {
						nr = r + DIR[dir][0]*count;
						nc = c + DIR[dir][1]*count;
						if(nr < 0 || nc < 0 || nr >= H || nc >= W) break;
						if(MAP[nr][nc] == '#') break;
						if(MAP[nr][nc] == '*') {
							MAP[nr][nc] = '.';
							break;
						}
						count++;
					}
				} 
				else {
					char dirChar = ' ';
					switch (command.charAt(i)) {
						case 'U':	dir = 0;	dirChar = '^';	break;
						case 'D':	dir = 1;	dirChar = 'v';	break;
						case 'L':	dir = 2;	dirChar = '<';	break;
						case 'R':	dir = 3;	dirChar = '>';	break;
					}
					nr = r + DIR[dir][0];
					nc = c + DIR[dir][1];
					MAP[r][c] = dirChar;
					if(nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
					if(MAP[nr][nc] != '.') continue;	// 평지가 아니면 넘어감
					MAP[r][c] = '.';
					r = nr;
					c = nc;
					MAP[r][c] = dirChar;
				}
			}
			bw.append("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					bw.append(MAP[i][j] + "");
				}
				bw.append("\n");
			}
			bw.flush();
		}
	}
}
