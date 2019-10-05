package _ELSE;

import java.util.Scanner;
// Solution
public class LineTest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int zeroCntMax = 0;
        int[] arr = new int[N];
        int zeroCnt = 0;
        boolean startOn = false, endOn = false;
        for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
        for (int i = 0; i < N; i++) {
			if(arr[i] == 0) {
				zeroCnt++;
			}
			else {
				zeroCntMax = Math.max(zeroCntMax, zeroCnt);
				zeroCnt = 0;
			}
		}
        if(arr[0] == 0) {
        	zeroCnt = 0;
        	for (int i = 0; i < N; i++) {
    			if(arr[i] == 0) zeroCnt+=2;
    			else {
    				zeroCntMax = Math.max(zeroCntMax, zeroCnt);
    				break;
    			}
    		}
        }
        if(arr[N-1] == 0) {
        	zeroCnt = 0;
        	for (int i = N-1; i >= 0; i--) {
    			if(arr[i] == 0) zeroCnt+=2;
    			else {
    				zeroCntMax = Math.max(zeroCntMax, zeroCnt);
    				break;
    			}
    		}
        }
        if(zeroCntMax % 2 == 1)
        	zeroCntMax++;
        System.out.println(zeroCntMax/2);
    }
}