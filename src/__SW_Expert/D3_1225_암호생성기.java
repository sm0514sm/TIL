package __SW_Expert;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_1225_암호생성기 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_1225.txt"));
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		next_case:
		for(int i = 0; i < 10; i ++) {
			queue.clear();
			sc.nextInt();
			for(int j = 0; j < 8; j++)	queue.offer(sc.nextInt());

			while (true) {
				for (int j = 1; j <= 5; j++) {
					int temp = queue.poll() - j;
					if (temp <= 0) {
						temp = 0;
						queue.offer(temp);
						System.out.print("#" + (i + 1) + " ");
						for (int k = 0; k < 8; k++)
							System.out.print(queue.poll() + " ");
						System.out.println();
						continue next_case;
					}
					queue.offer(temp);
				}
			} // END while
		}
		sc.close();
	}

}
