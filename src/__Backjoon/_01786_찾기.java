package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _01786_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] T = br.readLine().toCharArray(); // 본문 문자
		char[] P = br.readLine().toCharArray(); // 패턴 문자
		
		ArrayList<Integer> list = new ArrayList<>();
		int tLength = T.length, pLength = P.length;
		int[] fail = new int[pLength];

//		실패함수 만들기 : P(패턴)에서 다시 P를 찾는 형태로
//		해당 부분 문자열의 (접두사와 일치하는) 최대 접미사의 길이
		for (int i = 1, j = 0; i < pLength; i++) { // i : 접미사 포인터, j : 접두사포인터
			
			// j위치에서 틀리면 j-1위치까지는 맞았다는 이야기
			// fail[j-1] : j - 1 위치까지 일치하는 접미사의 길이  ====>>>> 이동해야하는 다음 비교 j위치
			while(j > 0 && P[i] != P[j]) j = fail[j - 1];
			
			if (P[i] == P[j]) fail[i] = ++j;
		}
		int cnt = 0;
//		i: 텍스트 포인터, j: 패턴포인터
//		i는 계속해서 증가함
		for (int i = 0, j = 0; i < tLength; i++) {
			while (j > 0 && T[i] != P[j]) j = fail[j - 1];
			if (T[i] == P[j]) {
				if (j == pLength - 1) { // 패턴의 끝까지 일치
					cnt++;
					j = fail[j];
					list.add(i-P.length+2);
				}else
					++j;
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
