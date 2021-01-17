package _ELSE;

public class hyundaeMobis1 {
	
	public static int solution(int n, int[] P) {
		int prev = Integer.MAX_VALUE;
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
			if(prev > P[i]) {
				prev = P[i];
				answer += prev;
			}
			else {
				answer += prev;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(10, new int[] {5, 4, 3, 2, 1, 6, 7, 8, 9, 10}));
		System.out.println(solution(10, new int[] {5, 7, 8, 2, 4, 6, 1, 8, 9, 10}));
	}

}
