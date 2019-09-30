package __Jungol;
import java.io.IOException;
import java.util.Scanner;

public class _2543_타일채우기 {
	static int N, r, c;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		arr = new int[N][N];
		
		doit(new int[] {r, c}, new int[] {0, 0}, new int[] {N, N}, N/2);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static void doit(int[] target, int[] pnt1, int[] pnt2, int mid) {
		if(mid == 0) return;
		
		int dir = 0;
			 if(target[0] < pnt1[0] + mid && target[1] < pnt1[1] + mid) dir = 1;
		else if(target[0] < pnt1[0] + mid && target[1] >= pnt1[1] + mid) dir = 2;
		else if(target[0] >= pnt1[0] + mid && target[1] < pnt1[1] + mid) dir = 3;
		else if(target[0] >= pnt1[0] + mid && target[1] >= pnt1[1] + mid) dir = 4;
		
			 
		int[] MidRD = new int[] {pnt1[0] + mid, pnt1[1] + mid};
		int[] MidRU = new int[] {pnt1[0] + mid - 1, pnt1[1] + mid};
		int[] MidLD = new int[] {pnt1[0] + mid, pnt1[1] + mid - 1};
		int[] MidLU = new int[] {pnt1[0] + mid - 1, pnt1[1] + mid - 1};
		switch (dir) {
		case 1:
			arr[MidRD[0]][MidRD[1]] = 1;
			doit(MidRD,  new int[] { pnt1[0] + mid, pnt1[1] + mid }, new int[] { pnt2[0], pnt2[1] }, mid / 2);
			arr[MidLD[0]][MidLD[1]] = 1;
			doit(MidLD,  new int[] { pnt1[0] + mid, pnt1[1] }, new int[] { pnt2[0], pnt2[1] - mid }, mid / 2);
			arr[MidRU[0]][MidRU[1]] = 1;
			doit(MidRU,  new int[] { pnt1[0], pnt1[1] + mid }, new int[] { pnt2[0] - mid, pnt2[1] }, mid / 2);
			doit(target, new int[] { pnt1[0], pnt1[1] }, new int[] { pnt2[0] - mid, pnt2[1] - mid }, mid / 2);
			break;
		case 2:
			arr[MidLD[0]][MidLD[1]] = 2;
			doit(MidLD,  new int[] { pnt1[0] + mid, pnt1[1] }, new int[] { pnt2[0] - mid, pnt2[1] }, mid / 2);
			arr[MidLU[0]][MidLU[1]] = 2;
			doit(MidLU,  new int[] { pnt1[0], pnt1[1] }, new int[] { pnt2[0] - mid, pnt2[1] - mid }, mid / 2);
			arr[MidRD[0]][MidRD[1]] = 2;
			doit(MidRD,  new int[] { pnt1[0] + mid, pnt1[1] + mid }, new int[] { pnt2[0], pnt2[1] }, mid / 2);
			doit(target, new int[] { pnt1[0], pnt1[1] + mid }, new int[] { pnt2[0] - mid, pnt2[1] }, mid / 2);
			break;
		case 3:
			arr[MidRU[0]][MidRU[1]] = 3;
			doit(MidRU,  new int[] { pnt1[0], pnt1[1] + mid }, new int[] { pnt2[0] - mid, pnt2[1] }, mid / 2);
			arr[MidRD[0]][MidRD[1]] = 3;
			doit(MidRD,  new int[] { pnt1[0] + mid, pnt1[1] + mid }, new int[] { pnt2[0], pnt2[1] }, mid / 2);
			arr[MidLU[0]][MidLU[1]] = 3;
			doit(MidLU,  new int[] { pnt1[0], pnt1[1] }, new int[] { pnt2[0] - mid, pnt2[1] - mid }, mid / 2);
			doit(target, new int[] { pnt1[0] + mid, pnt1[1] }, new int[] { pnt2[0], pnt2[1] - mid }, mid / 2);
			break;
		case 4:
			arr[MidLU[0]][MidLU[1]] = 4;
			doit(MidLU,  new int[] { pnt1[0], pnt1[1] }, new int[] { pnt2[0] - mid, pnt2[1] - mid }, mid / 2);
			arr[MidRU[0]][MidRU[1]] = 4;
			doit(MidRU,  new int[] { pnt1[0], pnt1[1] + mid }, new int[] { pnt2[0] - mid, pnt2[1] }, mid / 2);
			arr[MidLD[0]][MidLD[1]] = 4;
			doit(MidLD,  new int[] { pnt1[0] + mid, pnt1[1] }, new int[] { pnt2[0], pnt2[1] - mid }, mid / 2);
			doit(target, new int[] { pnt1[0] + mid, pnt1[1] + mid }, new int[] { pnt2[0], pnt2[1] }, mid / 2);
			break;
		}
	}
}
