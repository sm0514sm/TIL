package __SW_Expert;

import java.util.Scanner;

public class D3_8104_조만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int N = sc.nextInt();	// 조 인원
			int K = sc.nextInt();	// 조 개수
			int[] sum = new int[K];
			int num = 1;
			for(int i = 0; i < N; i++) {
				if(i%2==0) {
					for(int k = 0; k < K; k++) {
						sum[k] += num;
						num++;
					}
				}else {
					for(int k = K-1; k >= 0; k--) {
						sum[k] += num;
						num++;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < K; i++)
				System.out.print(sum[i] + " ");
			System.out.println();
		}
		sc.close();
	}
}
