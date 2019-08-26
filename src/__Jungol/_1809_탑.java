package __Jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1809_탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());	
		String[] temp = br.readLine().split("\\s");
		int[] top  = new int[N];	// 타워의 높이
		int[] answer = new int[N];	// answer[i] = i번째 타워 레이저 수신 타워
		
		for (int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(temp[i]);	// 하나씩 입력받기
			for (int j = i-1; j >= 0; j--) {	// 현재보는 타워의 왼쪽부터 차례대로
				if(top[j] > top[i]) {			// 왼쪽의 타워가 더 높은 경우
					answer[i] = j+1;
					break;
				}
				else {
					if(answer[j] != 0)			// 왼쪽의 타워가 높지 않지만 수신 타워가 있다면
						j = answer[j];			// 비교할 타워를 위의 수신 타워로
					else {						// 왼쪽의 타워가 더 낮은데도 수신 타워가 없다면 현재 타워도 수신 타워 없음
						answer[i] = 0;
						break;
					}
				}
			}
			bw.write(answer[i] + " ");
		}
		bw.flush();
		bw.close();
	}
}
