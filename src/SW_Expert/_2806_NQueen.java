package SW_Expert;

import java.util.Scanner;

public class _2806_NQueen {
	static int[][] box;
	static int total, N;
	static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1},
						  { 0, -1},   		 {0, 1},
						  { 1, -1}, {1, 0}, {1, 1}};
	
	
	
	public static void setBoxPlusMinus(int val, int row, int col) {
		for(int i = 0; i < dir.length; i++) {
			int nr, nc, j = 1;
			while(true) {
				nr = row + dir[i][0] * j;
				nc = col + dir[i][1] * j;
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					box[nr][nc] += val;
					j++;
				}
				else
					break;
			}
		}
		box[row][col] += val;
	}
	
	public static void goQueen(int count, int row, int col) {
		if(count == N) {
			total += 1;
			return;
		}
		if(col == N) {
			col = 0;
			row++;
		}
		if(row == N) {
			return;
		}
		if(box[row][col] <= 0) {
			setBoxPlusMinus(1, row, col);
			goQueen(count + 1, row, col + 1);
			setBoxPlusMinus(-1, row, col);
			goQueen(count, row, col + 1);
		}
		else {
			goQueen(count, row, col+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			total = 0;
			N = sc.nextInt();
			box = new int[N][N];
			goQueen(0,0,0);
			System.out.printf("#%d %d\n", test_case, total);
		}
		sc.close();
	}
}
