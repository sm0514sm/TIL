package SW_Expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 1;
			Stack<Character> stack = new Stack<Character>();
			int num = Integer.parseInt(br.readLine());
			String text = br.readLine();
			
			FOR_LOOP:
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == '<' || text.charAt(i) == '(' || text.charAt(i) == '[' || text.charAt(i) == '{')
					stack.push(text.charAt(i));
				else {
					if(stack.isEmpty()) {
						answer = 0;
						break;
					}
					switch (text.charAt(i)) {
					case '>':
						if(stack.pop() != '<') {
							answer = 0;
							break FOR_LOOP;
						}
						break;
					case ')':
						if(stack.pop() != '('){
							answer = 0;
							break FOR_LOOP;
						}
						break;
					case ']':
						if(stack.pop() != '['){
							answer = 0;
							break FOR_LOOP;
						}
						break;
					case '}':
						if(stack.pop() != '{'){
							answer = 0;
							break FOR_LOOP;
						}
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
		
		br.close();
	}
}
