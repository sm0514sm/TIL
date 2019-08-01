package workshop_0801;

import java.util.List;
import java.util.Scanner;

public class BookTest {
	public static void printMenu() {
		System.out.println("------------------------------");
		System.out.println("0. book 데이터 입력");
		System.out.println("1. magazine 데이터 입력");
		System.out.println("2. 모든 도서 출력");
		System.out.println("3. 도서 판매");
		System.out.println("4. 도서 구매");
		System.out.println("5. 총 재고 금액 출력");
		System.out.println("6. 종료 < 이거 해야 저장됨");
	}
	public static void main(String[] args) {
		BookMgrImpl manager = new BookMgrImpl();
		Scanner sc = new Scanner(System.in);
		FOREVER_LOOP:
		while(true) {
			String line = "------------------------------";
			String isbn, title;
			int price, quantity, month;
			printMenu();
			switch (Integer.parseInt(sc.nextLine())) {
			case 0:
				System.out.print("도서번호 입력\n>> ");
				isbn = sc.nextLine();
				System.out.print("타이틀 입력\n>> ");
				title = sc.nextLine();
				System.out.print("가격 입력\n>> ");
				price = Integer.parseInt(sc.nextLine());
				System.out.print("개수 입력\n>> ");
				quantity = Integer.parseInt(sc.nextLine());
				manager.add(new Book(isbn, title, price, quantity));
				break;
			case 1:
				System.out.print("도서번호 입력\n>> ");
				isbn = sc.nextLine();
				System.out.print("타이틀 입력\n>> ");
				title = sc.nextLine();
				System.out.print("가격 입력\n>> ");
				price = Integer.parseInt(sc.nextLine());
				System.out.print("개수 입력\n>> ");
				quantity = Integer.parseInt(sc.nextLine());
				System.out.print("달 입력\n>> ");
				month = Integer.parseInt(sc.nextLine());
				manager.add(new Magazine(isbn, title, price, quantity, month));
				break;
			case 2:
				System.out.println(line + "데이터 전체 검색" + line);
				List<Book> tempBooks = manager.search();
				for(Book temp: tempBooks)
					System.out.println(temp);
				break;
			case 3:
				System.out.print("판매될 도서번호 입력\n>> ");
				isbn = sc.nextLine();
				System.out.print("판매될 도서양 입력\n>> ");
				quantity = Integer.parseInt(sc.nextLine());
				try {manager.sell(isbn, quantity);} catch (Exception e) {System.out.println(e.getMessage());}
				break;
			case 4:
				System.out.print("구매될 도서번호 입력\n>> ");
				isbn = sc.nextLine();
				System.out.print("구매될 도서양 입력\n>> ");
				quantity = Integer.parseInt(sc.nextLine());
				try {manager.buy(isbn, quantity);} catch (Exception e) {System.out.println(e.getMessage());}
				break;
			case 5:
				System.out.println("총 재고금액 : " + manager.getTotalAmount());
				break;
			case 6:
			default:
				manager.close();
				break FOREVER_LOOP;
			}
		}
		sc.close();
	}

}
