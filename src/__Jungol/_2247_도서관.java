package __Jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _2247_도서관 {
	
	public static class PEOPLE implements Comparable<PEOPLE>{
		int sta, end;

		public PEOPLE(int sta, int end) {
			this.sta = sta;
			this.end = end;
		}

		@Override
		public int compareTo(PEOPLE o) {
			int val = Integer.compare(sta, o.sta);
			val = val == 0 ? Integer.compare(end, o.end) : val;
			return val;
		}

		@Override
		public String toString() {
			return "PEOPLE [sta=" + sta + ", end=" + end + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		PEOPLE[] peoples = new PEOPLE[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			peoples[i] = new PEOPLE(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(peoples);
		
		int MaxEmpty = 0, MaxStay = 0;
		int sta = peoples[0].sta, end = peoples[0].end;
		for (int i = 1; i < N; i++) {
			if(peoples[i].sta > end) {
				MaxEmpty = Math.max(MaxEmpty, peoples[i].sta - end);
				sta = peoples[i].sta;
				end = peoples[i].end;
			}
			else {
				end = Math.max(peoples[i].end, end);
				MaxStay = Math.max(end-sta, MaxStay);
			}
		}
		System.out.println(MaxStay + " " + MaxEmpty);
	}
}
