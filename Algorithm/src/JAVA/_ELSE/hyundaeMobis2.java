package _ELSE;

import java.util.PriorityQueue;

public class hyundaeMobis2 {
	static class Car implements Comparable<Car>{
		String name;
		int odo;
		
		public Car(String name, int odo) {
			this.name = name;
			this.odo = odo;
		}
		
		public int compareTo(Car o) {
			int result = odo - o.odo;
			return result == 0? name.compareTo(o.name) : result;
		}

		@Override
		public String toString() {
			return "Car [name=" + name + ", odo=" + odo + "]";
		}
		
		
	}
    public static String solution(int n, String[] plates, int[] odo, int k, int[] drives) {
        PriorityQueue<Car> pQ = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
        	pQ.offer(new Car(plates[i], odo[i]));
        for (int i = 0; i < k; i++) {
			Car pop = pQ.poll();
			pop.odo += drives[i];
			pQ.add(pop);
		}
        
        return pQ.poll().name;
    }

	public static void main(String[] args) {
		System.out.println(solution(6, new String[] {"AZ3618", "XP9657", "SP6823", "UH7515", "TV6621", "WZ8264"}
									, new int[] {20, 16, 18, 20, 24, 19}, 8, new int[] {3, 7, 5, 8, 6, 5, 10, 2}));
	}

}
