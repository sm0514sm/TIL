package _SW_Expert;

import java.util.Scanner;

public class D3_2806_NQueen_TC {
	static int[][] box;
	static int total, size, order[];
	static boolean[] col, slash, bSlash;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			total = 0;
			size = sc.nextInt();
			
			col 	= new boolean[size + 1];
			slash 	= new boolean[size * 2 + 1]; 	// 좌하향	↙ <-- 이 방향
			bSlash 	= new boolean[size * 2]; 		// 우하향   ↘ <-- 이 방향
			
			tryQueen(1);
			
			
			System.out.printf("#%d %d\n", test_case, total);
		}
		sc.close();
	}
	static void tryQueen(int row) {
		if(row > size) {
			total++;
			return;
		}
		/* 현재 행의 모든 열에 놓아보는 시도 */
		for (int i = 1; i <= size; i++) {
			if(col[i] || slash[row+i] || bSlash[row-i+size]) continue;	// 놓을 수 없는 상황
			
			col[i] = slash[row+i] = bSlash[row-i+size] = true;
			tryQueen(row+1);
			col[i] = slash[row+i] = bSlash[row-i+size] = false;
		}
	}
}
