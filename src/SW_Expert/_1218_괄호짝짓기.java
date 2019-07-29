package SW_Expert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class _1218_괄호짝짓기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("1218.txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 1;
			Stack<Character> stack = new Stack<Character>();
			int num = sc.nextInt();
			sc.nextLine();
			String text = sc.nextLine();
			FOR_LOOP:
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == '<' || text.charAt(i) == '(' || text.charAt(i) == '[' || text.charAt(i) == '{')
					stack.push(text.charAt(i));
				else {
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
		
		
		sc.close();
		
		
	}

}
