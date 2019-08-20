package _SW_Expert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3_1244_최대상금 {
	static int[] swapIndexArr;
	static char[] arr;
	static int strLen, max, swapCnt;
		//SW_Expert는 Solution
	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_1244.txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			strLen = 0;
			max = 0;
			String temp = sc.next();
			strLen = temp.length();
			swapCnt = sc.nextInt();
			arr = temp.toCharArray();
			
			max = 0;
			combination(0, 0);
			answer = max;
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
	
	private static void combination(int index, int cnt) {
	    if (cnt == swapCnt) {
	        max = Math.max(max, getValue(arr));
	        return;
	    }

	    for (int i = index; i < strLen; i++) {
	    	for(int j = i +1; j < strLen; j++) {
	    		if(isDecrease(index) || arr[i] <= arr[j]) {
			    	swap(i, j);
			        combination(index, cnt+1);
			        swap(i, j);
	    		}
	    	}
	    }
	}
	
	public static boolean isDecrease(int index) {
		for(int i = index + 1 ; i < strLen; i++) {
			if(arr[i] > arr[i-1])
				return false;
		}
		return true;
	}
	
	public static int getValue(char[] arr) {
		int answer = 0;
		int mul = 1;
		for(int i = arr.length -1; i >= 0 ; i--) {
			answer += mul * (arr[i]-'0');
			mul *= 10;
		}
		return answer;
	}
	
	public static void swap(int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
