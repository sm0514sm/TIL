package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class D4_1824_혁진이의프로그램검증 {
	static int mem = 0;
	static int R = 0;
	static int C = 0;
	static int rn, cn;
	static int[][] dir = {{0, 1} , {0, -1} , {1, 0}, {-1, 0}}; // 우 좌 하 상
	static char[][] text ;
	public static int memSet(int val) {
		if(val < 0)
			mem = 15;
		else if(val > 15)
			mem = 0;
		else
			mem = val;
		return mem;
	}
	public static int Rset(int val) {
		if(val >= R)
			rn = 0;
		else if(val < 0)
			rn = R -1;
		else
			rn = val;
		return rn;
	}
	public static int Cset(int val) {
		if(val >= C)
			cn = 0;
		else if(val < 0)
			cn = C -1;
		else
			cn = val;
		return cn;
	}
	public static int limit(int val, int max) {
		int temp;
		if(val >= max)
			temp = 0;
		else if(val < 0)
			temp = max -1;
		else
			temp = val;
		return temp;
	}
	public static boolean isGoalNear(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int rr = r + dir[i][0];
			int cc = c + dir[i][1];
			rr = limit(rr, R);
			cc = limit(cc, C);
			if(text[rr][cc] == '@') {
				return true;
			}
		}
		
		return false;
	}
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		int RIGHT = 0;
		int LEFT = 1;
		int DOWN = 2;
		int UP = 3;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			R = C = rn = cn = mem = 0;
			boolean answer = false;
			boolean endYes = false;
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			text = new char[R][C];
			for (int i = 0; i < R; i++) {
				text[i] = br.readLine().toCharArray();
			}
			FIND_GOAL:
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(text[i][j] == '@') {
						endYes = true;
						break FIND_GOAL;
					}
				}
			}
			FIND_LOOP:
			for(int i = 0 ; i < 10000; i ++) {
				int nowDIR = RIGHT;
				int rotateCount = 0;
				int questionCount = 0;
				Rset(0);	// rn
				Cset(0);	// cn
				mem = 0;
				answer = false;
				if(endYes) {
					LOOP:
					while(true) {
						rotateCount++;
						if(rotateCount > 100) break LOOP;
						switch (text[rn][cn]) {
						case '<':	nowDIR = LEFT;	break;
						case '>':	nowDIR = RIGHT;	break;
						case '^':	nowDIR = UP;	break;
						case 'v':	nowDIR = DOWN;	break;
						case '_':	if(mem == 0) 
										nowDIR = RIGHT; 
									else 
										nowDIR = LEFT;
									break;
						case '|':	if(mem == 0) 
										nowDIR = DOWN; 
									else 
										nowDIR = UP;	
									break;
						case '?':	
							if(isGoalNear(rn, cn))
								{answer = true; break LOOP;}
							else
								nowDIR = (int) (Math.random() * 4);
						case '.':	break;
						case '@':	answer = true; break FIND_LOOP;
						case '+': 	memSet(mem + 1); break;
						case '-': 	memSet(mem - 1); break;
						case '0': 	memSet(0); break;
						case '1': 	memSet(1); break;
						case '2': 	memSet(2); break;
						case '3': 	memSet(3); break;
						case '4': 	memSet(4); break;
						case '5': 	memSet(5); break;
						case '6': 	memSet(6); break;
						case '7': 	memSet(7); break;
						case '8': 	memSet(8); break;
						case '9': 	memSet(9); break;
						}
						Rset(rn + dir[nowDIR][0]);
						Cset(cn + dir[nowDIR][1]);
						
					}
					
					
					
				}
			}
			if(answer)
				bw.write(String.format("#%d YES\n", test_case));
			else
				bw.write(String.format("#%d NO\n", test_case));
			bw.flush();
		}
	}
}
