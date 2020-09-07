import java.util.ArrayList;
import java.util.Collections;

public class Solution_1번문제 {
	public static boolean[] visited;
	static class obj implements Comparable<obj>{
		int one, two;
		int value;
		
		public obj(int one, int two, int value) {
			this.one = one;
			this.two = two;
			this.value = value;
		}

		@Override
		public int compareTo(obj o) {
			return this.value - o.value;
		}

		@Override
		public String toString() {
			return "obj [value=" + value + "]";
		}
		
		
	}
	public static int solution(int[] prices) {
		ArrayList<obj> list = new ArrayList<obj>();
		ArrayList<Integer> st = new ArrayList<Integer>();
		visited = new boolean[prices.length];
		st.add(prices[0]);
		for (int i = 1; i < prices.length; i++) {
			if(prices[i] >= st.get(st.size()-1))
				st.add(prices[i]);
			else {
				int num = 0;
				while(st.get(st.size()-1) > prices[i] && num < st.size()) {
					int a = st.get(num);
					int b = st.get(st.size() - 1);
					while(num != st.size() -1)
						list.add(new obj(num++, st.size()-1, b- a));
					st.remove(st.size()-1);
				}
				st.add(prices[i]);
			}
		}
		int num = 0;
		while(st.size() > num) {
			int a = st.get(num);
			int b = st.get(st.size() - 1);
			while(num != st.size() -1)
				list.add(new obj(num++, st.size()-1, b- a));
			st.remove(st.size()-1);
		}

		Collections.sort(list);
		int ans = 0;
		for (int i = list.size() - 1, cnt = 0; i >= 0 && cnt < 2; i--) {
			obj a = list.get(i);
			if(!visited[a.one] && !visited[a.two]) {
				ans += list.get(i).value;
				cnt++;
				visited[a.one] = true;
				visited[a.two] = true;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 1, 2, 3, 4 }));
//		System.out.println(solution(new int[] { 1, 2, 4, 1, 2, 3 }));
//		System.out.println(solution(new int[] { 4, 3, 2, 1, 4 }));
//		System.out.println(solution(new int[] { 4, 3, 2, 1 }));
		System.out.println(solution(new int[] { 1, 10, 5, 11, 7 }));
		System.out.println(solution(new int[] { 9, 10, 1, 1, 5, 6 }));
		System.out.println(solution(new int[] { 1, 2, 10, 11, 4, 5, 6 }));
		System.out.println(solution(new int[] { 1, 2, 10, 11, 8, 9, 12, 13 }));
	}

}
