package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_5672_Professional_올해의조련사 {
	static char[] arr;
	static int N;
	static int left, right;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			N = Integer.parseInt(br.readLine());
			left = 0;
			right = N-1;
			arr = new char[N];
			for (int i = 0; i < N; i++)	arr[i] = br.readLine().charAt(0);
			
			while(left <= right) {
				if(arr[left] < arr[right]) {
					sb.append(arr[left]+"");
					left++;
				}
				else if(arr[left] > arr[right]) {
					sb.append(arr[right]+"");
					right--;
				}
				else {
					int tempL = left, tempR = right;
//					while(tempL < right && arr[tempL] >= arr[right])	tempL++;
//					while(tempR >= 0 && arr[tempR] >= arr[left])		tempR--;
//					if(tempL-left < right-tempR) {
//						sb.append(arr[left] + "");
//						left++;
//					}
//					else if(tempL-left >= right-tempR) {
//						sb.append(arr[right] + "");
//						right--;
//					}
					while(tempL+1 < N && tempR-1 >= 0 && 
							arr[tempL++] == arr[tempR--]);
					if(arr[tempL] < arr[tempR]) {
						sb.append(arr[left] + "");
						left++;
					}
					else {
						sb.append(arr[right] + "");
						right--;
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
/*
3
6
A
A
A
A
B
A
10
F
F
F
F
F
A
F
B
F
F
3
A
C
B

*/