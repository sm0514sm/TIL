package workshop_0806;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22, 100, 1 };
		System.out.println("	원본 : " + Arrays.toString(arr));
		System.out.println("상민	구현 : " + Arrays.toString(mergeSortSM(arr, 0, arr.length))); // 상민 구현
		System.out.println("	원본 : " + Arrays.toString(arr));
		mergeSortTC(arr, 0, arr.length - 1);
		System.out.println("  쌤	구현 : " + Arrays.toString(arr));
	}
	/*------------- 상민 구현 ---------------------------*/
	private static int[] mergeSortSM(int[] arr, int L, int R) {
		if(arr.length == 1) return arr;
		
		R -= L;	L -= L;
		
		int mid = (L + R) / 2;
		int[] left = Arrays.copyOfRange(arr, L, mid);
		int[] right = Arrays.copyOfRange(arr, mid, R);

		return mergeSM(mergeSortSM(left, 0, mid), mergeSortSM(right, mid, R));
	}

	private static int[] mergeSM(int[] left, int[] right) {
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

	/*------------- 쌤 구현 ---------------------------*/
	public static void mergeSortTC(int[] list, int start, int end) {
		if (start == end)
			return;
		// 현집합을 반으로 나누어 정렬
		int half = (start + end) / 2;

		// 왼쪽 집합 정렬해오기
		mergeSortTC(list, start, half);
		// 오른쪽집합 정렬해오기
		mergeSortTC(list, half + 1, end);

		// 정렬된 두 집합 이용하여 합치기
		mergeTC(list, start, half, end);
	}

	private static void mergeTC(int[] list, int start, int half, int end) {
		int newArr[] = new int[end - start + 1];
		int left = start, right = half + 1;
		int i = 0;

		do {
			if (list[left] < list[right]) {
				newArr[i++] = list[left++];
			} else
				newArr[i++] = list[right++];
		} while (left <= half && right <= end);
		
		while(left<=half) newArr[i++] = list[left++];	//   왼쪽 집합이 남은 경우
		while(right<=end) newArr[i++] = list[right++];	// 오른쪽 집합이 남은 경우
		
		System.arraycopy(newArr, 0, list, start, newArr.length);
	}

}
