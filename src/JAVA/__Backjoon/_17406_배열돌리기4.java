package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class COM{
	public int r,s,c;

	public COM(int r, int c, int s) {
		this.r = r;
		this.s = s;
		this.c = c;
	}
}
public class _17406_배열돌리기4 {
	static int[][] arr, tempArr;
	static COM[] commands;
	static int[] orders;	// 순열 명령 돌릴 순서
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 행
		int M = Integer.parseInt(st.nextToken());	// 열
		int K = Integer.parseInt(st.nextToken());	// 회전 연산의 수
		int answer = Integer.MAX_VALUE;
		arr = new int[N][M];	// 
		tempArr = new int[N][M];
		commands = new COM[K];	// 명령 배열
		orders = new int[K];	// 명령 순서
		for(int k = 0; k < K; k++)
			orders[k] = k;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			commands[k] = new COM(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		/*데이터 입력 끝*/
		do {
			tempArr = deepCopy(arr);
			for(int k = 0; k < K; k++) {
				rotate(commands[orders[k]].r - 1, commands[orders[k]].c - 1, commands[orders[k]].s);
			}
			answer = Math.min(answer, getMin());
		}while(nextPer());
		System.out.println(answer);
	}

	private static void rotate(int r, int c, int s) {
		for(int i = 0; i < s; i++) {
			int temp = tempArr[r-s+i][c-s+i];
			for(int j = r-s+i, k = 0; j < r+s-i; j++, k++) 	// 좌
				tempArr[r-s+k+i][c-s+i] = tempArr[r-s+k+1+i][c-s+i];
			for(int j = c-s+i-1, k = 0; j < c+s-i-1; j++, k++)	// 하
				tempArr[r+s-i][c-s+k+i] = tempArr[r+s-i][c-s+k+1+i];
			for(int j = r+s-i, k = 0; j > r-s+i; j--, k--) 	// 우
				tempArr[r+s+k-i][c+s-i] = tempArr[r+s+k-1-i][c+s-i];
			for(int j = c+s-i-1, k = 0; j > c-s+i-1 ; j--, k--)	// 상
				tempArr[r-s+i][c+s+k-i] = tempArr[r-s+i][c+s+k-1-i];
			tempArr[r-s+i][c-s+1+i] = temp;
		}
	}
	/*
	 * private static void rotate(int r, int c, int s) {
		for(int i = 0; i < s; i++) {
			int temp = tempArr[r-s+i][c-s+i];
			for(int j = r-s+i; j < r+s-i; j++) 	// 좌
				tempArr[r-s+j][c-s+i] = tempArr[r-s+j+1][c-s+i];
			for(int j = c-s+i-1; j < c+s-i-1; j++)	// 하
				tempArr[r+s-i][c-s+j] = tempArr[r+s-i][c-s+j+1];
			for(int j = r+s-i; j > r-s+i; j--) 	// 우
				tempArr[r-s+j][c+s-i] = tempArr[r-s+j-1][c+s-i];
			for(int j = c+s-i-1; j > c-s+i-1 ; j--)	// 상
				tempArr[r-s+i][c-s+j] = tempArr[r-s+i][c-s+j-1];
			tempArr[r-s+i][c-s+1+i] = temp;
		}
		System.out.println();
	}*/
	private static int[][] deepCopy(int[][] original) {
        if(original == null) return null;
        int[][] result = new int[original.length][original[0].length];
         
        for(int i=0; i<original.length; i++){
            System.arraycopy(original[i], 0, result[i], 0, original[0].length);
        }
         
        return result;
    }
	private static int getMin() {
		int min = Integer.MAX_VALUE;
		for(int i = 0, rowLen =tempArr.length; i < rowLen; i++) {
			int lineSum = 0;
			for(int j = 0, colLen = tempArr[0].length; j < colLen; j++) {
				lineSum += tempArr[i][j];
			}
			min = Math.min(min, lineSum);
		}
		return min;
	}

	public static boolean nextPer() {
		int i = orders.length - 1;
		while(i > 0 && orders[i-1] >= orders[i]) i--;
		if(i == 0)	return false;
		
		int j = orders.length -1;
		while(orders[i-1] >= orders[j]) j--;
		swapOrder(i-1, j);
		
		
		j = orders.length -1;
		while(i < j)
			swapOrder(i++, j--);
		return true;
	}
	
	public static void swapOrder(int i, int j) {
		int temp = orders[i];
		orders[i] = orders[j];
		orders[j] = temp;
	}
}
