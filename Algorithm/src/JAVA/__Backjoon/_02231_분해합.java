package __Backjoon;
import java.util.Scanner;

//Main
public class _02231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int n = sc.nextInt();
		for (int i = 1; i < n; i++) {
			int tempsum = 0;
			tempsum += i; 
			char[] nchar = (i + "").toCharArray();
			for (int j = 0; j < nchar.length; j++)
				tempsum += nchar[j] - '0';
			if(tempsum == n) {
				answer = i;
				break;
			}
		}
		
		
		
		
		System.out.printf("%d\n", answer);
		sc.close();
	}
}
