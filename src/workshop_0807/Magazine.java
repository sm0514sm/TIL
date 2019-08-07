package workshop_0807;

import java.util.Calendar;

public class Magazine extends Book {
	private int month;
	private int year;

	
	/*-------------생성자--------------*/
	public Magazine() {
		super();
	}

	public Magazine(String isbn, String title, int price, int quantity, int year, int month) {
		super(isbn, title, price, quantity);
		setYear(year);
		setMonth(month);
	}
	
	private void setYear(int year) {
		if(year < 0)
			year = 2019;
		this.year = year;
	}

	/*-------------메서드--------------*/
	public String toString() {
		return super.toString() + "\t| " + month;
	}
	
	/*-------------get, set--------------*/

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month < 1 || month > 12) {
			System.out.println("잘못된 달을 입력했습니다.\n이번달로 변경합니다.");
			Calendar today = Calendar.getInstance();
			this.month = today.get(Calendar.MONTH)+1;
		}
		else
			this.month = month;
	}
}
