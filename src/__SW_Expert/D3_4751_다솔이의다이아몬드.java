package __SW_Expert;
import java.util.Scanner;

public class D3_4751_다솔이의다이아몬드 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			String word = sc.next();
			String result = "";
			for (int i = 0; i < word.length(); i++)
				result += "..#.";
			result += ".\n";
			for (int i = 0; i < word.length(); i++)
				result += ".#.#";
			result += ".\n";
			for (int i = 0; i < word.length(); i++)
				result += "#."+word.charAt(i) + ".";
			result += "#\n";
			for (int i = 0; i < word.length(); i++)
				result += ".#.#";
			result += ".\n";
			for (int i = 0; i < word.length(); i++)
				result += "..#.";
			result += ".";
			System.out.println(result);
		}
		sc.close();
	}
}
//2
//D
//APPLE
