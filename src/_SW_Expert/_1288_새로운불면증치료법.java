package _SW_Expert;
import java.util.Scanner;

public class _1288_새로운불면증치료법 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			boolean[] numbers = new boolean[10];
			boolean isAllClear = false;
			int answer = 0;
			int N = sc.nextInt();
			int oriN = N;
			
			while(!isAllClear) {
				String Nstring = N + "";
				for(int i = 0; i < Nstring.length(); i++) {
					numbers[(int)(Nstring.charAt(i) - 48)] = true;
				}
				for(int i = 0; i < 10; i++) {
					if(numbers[i] == false) {
						isAllClear = false;
						break;
					}
					isAllClear = true;
					answer = N;
				}
				N += oriN;
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
