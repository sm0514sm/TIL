package jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1809_탑4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split("\\s");
		int[] top  = new int[N];
		int[] answer = new int[N];
		
		for (int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(temp[i]);
			for (int j = i-1; j >= 0; j--) {
				if(top[j] > top[i]) {
					answer[i] = j+1;
					break;
				}
				else {
					if(answer[j] != 0)
						j = answer[j];
					else {
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
