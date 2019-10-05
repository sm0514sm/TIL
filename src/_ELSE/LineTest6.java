package _ELSE;

import java.util.Arrays;
import java.util.Scanner;

//Solution
public class LineTest6 {
	public static class NUM{
		int size, num;
		char[][] arr;
		
		public NUM(int size, int num) {
			this.size = size;
			this.num = num;
			this.arr = new char[size*2-1][size];
			
			
			switch (num) {
			case 1:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					arr[i][size-1] = '#';
				}
				break;
			case 2:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == 0 || i == size-1 || i == size*2-2)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					if(i >= 0 && i < size - 1) 			arr[i][size-1] = '#';
					if(i >= size-1 && i < 2*size - 1)	arr[i][0] = '#';
				}
				break;
			case 3:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == 0 || i == size-1 || i == size*2-2)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					if(i >= 0 && i < 2*size - 1) arr[i][size-1] = '#';
				}
				break;
			case 4:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == size-1)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					
					if(i >= 0 && i < size - 1) 		arr[i][0] = '#';
					if(i >= 0 && i < 2*size - 1)	arr[i][size-1] = '#';
				}
				break;
			case 5:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == 0 || i == size-1 || i == size*2-2)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					if(i >= 0 && i < size - 1) 			arr[i][0] = '#';
					if(i >= size-1 && i < 2*size - 1)	arr[i][size-1] = '#';
				}
				break;
			case 6:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == size-1 || i == size*2-2)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					if(i >= size-1 && i < size*2-1 ) arr[i][size-1] = '#';
					if(i >= 0 && i < 2*size - 1)		arr[i][0] = '#';
				}
				break;
			case 7:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					arr[i][size-1] = '#';
					if(i == 0)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
				}
				break;
			case 8:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == 0 || i == size-1 || i == size*2-2)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					if(i >= 0 && i < 2*size - 1) arr[i][size-1] = '#';
					if(i >= 0 && i < 2*size - 1) arr[i][0] = '#';
				}
				break;
			case 9:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == 0 || i == size-1)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					
					if(i >= 0 && i < size - 1) 		arr[i][0] = '#';
					if(i >= 0 && i < 2*size - 1)	arr[i][size-1] = '#';
				}
				break;
			case 0:
				for (int i = 0; i < size*2-1; i++) {
					Arrays.fill(arr[i], '.');
					if(i == 0  || i == size*2-2)
						for (int j = 0; j < size; j++) {
							arr[i][size-1] = '#';
						}
					if(i >= 0 && i < 2*size - 1) arr[i][size-1] = '#';
					if(i >= 0 && i < 2*size - 1) arr[i][0] = '#';
				}
				break;
			}
			
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int maxSize = 0;
		String align = sc.next();
		NUM[][] nums = new NUM[num][];
		for (int i = 0; i < num; i++) {
			int size = sc.nextInt();
			maxSize = Math.max(maxSize, size);
			String number = sc.next();
			nums[i] = new NUM[number.length()];
			for (int j = 0; j < nums.length; j++) {
				nums[i][j] = new NUM(size,number.charAt(0) - '0');
			}
		}
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < nums.length; j++) {
				
				
			}
		}
	}
}