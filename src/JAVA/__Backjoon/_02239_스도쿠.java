package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//Main
public class _02239_스도쿠 {
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		arr = new int[9][9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}			
		}
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(arr[i][j] != 0) continue;
				for (int num = 1; num <= 9; num++) {
					if(squarePossible(i, j, num)
						&& rowPossible(i, num)
						&& colPossible(j, num)) {
						arr[i][j] = num;
						stack.add(new int[] {i, j, num});
						break;
					}
				}
				if(arr[i][j] == 0) {
					int[] last = new int[] {0, 0, 0};
					while(true) {
						last = stack.pop();
						int num = 0;
						for (num = last[2]+1; num <= 9; num++) {
							if(squarePossible(last[0], last[1], num)
									&& rowPossible(last[0], num)
									&& colPossible(last[1], num)) {
								arr[last[0]][last[1]] = num;
								stack.add(new int[] {last[0], last[1], num});
								break;
							}
						}
						if(num != 10) break;
						arr[last[0]][last[1]]= 0;
					}
					j = last[1] - 1;
					i = last[0];
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	private static boolean squarePossible(int i, int j, int num) {
		for (int r = i/3 * 3; r < (i/3 + 1) * 3; r++) {
			for (int c = j/3 * 3; c < (j/3 +1) * 3; c++) {
				if(arr[r][c] == num)
					return false;
			}
		}
		return true;
	}
	private static boolean rowPossible(int row, int num) {
		for (int col = 0; col < 9; col++) {
			if(arr[row][col] == num)
				return false;
		}
		return true;
	}
	private static boolean colPossible(int col, int num) {
		for (int row = 0; row < 9; row++) {
			if(arr[row][col] == num)
				return false;
		}
		return true;
	}
}
