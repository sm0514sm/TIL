package __Backjoon;

//Main
public class _15596_정수N개의합 {
	public static long sum(int[] a) {
		int size = a.length;
		long sum = 0;
		for (int i = 0; i < size; i++) {
			sum+=a[i];
		}
		return sum;
	}
}
