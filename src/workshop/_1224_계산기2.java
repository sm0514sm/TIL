package workshop;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _1224_계산기2 {
			//SW_Expert는 Solution
	public static int isp(char token) {
		switch (token) {
		case '*':
			return 2;
		case '+':
			return 1;
		default:
			return 0;
		}
	}
	
	public static int icp(char token) {
		switch (token) {
		case '*':
			return 2;
		case '+':
			return 1;
		default:
			return 0;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1223.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			Stack<Character> stack = new Stack<Character>();
			int caselen = sc.nextInt();
			String text = sc.next();
			char[] resultText = new char[text.length()];
			int index = 0;
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) >= '0' && text.charAt(i) <= '9') {	//숫자면
					resultText[index++] = text.charAt(i); 
				}
				else {// 연산자면
					if(stack.size() == 0) stack.push(text.charAt(i));
					else {
						if(isp(stack.peek()) < icp(text.charAt(i)))
							stack.push(text.charAt(i));
						else {
							resultText[index++] = stack.pop();
							stack.push(text.charAt(i));
						}
					}
				}
			}
			while(stack.size() != 0) {
				resultText[index++] = stack.pop();
			}
//			System.out.println(Arrays.toString(resultText));
			
			Stack<Integer> calculateStack = new Stack<Integer>();
			for(int i = 0; i < resultText.length; i++) {
				if(resultText[i] >= '0' && resultText[i] <= '9') {	//숫자면
					calculateStack.push(resultText[i] - '0');
				}
				else {	//연산자면
					int val1 = calculateStack.pop();
					int val2 = calculateStack.pop();
					if(resultText[i] == '+')
						calculateStack.push(val1+val2);
					else if(resultText[i] == '*')
						calculateStack.push(val1*val2);
				}
			}
			int answer = calculateStack.pop();
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
