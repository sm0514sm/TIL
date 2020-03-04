public class test {
	
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	// 상, 하, 좌, 우
	static int[][] map = {{1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9}
	};	// 탐색하려는 2차원 배열 맵

	public static void main(String[] args) {
		// 5에서 사방탐색
		int r = 1;	// 현재 row
	    int c = 1;	// 현재 col
		for(int dir = 0; dir < DIR.length; dir++){
	    	int nr = r + DIR[dir][0];	// 임시 row 
	    	int nc = c + DIR[dir][1];  	// 임시 column
	    	
	    	if(nr >= map.length || nr < 0) continue;	// 행 값 범위 제한
	    	if(nc >= map[0].length || nc < 0) continue;	// 열 값 범위 제한
	    	
	    	System.out.printf("(%d, %d) : %d\n", nr, nc, map[nr][nc]);
	    	// 이동해야 한다면
//	    	r = nr;
//	    	c = nc;
	    }
	}

}
