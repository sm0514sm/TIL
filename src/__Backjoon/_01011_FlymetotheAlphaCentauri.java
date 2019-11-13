package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Main
public class _01011_FlymetotheAlphaCentauri {
	static long to, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			min = 0;
			st = new StringTokenizer(br.readLine());
			long from = Long.parseLong(st.nextToken());
			to = Long.parseLong(st.nextToken());
			to -= from;
			long mul = (long) Math.sqrt(to);

			while (mul * mul < to) {
				mul++;
			}
			if (mul * mul == to)
				min = 2 * mul - 1;
			else {
				if (((mul * mul) + (mul - 1) * (mul - 1)) / 2 >= to)
					min = 2 * mul - 2;
				else
					min = 2 * mul - 1;
			}
			System.out.println(min);
		}

	}
}