package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 모의_5658_보물상자비밀번호 {
	static int N, K;
	static char[] arr;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			ArrayList<Integer> array = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new char[N+(N/4)-1];
			String str = br.readLine();
			for (int i = 0; i < N; i++)
				arr[i+(N/4)-1] = str.charAt(i);
			for (int i = (N/4)-2; i >= 0; i--)
				arr[i] = arr[arr.length+i - (N/4 - 1)];
			//회전
			for (int i = (N/4)-1; i >= 0; i--) {
				String tempstr = "";
				for (int k = 0; k < 4; k++) {
					tempstr = "";
					for (int j = i + N/4*k; j < i + N/4*(k+1); j++)	tempstr += arr[j];
					int temp = Integer.valueOf(tempstr, 16);
					if(!array.contains(temp)) array.add(temp);
				}
			}
			Collections.sort(array);
			System.out.println("#" + test_case + " " + array.get(array.size()-K));
		}
	}
}
