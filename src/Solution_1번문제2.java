public class Solution_1번문제2 {
	static int R = 4;
	static int N = 0;
	static int max = 0;
	static int[] select;
	public static int solution(int[] prices) {
		max = 0;
		N = prices.length;
		
		R = 4;
		select = new int[R];
		combination_before(0, 0, prices);
		
		R = 2;
		select = new int[R];
		combination_before(0, 0, prices);
		return max;
	}

	private static void combination_before(int before, int index, int[] prices) {
		if(index == R) {
			if(R == 4) {
				max = Math.max(prices[select[1]] + prices[select[3]] - prices[select[0]] - prices[select[2]], max);
				max = Math.max(prices[select[2]] + prices[select[3]] - prices[select[0]] - prices[select[1]], max);
			}
			else if(R == 2) {
				max = Math.max(prices[select[1]] - prices[select[0]], max);
			}
			return;
		}
		for (int i = before; i < N; i++) {
			select[index] = i;
			combination_before(i + 1, index + 1, prices);
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }));						// 4
		System.out.println(solution(new int[] { 1, 2, 4, 1, 2, 3 }));				// 5
		System.out.println(solution(new int[] { 4, 3, 2, 1, 4 }));					// 3
		System.out.println(solution(new int[] { 4, 3, 2, 1 }));						// 0
		System.out.println(solution(new int[] { 1, 10, 5, 11, 7 }));				// 15
		System.out.println(solution(new int[] { 9, 10, 1, 1, 5, 6 }));				// 9
		System.out.println(solution(new int[] { 1, 2, 10, 11, 4, 5, 6 }));			// 18
		System.out.println(solution(new int[] { 1, 2, 10, 11, 8, 9, 12, 13 }));		// 22
	}

}
