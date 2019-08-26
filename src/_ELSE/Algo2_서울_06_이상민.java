package _ELSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_서울_06_이상민 {
	static int ROW = 0;
	static int COL = 0;
	static int[] rowCut, rowVal;
	static int[] colCut, colVal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		ROW = Integer.parseInt(st.nextToken());
		COL = Integer.parseInt(st.nextToken());
		int orderCnt = Integer.parseInt(br.readLine());	// 명령 개수
		int rowCutCnt = 0;	// 가로 자르기 명령 개수
		int colCutCnt = 0;	// 세로 자르기 명령 개수
		rowCut = new int[orderCnt];
		colCut = new int[orderCnt];
		for(int i = 0 ; i< orderCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if(command == 0)
				rowCut[rowCutCnt++] = Integer.parseInt(st.nextToken());
			else
				colCut[colCutCnt++] = Integer.parseInt(st.nextToken());
		}/*-----데이터 입력 완료------*/
		
		rowCut = Arrays.copyOf(rowCut, rowCutCnt); 	// 가로 자르기 명령 개수만큼만 다시 배열로
		colCut = Arrays.copyOf(colCut, colCutCnt); 	// 세로 자르기 명령 개수만큼만 다시 배열로
		rowVal = new int[rowCut.length + 1]; 	// 잘려서 나뉜 길이들 (0~4를 3에서 자르면 3-0 = 3과 4-3 = 1 이 저장됨)
		colVal = new int[colCut.length + 1];	// 잘려서 나뉜 길이들

		// 오름차순 정렬
		Arrays.sort(rowCut);
		Arrays.sort(colCut);
		
		setValArr(rowVal, COL, rowCut);	// rowVal 세팅
		setValArr(colVal, ROW, colCut); // colVal 세팅
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < rowVal.length; i++)
			for(int j = 0; j < colVal.length; j++) 
				max = Math.max(max, rowVal[i]*colVal[j]);
		
		System.out.println(max);
	}

	/* Val 배열(rowVal, colVal) 설정 */
	private static void setValArr(int[] Val, int ROWCOL, int[] Cut) {
		int prev = 0;
		for(int i = 0; i < Cut.length+1; i++) {
			if(i == Cut.length) {
				Val[i] = ROWCOL - prev;
			}
			else {
				Val[i] = Cut[i]-prev;
				prev = Cut[i];
			}
		}
	}
	
}
/*
10 8
3
0 3
1 4
0 2

50 50
4
0 45
0 30
0 29
0 48
 */

