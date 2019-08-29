package __Backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//Main
public class _17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		String temp = new BufferedReader(new InputStreamReader(System.in)).readLine();
		Stack<Character> stack = new Stack<>();
		boolean stackOn = true;
		for (int i = 0; i < temp.length(); i++) {
			if(temp.charAt(i) == '<') {
				stackOn = false;
				while(stack.size() != 0)
					System.out.print(stack.pop() + "");
			}
			else if(temp.charAt(i) == ' ') {
				while(stack.size() != 0)
					System.out.print(stack.pop() + "");
				System.out.print(" ");
				continue;
			}
			if(!stackOn)
				System.out.print(temp.charAt(i) + "");
			else {
				stack.push(temp.charAt(i));
			}
			if(i == temp.length()-1) {
				while(stack.size() != 0)
					System.out.print(stack.pop() + "");
				System.out.print(" ");
				continue;
			}
			if(temp.charAt(i) == '>') {
				stackOn = true;
			}
		}
	}
}
