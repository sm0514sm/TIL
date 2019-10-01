package __Jungol;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2543_타일채우기 {
	static int N, R, C;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		arr = new int[N][N];
		
		doit(new int[] {R, C}, 0, 0, N/2);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		sc.close();
	}

	private static void doit(int[] target, int r, int c, int mid) {
		int dir = 0;
		
			 if(target[0] < r + mid && target[1] < c + mid) dir = 1;
		else if(target[0] < r + mid && target[1] >= c + mid) dir = 2;
		else if(target[0] >= r + mid && target[1] < c + mid) dir = 3;
		else if(target[0] >= r + mid && target[1] >= c + mid) dir = 4;
		
			 
		int[] MidRD = new int[] {r + mid, c + mid};
		int[] MidRU = new int[] {r + mid - 1, c + mid};
		int[] MidLD = new int[] {r + mid, c + mid - 1};
		int[] MidLU = new int[] {r + mid - 1, c + mid - 1};
		switch (dir) {
		case 1:
			arr[MidRD[0]][MidRD[1]] = 1;
			arr[MidLD[0]][MidLD[1]] = 1;
			arr[MidRU[0]][MidRU[1]] = 1;
			if(mid / 2 != 0) {
				doit(MidRD, r + mid, c + mid, mid / 2);
				doit(MidLD, r + mid, c , mid / 2);
				doit(MidRU, r, c + mid,  mid / 2);
				doit(target, r, c, mid / 2);
			}
			break;
		case 2:
			arr[MidLD[0]][MidLD[1]] = 2;
			arr[MidLU[0]][MidLU[1]] = 2;
			arr[MidRD[0]][MidRD[1]] = 2;
			if(mid / 2 != 0) {
				doit(MidLD, r + mid, c, mid / 2);
				doit(MidLU, r, c, mid / 2);
				doit(MidRD, r + mid, c + mid, mid / 2);
				doit(target, r, c + mid , mid / 2);
			}
			break;
		case 3:
			arr[MidRU[0]][MidRU[1]] = 3;
			arr[MidRD[0]][MidRD[1]] = 3;
			arr[MidLU[0]][MidLU[1]] = 3;
			if(mid / 2 != 0) {
				doit(MidRU, r, c + mid, mid / 2);
				doit(MidRD, r + mid, c + mid, mid / 2);
				doit(MidLU, r, c, mid / 2);
				doit(target, r + mid, c, mid / 2);
			}
			break;
		case 4:
			arr[MidLU[0]][MidLU[1]] = 4;
			arr[MidRU[0]][MidRU[1]] = 4;
			arr[MidLD[0]][MidLD[1]] = 4;
			if(mid / 2 != 0) {
				doit(MidLU, r, c , mid / 2);
				doit(MidRU, r, c + mid, mid / 2);
				doit(MidLD, r + mid, c, mid / 2);
				doit(target, r + mid, c + mid, mid / 2);
			}
			break;
		}
	}
}
