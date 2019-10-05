package _ELSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Solution
public class LineTest2 {
	static int[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			arr.add(Integer.parseInt(st.nextToken()));
		int num = Integer.parseInt(br.readLine());
		int cnt = 0;
		order = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			order[i] = i;
		}
		
		while(nextPer()) {
			cnt++;
			if(cnt == num) break;
		}
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(order[i]) + "");
		}
	}

	private static boolean nextPer() {
		int i = order.length-1;
		while(i > 0 && order[i-1] >= order[i]) i--;
		if(i == 0) return false;
		
		int j = order.length-1;
		while(order[i-1] >= order[j] ) j--;
		swap(i-1, j);
		
		j = order.length - 1;
		while(i < j) swap(i++, j--);
		return true;
	}

	private static void swap(int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}
}