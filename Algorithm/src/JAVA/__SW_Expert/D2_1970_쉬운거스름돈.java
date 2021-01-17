package __SW_Expert;
import java.util.Scanner;

public class D2_1970_쉬운거스름돈 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int[] arr = new int [8];
			int N = sc.nextInt();
			while(N >= 50000) {	N -= 50000;	arr[0]++;}
			while(N >= 10000) {	N -= 10000;	arr[1]++;}
			while(N >= 5000) {	N -= 5000;	arr[2]++;}
			while(N >= 1000) {	N -= 1000;	arr[3]++;}
			while(N >= 500) {	N -= 500;	arr[4]++;}
			while(N >= 100) {	N -= 100;	arr[5]++;}
			while(N >= 50) {	N -= 50;	arr[6]++;}
			while(N >= 10) {	N -= 10;	arr[7]++;}
			
			System.out.println("#" + test_case);
			for(int i = 0; i < 8; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
		sc.close();
	}
}
