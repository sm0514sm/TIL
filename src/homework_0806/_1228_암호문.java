package homework_0806;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _1228_암호문 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1228.txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			List<Integer> list = new LinkedList<Integer>();
			int originLen = sc.nextInt();
			for (int i = 0; i < originLen; i++)
				list.add(sc.nextInt());
			int commandLen = sc.nextInt();
			for(int i = 0; i < commandLen; i++) {
				sc.next();	// I
				int where = sc.nextInt();
				for(int j = 0, num = sc.nextInt(); j < num ; j++) {
					list.add(where + j, sc.nextInt());
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i = 0; i< 10; i++)
				System.out.print(list.get(i) + " ");
			System.out.println();
		}
		sc.close();
	}

}
