package Backjoon;

import java.util.Scanner;

public class _1074_Z {
	public static int count = 0;
	public static int answer;
	public static int r, c;
	public static void Z(int size, int row, int col) {
		if(size == 2) {
			if(row == r && col == c) {
				answer = count;
				return;
			}
			count++;
			
			if(row == r && col+1 == c) {
				answer = count;
				return;
			}
			count++;
			
			if(row+1 == r && col == c) {
				answer = count;
				return;
			}
			count++;
			
			if(row+1 == r && col+1 == c) {
				answer = count;
				return;
			}
			count++;
			return;
		}
		else {
			Z(size/2, row, 			col         );
			Z(size/2, row, 			col + size/2);
			Z(size/2, row + size/2, col         );
			Z(size/2, row + size/2, col + size/2);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int size = (int) Math.pow(2, N);
		Z(size, 0, 0);
		System.out.println(answer);
		sc.close();
	}

}
