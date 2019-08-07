package homework_0807;

public class Refrigerator extends Product {
	private int size;

	/*---------- 생성자 ----------*/
	public Refrigerator() {
	}

	public Refrigerator(String no, String name, int price, int num, int size) {
		super(no, name, price, num);
		setSize(size);
	}

	/*---------- 메서드 ----------*/
	public String toString() {
		return super.toString() + "\t| "+ size; 
	}

	/*---------- get, set ----------*/
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size <= 0) {
			System.out.println("용량 설정을 잘못하셨습니다.\n1 로 설정합니다.");
			this.size = 1;
		} else
			this.size = size;
	}
}
