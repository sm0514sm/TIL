package _SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1240_단순2진암호코드 {
	
	public static int findValue(int num) {
		int value = 0;
		switch (num) {
		case 13:
			value = 0;	break;
		case 25:
			value = 1;	break;
		case 19:
			value = 2;	break;
		case 61:
			value = 3;	break;
		case 35:
			value = 4;	break;
		case 49:
			value = 5;	break;
		case 47:
			value = 6;	break;
		case 59:
			value = 7;	break;
		case 55:
			value = 8;	break;
		case 11:
			value = 9;	break;
		}
		return value;
	}
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			String[] temp = br.readLine().split("\\s");
			int N = Integer.parseInt(temp[0]); // 세로크기
			int M = Integer.parseInt(temp[1]); // 가로크기
			
			String encrypt = null;
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				if(encrypt != null) continue;
				for(int j = M-1; j >= 0; j--) {
					if(line.charAt(j) == '1') {
						encrypt = line.substring(j+1-56, j+1);
						break;
					}
				}
			}
			int[] arr = new int[8];
			int count = 0;
			for(int i = 0; i < 56; i+=7) {
				arr[count++] = findValue(Integer.parseInt(encrypt.substring(i,i+7), 2));
			}
			int sum = 0;
			for(int i = 0; i < 8; i += 2) {
				sum+= arr[i];
			}
			sum *= 3;
			for(int i = 1; i < 8; i += 2) {
				sum+= arr[i];
			}
			if(sum % 10 == 0) {
				sum = 0;
				for(int i = 0; i < 8; i++)
					sum += arr[i];
			}
			else {
				sum = 0;
			}
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
