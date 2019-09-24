package __SW_Expert;
// 못품
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3378_스타일리쉬들여쓰기 {
	
	static class 조합{
		int 소괄호, 중괄호, 대괄호, 그때값;	//
		
		public 조합(int 소괄호, int 중괄호, int 대괄호, int 그때값) {
			this.소괄호 = 소괄호;
			this.중괄호 = 중괄호;
			this.대괄호 = 대괄호;
			this.그때값 = 그때값;
		}
		
		public void findRSC() {
			int tmp소 = 소괄호;
			int tmp중 = 중괄호;
			int tmp대 = 대괄호;
			int tmp값 = 그때값;
			
			if(R != 1) {tmp값 -= tmp소*R; tmp소 = 0;}
			if(C != 1) {tmp값 -= tmp중*C; tmp중 = 0;}
			if(S != 1) {tmp값 -= tmp대*S; tmp대 = 0;}
			
			if(tmp소 != 0 && tmp중 == 0 && tmp대 == 0) {R = tmp값/tmp소; check[0] = true; checkCnt++;}
			if(tmp소 == 0 && tmp중 != 0 && tmp대 == 0) {C = tmp값/tmp중; check[1] = true; checkCnt++;}
			if(tmp소 == 0 && tmp중 == 0 && tmp대 != 0) {S = tmp값/tmp대; check[2] = true; checkCnt++;}
			
			if(tmp소 != 0 && tmp중 != 0 && tmp대 != 0 && tmp소 + tmp중 + tmp대 == tmp값) {
				R = 1;
				C = 1;
				S = 1;
				check[0] = check[1] = check[2] = true;
				checkCnt += 3;
			}
			
			if(tmp소 != 0 && tmp중 != 0 && tmp대 != 0 && (tmp소 + tmp중 + tmp대)*20 == tmp값) {
				R = 20;
				C = 20;
				S = 20;
				check[0] = check[1] = check[2] = true;
				checkCnt += 3;
			}
			
		}

		public int isSame(int s, int m, int b) {
			for(int k = 1; k < 100; k++) {
				if(s*k == 소괄호 && m*k == 중괄호 && b*k == 대괄호)
					return k;
			}
			return -1;	
		}
	}
	
	
	static int[] count;	// ( ) { } [ ]
	static int[] mycount;	// ( ) { } [ ]
	static int[] indent;
	static 조합[] num;
	static int R, C, S;
	static boolean[] check;
	static int checkCnt;
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_3378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			R = C = S = 1;
			check = new boolean[3];
			checkCnt = 0;
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()); // 전문가 코드 줄
			count = new int[6];
			mycount = new int[6];
			int q = Integer.parseInt(st.nextToken()); // 내꺼 코드 줄
			indent = new int[p];
			num = new 조합[p];
			for (int i = 0; i < p; i++) {
				String temp = br.readLine();
				for (int j = 0; j < temp.length(); j++) {
					if(temp.charAt(j) == '.') indent[i]++;
					else break;
				}
				num[i] = new 조합(count[0] - count[1], count[2] - count[3], count[4]- count[5], indent[i]);
				
				for (int j = 0; j < temp.length(); j++) {
					     if(temp.charAt(j) == '(') count[0]++;
					else if(temp.charAt(j) == ')') count[1]++;
					else if(temp.charAt(j) == '{') count[2]++;
					else if(temp.charAt(j) == '}') count[3]++;
					else if(temp.charAt(j) == '[') count[4]++;
					else if(temp.charAt(j) == ']') count[5]++;
				}
			}
			int loopCnt = 0;
			while(checkCnt < 3) {
				for(조합 nu: num) {
					if(checkCnt >= 3) break;
					nu.findRSC();
				}
				loopCnt++;
				if(loopCnt > 10) break;
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < q; i++) {
				String temp = br.readLine();
				boolean clear = false;
				int cnt = 0;
				for (boolean che: check) {
					if(che)
						cnt++;
					if(cnt >= 3) break;
				}
				if (cnt >= 3) {
					clear = true;
					System.out.print((R * (mycount[0] - mycount[1]) + C * (mycount[2] - mycount[3])
							+ S * (mycount[4] - mycount[5])) + " ");
				} else {
					for (int j = 0; j < num.length; j++) {
						int val = num[j].isSame(mycount[0] - mycount[1], mycount[2] - mycount[3],
								mycount[4] - mycount[5]);
						if (val != -1) {
							System.out.print(val * num[j].그때값 + " ");
							clear = true;
							break;
						}
					}
				}
				if (!clear) {
					System.out.print(-1 + " ");
				}
				
				for (int j = 0; j < temp.length(); j++) {
					     if(temp.charAt(j) == '(') mycount[0]++;
					else if(temp.charAt(j) == ')') mycount[1]++;
					else if(temp.charAt(j) == '{') mycount[2]++;
					else if(temp.charAt(j) == '}') mycount[3]++;
					else if(temp.charAt(j) == '[') mycount[4]++;
					else if(temp.charAt(j) == ']') mycount[5]++;
				}
			}
			System.out.println();
		}
	}
	public static boolean next() {
		R++;
		if(R > 20) {
			R = 1;
			C++;
		}
		if(C > 20) {
			C = 1;
			S++;
		}
		if(S > 20) {
			R = C = S = 1;
			return false;
		}
		return true;
	}
}
