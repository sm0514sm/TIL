package workshop_0806;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22, 100, 1 };
		System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length)));
	}

	private static int[] mergeSort(int[] arr, int L, int R) {
		if(arr.length == 1) return arr;
		
		R -= L;	L -= L;
		
		int mid = (L + R) / 2;
		int[] left = Arrays.copyOfRange(arr, L, mid);
		int[] right = Arrays.copyOfRange(arr, mid, R);

		return merge(mergeSort(left, 0, mid), mergeSort(right, mid, R));
	}

	private static int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length];
		int pointL = 0;
		int pointR = 0;
		
		for(int i = 0; i < merged.length; i++) {
			if(pointL == left.length) 	// 왼쪽 배열이 모두 들어갔다면 오른쪽 나머지 추가
				merged[i] = right[pointR++];
			
			else if(pointR == right.length)  // 오른쪽 배열이 모두 들어갔다면 왼쪽 나머지 추가
				merged[i] = left[pointL++];
			
			else 	// 두 배열 모두 아직 다 안들어갔다면 비교해서 추가
				merged[i] = left[pointL] > right[pointR]? right[pointR++] : left[pointL++];
		}
		
		return merged;
	}

	
	
}
