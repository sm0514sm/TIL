import java.util.ArrayList;
import java.util.Collections;

public class Solution_2번문제 {
	public static int solution(int[] prices) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> st = new ArrayList<Integer>();
		st.add(prices[0]);
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] >= st.get(st.size()-1))
				st.add(prices[i]);
			else {
				while(st.size() > 1 && st.get(st.size()-1) > prices[i]) {
					int a = st.get(0);
					int b = st.get(st.size() - 1);
					list.add(b-a);
					st.remove(st.size()-1);
					st.remove(0);
				}
				st.clear();
				st.add(prices[i]);
			}
		}
		while(st.size() > 1) {
			int a = st.get(0);
			int b = st.get(st.size() - 1);
			list.add(b-a);
			st.remove(st.size()-1);
			st.remove(0);
		}

		Collections.sort(list);
		int ans = 0;
		for (int i = list.size() - 1, cnt = 0; i >= 0 && cnt < 2; i--, cnt++) {
			ans += list.get(i);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
		System.out.println(solution(new int[] { 1, 2, 4, 1, 2, 3 }));
		System.out.println(solution(new int[] { 4, 3, 2, 1, 4 }));
		System.out.println(solution(new int[] { 4, 3, 2, 1 }));
		System.out.println(solution(new int[] { 1, 10, 5, 11, 7 }));
		System.out.println(solution(new int[] { 9, 10, 1, 1, 5, 6 }));
		System.out.println(solution(new int[] { 1, 2, 10, 11, 4, 5, 6 }));
	}

}
