package homework_0807;

import java.util.ArrayList;

public interface IProductMgr {
	
	
	/* 1. 상품정보 저장 */
	void addProductInfo(Product Product);
	
	/* 2. 상품정보 전체를 검색하는 기능 */
	ArrayList<Product> printProductInfo();
	
	/* 3. 상품번호로 상품 검색하는 기능 */
	Product findWithNO(String NO) throws CodeNotFoundException;
	
	/* 7. 400L 이상의 Refrigerator 검색 */
	ArrayList<Product> OnlyBigger400Refrigerator() throws ProductNotFoundException;
	
	/* 8. 50 inch 이상의 TV 검색 */
	ArrayList<Product> OnlyBigger50TV() throws ProductNotFoundException;
	
	/* 파일 product.dat 에 저장*/
	void save();
	
	/* 파일로부터 상품정보를 읽어오는 기능*/
	void load();
	
	void send();
}
