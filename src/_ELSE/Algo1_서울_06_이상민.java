package _ELSE;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algo1_서울_06_이상민 {
	static int ROW = 0; 
	static int COL = 0; 
	static char[][] MAP;
	static int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int t = 1, testcase = Integer.parseInt(br.readLine()); t <= testcase; t++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			ROW = Integer.parseInt(st.nextToken());
			COL = Integer.parseInt(st.nextToken());
			MAP = new char[ROW][COL];
			for (int i = 0; i < ROW; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < COL; j++) {
					MAP[i][j] = st.nextToken().charAt(0);
				}
			}/*-----데이터 입력 완료------*/
			
			for(int i = 0; i < ROW; i++) {
				find_next_target:
				for(int j = 0; j < COL; j++) {
					if(MAP[i][j] != 'T')	continue;
					for(int dir = 0; dir < 4; dir++) {
						//상하좌우 모두 살펴봐서 총잡이가 있는지 확인
						int count = 0;	//거리
						while(true) {
							count++;
							int nr = i + DIR[dir][0]*count;
							int nc = j + DIR[dir][1]*count;
							if(nr < 0 || nr >= ROW || nc < 0 || nc >= COL) break;	// MAP 범위 벗어난 경우
							if(MAP[nr][nc] == 'T' || MAP[nr][nc] == 'W')   break;	// 해당 방향이 다른 타겟 or 벽으로 막힌 경우
							if(MAP[nr][nc] == 'G') {
								answer++;
								continue find_next_target;
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n", t, answer);
		}//END testcase
	}//END main
}
/*
2
5 7
T 0 T 0 G 0 G
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0
*/