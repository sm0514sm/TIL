package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D2_1928_Base64Decoder {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			byte[] buf;
			String text = br.readLine();
			byte[] byteText = text.getBytes();
			buf = new byte[3];
			for(int i = 0; i < text.length(); i++) {
				buf[i%3] = byteText[i];
				if(i % 3 == 2) {
					System.out.print(buf[i%3-2] >>> 2);
					System.out.print(" ");
					System.out.print(buf[i%3-2] << 6 >>> 2 | buf[i%3-1] >>> 4);
					System.out.print(" ");
					System.out.print(buf[i%3-1] << 4 >>> 2 | buf[i%3-0] >>> 0);
					System.out.print(" ");
					System.out.print(buf[i%3-2] << 2 >>> 2);
				}
				System.out.println();
			}	
			
			
			
			bw.write(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
