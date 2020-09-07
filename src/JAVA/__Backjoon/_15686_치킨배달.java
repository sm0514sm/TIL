package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//Main
public class _15686_치킨배달 {
	static int N, M, MIN;	// 맵크기, 남아있을 치킨집 개수
	static int[][] map;
	static ArrayList<int[]> chickens;
	static ArrayList<Person> people;
	
	static class Person{
		int r, c;
		int[] chickDif;
		
		public Person(int r, int c, int size) {
			this.r = r;
			this.c = c;
			this.chickDif = new int[size];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		people = new ArrayList<>();
		chickens = new ArrayList<>();
		MIN = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2)
					chickens.add(new int[] {i, j});
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 1) continue;
				Person person = new Person(i, j, chickens.size());
				for (int k = 0; k < chickens.size(); k++) {
					int[] chick = chickens.get(k);
					person.chickDif[k] = Math.abs(person.r - chick[0]) + Math.abs(person.c - chick[1]);
				}
				people.add(person);
			}
		}
		
		combi(-1, 0, 0);
		
		System.out.println(MIN);
	}

	private static void combi(int before, int index, int flag) {
		if(index == M) {
			int sum = 0;
			for (Person person : people) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < chickens.size(); i++) {
					if((flag & (1 << i)) > 0) {
						min = Math.min(min, person.chickDif[i]);
					}
				}
				sum += min;
			}
			MIN = Math.min(MIN, sum);
			return;
		}
		for (int i = before + 1; i < chickens.size(); i++) {
			combi(i, index + 1, flag | (1 << i));
		}
	}
}
