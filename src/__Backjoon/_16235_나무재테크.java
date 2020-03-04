package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//Main
public class _16235_나무재테크 {
	static int N, M, K;	// 배열크기, 초기 나무 수, K년 지난 후
	static int[][] DIR = {{1,1}, {1,0}, {1,-1}, {0,1}, {0, -1}, {-1,1}, {-1,0}, {-1, -1}};
	static Space[][] map;
	static ArrayList<Tree> arboretum;
	static ArrayList<Tree> tempTrees;
	static Queue<DieFood> dieFoods;	// 봄에 죽은 양분들이 여름에 추가될 리스트
	
	static class Tree implements Comparable<Tree>{
		int r, c;
		int age;
		
		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}
		
		/*In the Spring*/
		public boolean eatFood() {	// 양분 충분해서 성장하면 true, 죽으면 false
			if(map[r][c].food < age) {
				dieFoods.offer(new DieFood(r, c, age/2)); // 소수점 아래는 버리는데 맞나?
				M--;
				return false;
			}
			map[r][c].food -= age;
			age++;
			return true;
		}
		
		/*In the Autumn*/
		public void doBreed() {
			if(age % 5 != 0) return;	// 아직 번식할 수 없어요
			for (int i = 0; i < 8; i++) {
				int nr = r + DIR[i][0];
				int nc = c + DIR[i][1];
				if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
				M++;
				tempTrees.add(new Tree(nr, nc, 1));
			}
		}
		
		@Override
		public String toString() {
			return "(" + r + ", " + c + ") age=" + age;
		}

		@Override
		public int compareTo(Tree o) {
			return age - o.age;
		}
	}
	
	static class DieFood{
		int r, c;
		int food;
		
		public DieFood(int r, int c, int food) {
			this.r = r;
			this.c = c;
			this.food = food;
		}
		
		/*In the Summer*/
		public void add() {
			map[r][c].food += food;
		}
	}
	
	static class Space{
		int food;		// 현재 양분
		int addFood;	// 겨울에 더해질 양분
		
		public Space(int addFood) {
			this.food = 5;
			this.addFood = addFood;
		}

		@Override
		public String toString() {
			return food + " ";
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Space[N][N];
		arboretum = new ArrayList<>();	// 수목원이란 뜻
		
		dieFoods = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = new Space(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			arboretum.add(new Tree(r, c, age));
		}
		/*-------------입력 끝-----------------*/
		for (int year = 0; year < K; year++) {
			tempTrees = new ArrayList<>();	// 수목원이란 뜻
			for(Tree tree: arboretum)
				tempTrees.add(tree);
			
			Collections.sort(tempTrees);
			Spring();
			Summer();
			Autumn();
			Winter();
			
			arboretum = new ArrayList<>();
			for(Tree tree: tempTrees) {
				if(tree.age != -1)
					arboretum.add(tree);
			}
		}
		System.out.println(M);
	}

	private static void Spring() {
		for (int i = 0; i < tempTrees.size(); i++) {
			Tree one = tempTrees.get(i);
			if(!one.eatFood())	{ // 양분이 부족해..
				one.age = -1;
			}
		}
	}

	private static void Summer() {
		while(!dieFoods.isEmpty()) {
			DieFood one = dieFoods.poll();
			one.add();	// 양분에 더하기
		}
	}

	private static void Autumn() {
		int treeCnt = tempTrees.size();
		for (int i = 0; i < treeCnt; i++)
			tempTrees.get(i).doBreed();
	}

	private static void Winter() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++) 
				map[i][j].food += map[i][j].addFood;
	}
}