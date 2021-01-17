package __Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main
public class _2577_회전초밥_고 {
	static int N, d, k, c; // 접시 수, 초잡 종류, 연속 먹을 수, 쿠폰번호
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N + k - 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + k - 1; i++) {
			arr[i] = arr[i - N];
		}
		int ans = 0;

		int[] cnt = new int[d + 1];
		int count = 0;
		int idxL = 0;
		int idxR = k;

		for (int num = idxL; num < idxR; num++) {
			if (cnt[arr[num]] == 0)	count++;
			cnt[arr[num]]++;
		}

		if (cnt[c] == 0) ans = Math.max(ans, count+1);
		else   			 ans = Math.max(ans, count);
		
		for (; idxL < N - 1; idxL++, idxR++) {
			cnt[arr[idxL]]--;
			if(cnt[arr[idxL]] == 0)		count--;
			if(cnt[arr[idxR]] == 0)		count++;
			cnt[arr[idxR]]++;
			
			if (cnt[c] == 0) ans = Math.max(ans, count + 1);
			else   			 ans = Math.max(ans, count);
			
		}
		System.out.println(ans);
	}

}
