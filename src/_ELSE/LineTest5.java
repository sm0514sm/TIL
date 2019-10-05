package _ELSE;

import java.util.Scanner;
//Solution
public class LineTest5 {
	static int arr[][];
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int C = sc.nextInt(); // 가로
     int R = sc.nextInt(); // 세로
     int big = Math.max(C, R);
     arr = new int[big*2+1][big*2+1];
     int conyC = sc.nextInt(); // 코니 가로위치
     int conyR = sc.nextInt(); // 코니 세로위치
     for (int i = 0; i <= Math.min(conyR + conyC, big*2); i++) {
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j == i)
					arr[i][j] = 1;
				else {
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}
				arr[j][i] = arr[i][j];
			}
		}
     
     System.out.println(conyC + conyR);
     System.out.println(arr[conyC+conyR][Math.min(conyC, conyR)]);
 }
}