package homework_0807;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void printMenu() {
		System.out.println("------------------------------");
		System.out.println("0. TV 데이터 입력");
		System.out.println("1. Refrigerator 데이터 입력");
		System.out.println("2. 상품정보 전체를 검색하는 기능");
		System.out.println("3. 상품번호로 상품 검색");
		System.out.println("4. 400L 이상의 Refrigerator 검색");
		System.out.println("5. 50 inch 이상의 TV 검색");
		System.out.println("6. 서버에 데이터 전송하기");
		System.out.println("7. 종료 < 이거 해야 저장됨");
	}
	
	public static void main(String[] args) {
		ProductMgrImpl manager = new ProductMgrImpl();
		Scanner sc = new Scanner(System.in);
		String line = "------------------------------";
		FOREVER_LOOP:
			while(true) {
				String no, name, type;
				int price, inch, size, num;
				ArrayList<Product> tempProds;
				Product tempProd;
				printMenu();
				switch (Integer.parseInt(sc.nextLine())) {
				case 0:
					System.out.print("상품번호 입력\n>> ");
					no = sc.nextLine();
					System.out.print("제품이름 입력\n>> ");
					name = sc.nextLine();
					System.out.print("가격 입력\n>> ");
					price = Integer.parseInt(sc.nextLine());
					System.out.print("개수 입력\n>> ");
					num = Integer.parseInt(sc.nextLine());
					System.out.print("인치 입력\n>> ");
					inch = Integer.parseInt(sc.nextLine());
					System.out.print("타입 입력\n>> ");
					type = sc.nextLine();
					
					manager.addProductInfo(new TV(no, name, price, num, inch, type));
					break;
				case 1:
					System.out.print("상품번호 입력\n>> ");
					no = sc.nextLine();
					System.out.print("제품이름 입력\n>> ");
					name = sc.nextLine();
					System.out.print("가격 입력\n>> ");
					price = Integer.parseInt(sc.nextLine());
					System.out.print("개수 입력\n>> ");
					num = Integer.parseInt(sc.nextLine());
					System.out.print("크기 입력\n>> ");
					size = Integer.parseInt(sc.nextLine());
					
					manager.addProductInfo(new Refrigerator(no, name, price, num, size));
					break;
				case 2:
					System.out.println(line + "데이터 전체 검색" + line);
					tempProds = manager.printProductInfo();
					for(Product temp: tempProds)
						System.out.println(temp);
					break;
				case 3:
					System.out.println(line + "상품번호로 상품 검색" + line);
					System.out.print("검색할 상품번호 입력\n>> ");
					no = sc.nextLine();
					try {
						tempProd = manager.findWithNO(no);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println(line + "400L 이상의 Refrigerator 검색" + line);
					try {
						tempProds = manager.OnlyBigger400Refrigerator();
						for(Product temp: tempProds)
							System.out.println(temp);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					System.out.println(line + "50 inch 이상의 TV 검색" + line);
					try {
						tempProds = manager.OnlyBigger50TV();
						for(Product temp: tempProds)
							System.out.println(temp);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 6:
					manager.send();
					System.out.println(line + "서버에 데이터 전송 완료" + line);
					break;
				default:
					
					manager.save();
					break FOREVER_LOOP;
				}
			}
			sc.close();
	}
}
