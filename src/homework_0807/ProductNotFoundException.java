package homework_0807;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException() {
		super("해당 상품이 존재하지 않습니다.");
	}
	
}
