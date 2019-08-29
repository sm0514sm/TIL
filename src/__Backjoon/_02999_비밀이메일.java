package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Main
public class _02999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String encrypt = br.readLine();
		String decrypt = "";
		int size = encrypt.length();
		int max = 1;
		for (int i = 2; i <= size / 2; i++)
			if (size % i == 0 && size / i >= i)
				max = i;
		int R = max;
		int C = size / max;
		int cnt = 0;
		char[][] arr = new char[R][C];
		for (int j = 0; j < C; j++)
			for (int i = 0; i < R; i++)
				arr[i][j] = encrypt.charAt(cnt++);
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				decrypt += arr[i][j];
		System.out.println(decrypt);
	}
}
