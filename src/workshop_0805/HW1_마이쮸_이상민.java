package workshop_0805;

import java.util.LinkedList;
import java.util.Queue;

public class HW1_마이쮸_이상민 {
	
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] count = new int[20];		
		// 마이쮸 받을 사람 수를 만들어야하는데 큐에 이거까지 집어넣으면 효율성 증가
		int MAX_ZZU = 20;
		int who = 1;
		int pop = 0;
		
		queue.offer(1);
		
		while(MAX_ZZU >= 0) {
			pop = queue.poll();
			count[pop]++;
			MAX_ZZU -= count[pop];
			queue.offer(pop);
			queue.offer(++who);
		}
		System.out.println("마지막 마이쮸 가져간 사람 : " + pop);
	}

}
