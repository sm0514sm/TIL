package workshop_0807;

import java.io.Serializable;

public class Book implements Serializable {
	private String isbn;
	private String title;
	private int price;
	private int quantity;

	/*----------생성자--------------*/
	public Book() {
	}

	public Book(String isbn, String title, int price, int quantity) {
		this.isbn = isbn;
		this.title = title;
		this.setPrice(price);
		this.quantity = quantity;
	}

	/*-----------메서드---------------*/
	public String toString() {
		return isbn + "\t| " + title + "\t| " + price + "\t| " + quantity;
	}

	
	/*---------get, set-------------*/
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity < 0)
			this.quantity = 0;
		else
			this.quantity = quantity;
	}
	
	public void setPrice(int price) {
		if (price < 0) {
			System.out.println("잘못된 가격을 입력했습니다.\n0원으로 변경합니다.");
			this.price = 0;
		} else
			this.price = price;
	}
}
