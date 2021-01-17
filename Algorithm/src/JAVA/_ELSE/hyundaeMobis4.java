package _ELSE;

public class hyundaeMobis4 {
	static int[][] DIR = { { -1,0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Key[][] keyboard = new Key[3][10];
	static int[][] possible = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
							   {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
							   {1, 1, 1, 1, 1, 1, 1, 0, 0, 0}};
	static int r = 1;
	static int c = 6;
	static class Key{
		long[] possible;	// 갈 수 없으면 -1, 아직 모르면 0

		public Key(int T) {
			possible = new long[T+1];
			possible[0] = -1;
		}

	}
	
    public static int solution(int T) {
        for(int i = 0; i < 3; i++)
        	for (int j = 0; j < 10; j++)
				keyboard[i][j] = new Key(T);
        for (int dir = 0; dir < 4; dir++) {
			int nr = r + DIR[dir][0];
			int nc = c + DIR[dir][1];
			for(int i = 0; i < T; i+=2) {
				keyboard[nr][nc].possible[i] = -1;
			}
			keyboard[nr][nc].possible[1] = 1;
		}
        return (int) find(r, c, T);	// [r][c]에서 T번 만에 갔다 올 수 있는 경우의 수
    }

	private static long find(int r, int c, int T) {
		if(T == 0) return 0;
		if(keyboard[r][c].possible[T] != 0) return keyboard[r][c].possible[T];	// 이미 있는 값이면
		
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + DIR[dir][0];
			int nc = c + DIR[dir][1];
			if(nr >= 3 || nc >= 10 || nr < 0 || nc < 0) continue;
			if(possible[nr][nc] == 0) continue;
			long temp = find(nr, nc, T - 1);
			keyboard[r][c].possible[T] += temp == -1? 0: temp;
			keyboard[r][c].possible[T] %= 1000000007;
		}
		return keyboard[r][c].possible[T] % 1000000007;
	}

	public static void main(String[] args) {
		System.out.println(solution(3));
		for(int i = 1 ; i < 1000; i++)
			System.out.println(i + " : " + solution(i));
	}

}
