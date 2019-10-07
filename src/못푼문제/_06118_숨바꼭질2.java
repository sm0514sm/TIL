// 못풀었엉


package 못푼문제;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _06118_숨바꼭질2 {
	static int N, M;
	static NODE[] arr;
	
	public static class NODE{
		ArrayList<Integer> able = null;

		public NODE() {
			able = new ArrayList<Integer>();
		}
		
		public void add(int additem) {
			able.add(additem);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new NODE[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			
			if(arr[temp1] == null)		arr[temp1] = new NODE();
			if(arr[temp2] == null)		arr[temp2] = new NODE();
			
			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}
		boolean[] visited = new boolean[N+1];
		int len = 0;
		int lastsize[] = new int[N+1];
		Queue<Integer> Q = new LinkedList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		Q.offer(1);
		visited[1] = true;
		LinkedList<Integer> templist  = new LinkedList<Integer>();
		while(!Q.isEmpty()) {
			len++;
			int size = Q.size();
			boolean isgood = false;
			for (int ss = 0; ss < size; ss++) {
				int num = Q.poll();
				for (int i = 1; i <= N; i++) {
					if(num == i || possible(num, i) == false || visited[i]) continue;
					visited[i] = true;
					Q.offer(i);
					list.add(i);
					isgood = true;
				}
			}
			lastsize[len] = Q.size();
			if(isgood) {
				templist.clear();
				for (int i = 0; i < list.size(); i++) {
					templist.add(list.get(i));
				}
				list.clear();
			}
		}
		Collections.sort(templist);
		System.out.println(templist.get(0) + " " + (len-1) + " " + lastsize[len-1]);
	}

	private static boolean possible(int num, int i) {
		ArrayList<Integer> list = arr[num].able;
		for (int j = 0; j < list.size(); j++) {
			if(list.get(j) == i)
				return true;
		}
		return false;
	}
}
