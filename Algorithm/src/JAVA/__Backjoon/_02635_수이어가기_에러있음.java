package __Backjoon;
import java.util.ArrayList;
import java.util.Scanner;

//Main
public class _02635_수이어가기_에러있음 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = null;
		int N = sc.nextInt();
		int max = 0;
		ArrayList<Integer> maxlist = null;
		for(int i = N/2 + 1; i <= N*3/4; i++) {
			list = new ArrayList<>();
			int temp = N;
			int minus = i;
			while(temp >= 0) {
				list.add(temp);
				temp -= minus;
				int tt = minus;
				minus = temp;
				temp = tt;
			}
			if(max < list.size()) {
				max = list.size();
				maxlist = (ArrayList<Integer>) list.clone();
			}
		}
		System.out.println(maxlist.size());
		for(int i = 0; i < maxlist.size(); i++) {
			System.out.print(maxlist.get(i) + " ");
		}
		
		sc.close();
	}
}
