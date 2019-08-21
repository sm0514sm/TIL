package _SW_Expert;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D3_1215_회문1 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			Queue<Character> Q = new LinkedList<Character>();
			int len = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			for(int i = 0; i < 8; i++)
				arr[i] = br.readLine().toCharArray();
			for(int i = 0; i < 8; i++) {
				Q.clear();
				char lastOffer = ' ';
				for(int j = 0; j < 8; j++) {
					if(Q.size() != len) {
						Q.offer(arr[i][j]);
						lastOffer = arr[i][j];
						continue;
					}
					// len과 같다면
					for(int k = 0; k < len/2; k++) {
//						if(Q.)
					}
				}
			}
			
		}
	}
}
