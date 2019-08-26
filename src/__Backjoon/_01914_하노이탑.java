package __Backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class _01914_하노이탑 {
	static BufferedWriter bw ;
    static int top;
	public static void hanoi(int from, int temp, int goal, int top) throws IOException {
		if (top == 1) 	{
			bw.write(from + " " + goal + "\n");
			return;
		}
		
		// 내 위의 것들 temp에 옮기기
		hanoi(from, goal, temp, top - 1);
		// 내가 골로 가기
		bw.write(from + " " + goal + "\n");
		// 나머지 다시 옮기기
		hanoi(temp, from, goal, top - 1);
	}

	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		top = sc.nextInt();
		int total = 0;
		BigInteger bigNum2 = BigInteger.ONE;

        for(int i = 0; i < top ; i++)
        	bigNum2 = bigNum2.multiply(new BigInteger("2"));    // 곱하기
        bigNum2 = bigNum2.subtract(new BigInteger("1"));
        
		bw.write(bigNum2+"\n");
		if(top <= 20) {
            hanoi(1, 2, 3, top);
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}
