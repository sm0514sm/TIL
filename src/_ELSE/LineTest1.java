package _ELSE;

import java.util.PriorityQueue;
import java.util.Scanner;

//Solution
public class LineTest1 {
	public static class CON implements Comparable<CON> {
		int endtime;
		
		public CON(int endtime) {
			this.endtime = endtime;
		}

		public int compareTo(CON o) {
			return Integer.compare(this.endtime, o.endtime);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int consum = sc.nextInt();
		PriorityQueue<CON> consumers = new PriorityQueue<>();
		for (int i = 0; i < consum; i++) {
			consumers.offer(new CON(0));
		}
		
		int time = 0;
		for (int i = 0; i < M; i++) {
			int msgCnt = sc.nextInt();
			CON temp = consumers.poll();
			temp.endtime += msgCnt;
			consumers.add(temp);
		}
		while(!consumers.isEmpty())
			time = consumers.poll().endtime;
		System.out.println(time);
	}
}