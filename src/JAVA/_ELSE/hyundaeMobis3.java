package _ELSE;

public class hyundaeMobis3 {
	static int[][] DIR = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static char[][] bod;
	static int N;

	public static int solution(String[] board) {
		N = board.length;
		int max = N % 2 == 0? N/2+1: N/2+2;
		bod = new char[N][];
		for (int i = 0; i < N; i++)
			bod[i] = board[i].toCharArray();
		
		int maxSize = 1;
		
		for (int i = maxSize; i < N - maxSize; i++) {
			nextCol:
			for (int j = maxSize; j < N - maxSize; j++) {
				int val = bod[i][j];
				// maxSize 내부보다 작거나 같은 것들 가능한지 판별
				for (int k = maxSize; k > 1; k--) {
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + DIR[dir][0] * (k-1);
						int nc = j + DIR[dir][1] * (k-1);
						if(val != bod[nr][nc]) continue nextCol;
					}
				}
				// maxSize 보다 큰게 가능한지 판별
				for (int k = maxSize + 1; k < max; k++) {
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + DIR[dir][0] * (k-1);
						int nc = j + DIR[dir][1] * (k-1);
						if(nr >= N || nc >= N || nr < 0 || nc < 0) continue nextCol;
						if(val != bod[nr][nc]) continue nextCol;
					}
					maxSize = k;
					if(maxSize == N/2 + 1)
						return maxSize * 2 - 1;
				}
			}
		}
		return maxSize == 1 ? 0 : maxSize * 2 - 1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] { "ABCBA", "DABAG", "EBABH", "FAJAI", "AKLMA" }));
		System.out.println(solution(new String[] { "ABCBA", "DABAG", "ENABH", "FAJAI", "AKLMO" }));
		System.out.println(solution(new String[] { "A" }));
		System.out.println(solution(new String[] { "AAA", "AAA", "AAA" }));
	}

}
