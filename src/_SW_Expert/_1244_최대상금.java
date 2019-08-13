package _SW_Expert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _1244_최대상금 {
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
			swapIndexArr = new int[2];
			arr = temp.toCharArray();
			
			max = Math.max(max, getValue(arr));
			combination(0, 0, arr, 1);
			answer = max;
			System.out.printf("#%d %d\n", test_case, answer);
//			break;
		}
		sc.close();
	}
	private static void combination(int before, int index, char[] arr, int cnt) {
	    if (index == 2) {
	    	String temp = "";
	        for(int i = 0; i < strLen; i++) {
	        	if(swapIndexArr[0] -1 == i)
	        		temp += (arr[swapIndexArr[1]- 1]);
	        	else if(swapIndexArr[1]- 1 == i)
	        		temp += (arr[swapIndexArr[0]-1]);
	        	else
	        		temp += (arr[i]);
	        }
	        System.out.println(temp);
	        max = Math.max(max, Integer.parseInt(temp));
	        if(cnt != swapCnt)
	        	combination(0, 0, temp.toCharArray(), cnt+1);
	        return;
	    }

	    for (int i = before + 1; i <= strLen; i++) {
	    	swapIndexArr[index] = i;
	        combination(i, index + 1, arr, cnt);
	    }
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
