package __SW_Expert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D4_4261_빠른휴대전화키패드 {
	static String numStr;
	static Map<Character, Integer> map = new HashMap<>();
	static int N, ans;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.gc();
		map.put('a', 2);	map.put('b', 2);	map.put('c', 2);
		map.put('d', 3);	map.put('e', 3);	map.put('f', 3);
		map.put('g', 4);	map.put('h', 4);	map.put('i', 4);
		map.put('j', 5);	map.put('k', 5);	map.put('l', 5);
		map.put('m', 6);	map.put('n', 6);	map.put('o', 6);
		map.put('p', 7);	map.put('q', 7);	map.put('r', 7);	map.put('s', 7);
		map.put('t', 8);	map.put('u', 8);	map.put('v', 8);
		map.put('w', 9);	map.put('x', 9);	map.put('y', 9);	map.put('z', 9);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			numStr = st.nextToken();
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				char[] temp = st.nextToken().toCharArray();
				String str = "";
				for (int j = 0; j < temp.length; j++) {
					str += map.get(temp[j]);
				}
				if(str.equals(numStr)) ans++;
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
