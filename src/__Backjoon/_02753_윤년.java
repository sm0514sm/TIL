package __Backjoon;
import java.util.Scanner;

//Main
public class _02753_윤년 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int a = sc.nextInt();
		if(a % 4 == 0) answer = 1;
		if(a % 100 == 0) answer = 0;
		if(a % 400 == 0 ) answer = 1;
		
		System.out.println(answer);
		sc.close();
	}
}
