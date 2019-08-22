package workshop_0822;

import java.util.List;

public class Test {
	static BookDAO dao = new BookDAO();
	public static void printAllBooks(List<Book> list) {
		for(Book book : list) {
			System.out.println(book);
		}
	}
	public static void main(String[] args) {
		System.out.println("2. 현재 도서 목록을 출력하세요");
		printAllBooks(dao.listBooks());
		System.out.println("3. a1101 도서를 검색해보세요.");
		System.out.println(dao.findBook("a1101"));
		System.out.println("4. a1104 도서를 추가하세요.");
		dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
		System.out.println("5. a1101 도서를 수정 후 목록을 출력하세요.");
		dao.updateBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));
		printAllBooks(dao.listBooks());
	}
}
