package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_2805_농작물수확하기 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			
			int start = N/2;
			int readCount = 1;
			
			for(int i=0; i < N/2; i++) {
				String tempLine = br.readLine();
				for(int j = 0; j < readCount; j++) 	answer += Integer.parseInt(tempLine.charAt(start + j)+"");
				start--;
				readCount += 2;
			}
			// 모두 더하기
			String tempLine = br.readLine();
			for(int j = 0; j < N; j ++)				answer += Integer.parseInt(tempLine.charAt(j)+"");
			for(int i=N/2 +1 ; i < N; i++) {
				readCount -= 2;
				start++;
				tempLine = br.readLine();
				for(int j = 0; j < readCount; j++) 	answer += Integer.parseInt(tempLine.charAt(start + j)+"");
			}
			
			bw.write("#"+test_case+" "+answer+"\n");
			bw.flush();
		}
	}

}
