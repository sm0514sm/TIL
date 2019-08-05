package _SW_Expert;

import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class _1210_Ladder1 {
    public static final int UP = 2;
    public static final int LEFT = 1;
    public static final int RIGHT = 0;
 
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int[][] dirLRD = { { 0, 1 }, { 0, -1 }, { -1, 0 } };
        for (int T = 1; T <= 10; T++) {
            sc.nextInt();
            int answer = 0;
            int[][] data = new int[100][100];
            // 데이터 입력
            for (int row = 0; row < 100; row++) {
                for (int col = 0; col < 100; col++) {
                    data[row][col] = sc.nextInt();
                }
            }
            int myRow = 99, myCol;
            for (int col = 0; col < 100; col++) {
                // 도착 지점이 아니면 다음
                if (data[myRow][col] != 2)
                    continue;
                int dir = UP;
                myCol = col;
 
                while (myRow != 0) {
                    if (dir == UP) {// 위로 가는 중
                        myRow += dirLRD[dir][0];
                        myCol += dirLRD[dir][1];
                        for (int i = 0; i < 2; i++) {
                            int nr, nc;
                            nr = myRow + dirLRD[i][0];
                            nc = myCol + dirLRD[i][1];
                            if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100) {
                                if (data[nr][nc] == 1) {
                                    myRow = nr;
                                    myCol = nc;
                                    dir = i;
                                    break;
                                }
                            }
                        }
                    }
                    else {  // 왼쪽이나 오른쪽으로 가는 중
                        int nr, nc;
                        nr = myRow + dirLRD[dir][0];
                        nc = myCol + dirLRD[dir][1];
                        if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100) {
                            if (data[nr][nc] == 1) {    // 길인 경우
                                myRow = nr;
                                myCol = nc;
                            }
                            else    dir = UP;           // 길이 아닌 경우
                        }
                        else dir = UP;
                    }
                }
                answer = myCol;
                break;
            }
            System.out.printf("#%d %d\n", T, answer);
        }
        sc.close();
    }
 
}