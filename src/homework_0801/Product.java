package homework_0801;

import java.io.Serializable;

public class Product implements Serializable{
	private String no;
	private String name;
	private int price;
	private int num;
	
	/*---------- 생성자 ----------*/
	public Product() {}
	public Product(String no, String name, int price, int num) {
		this.no = no;
		this.name = name;
		setPrice(price);
		setNum(num);
	}
	
	/*---------- 메서드 ----------*/
	public String toString() {
		return no + "\t| " + name + "\t| " + price + "\t| " + num;
	}
	
	/*---------- get, set ----------*/
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			System.out.println("가격 설정을 잘못하셨습니다.\n0원으로 설정합니다.");
			this.price = 0;
		} else
			this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if (num <= 0) {
			System.out.println("수량 설정을 잘못하셨습니다.\n1개로 설정합니다.");
			this.num = 1;
		} else
			this.num = num;
	}

}
