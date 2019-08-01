package homework_0801;

public class TV extends Product {
	private int inch;
	private String type;
	

	/*---------- 생성자 ----------*/
	public TV() {
	}
	
	public TV(String no, String name, int price, int num, int inch, String type) {
		super(no, name, price, num);
		this.inch = inch;
		this.type = type;
	}

	/*---------- 메서드 ----------*/
	public String toString() {
		return super.toString() + "\t| "+ inch + "\t| " + type; 
	}
	
	/*---------- get, set ----------*/
	public int getInch() {
		return inch;
	}
	
	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
