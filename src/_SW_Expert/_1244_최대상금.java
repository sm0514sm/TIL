package _SW_Expert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class _1244_최대상금 {
	static int[] swapIndexArr;
	static char[] arr, origArr, saveArr;
	static int strLen, max;
			//SW_Expert는 Solution
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1244.txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			strLen = 0;
			max = 0;
			String temp = sc.next();
			strLen = temp.length();
			int swapCnt = sc.nextInt();
			swapIndexArr = new int[2];
			arr = temp.toCharArray();
			origArr = arr.clone();
			
			max = Math.max(max, getValue(arr));
			for(int i = 0; i < swapCnt; i++) {
				combi(1, 0);
				origArr = saveArr.clone();
			}
			answer = max;
			System.out.printf("#%d %d\n", test_case, answer);
//			break;
		}
		sc.close();
	}
	
	public static void combi(int before, int index) {
		if(index == 2) {
			arr = origArr.clone();
			swap(swapIndexArr[0]-1, swapIndexArr[1]-1);
			int temp = getValue(arr);
			if (max <= temp) {
				max = temp;
				saveArr = arr.clone();
			}
			return;
		}
		for(int i = before ; i <= strLen; i++) {
			swapIndexArr[index] = i;
			combi(i, index + 1);
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
