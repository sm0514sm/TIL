package __SW_Expert;
import java.util.Scanner;

public class D4_4366_정식이의은행업무 {
	public static int make2Int(char[] cha) {
		int N = cha.length;
		int mul = 1;
		int sum = 0;
		for (int i = N-1; i >= 0; i--) {
			sum += (cha[i] - '0') * mul;
			mul *= 2;
		}
		return sum;
	}
	public static int make3Int(char[] cha) {
		int N = cha.length;
		int mul = 1;
		int sum = 0;
		for (int i = N-1; i >= 0; i--) {
			sum += (cha[i] - '0') * mul;
			mul *= 3;
		}
		return sum;
	}
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		next:
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			char[] search = {'0', '1', '2'};
			char[] num2 = sc.next().toCharArray();
			int[] availableNum2 = new int[num2.length];
			for (int i = 0; i < availableNum2.length; i++) {
				if(num2[i] == '0') {
					num2[i] = '1';
					availableNum2[i] = make2Int(num2);
					num2[i] = '0';
				}
				else {
					num2[i] = '0';
					availableNum2[i] = make2Int(num2);
					num2[i] = '1';
				}
			}
			char[] num3 = sc.next().toCharArray();
			for (int i = 0; i < num3.length; i++) {
				for (char sear : search) {
					if(num3[i] == sear) continue;
					char temp = num3[i];
					num3[i] = sear;	
					int tempNum = make3Int(num3);
					for (int availNum : availableNum2) {
						if(tempNum == availNum) {
							System.out.printf("#%d %d\n", test_case, tempNum);
							break next;
						}
					}
					num3[i] = temp;
				}
			}
		}
		sc.close();
	}
}
