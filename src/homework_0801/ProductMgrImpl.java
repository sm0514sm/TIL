package homework_0801;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr{
	ArrayList<Product> prods = new ArrayList<Product>();
	
	public ProductMgrImpl() {
		load();
	}

	@Override
	public void addProductInfo(Product Product) {
		if (Product == null)
			return;
		for(Product tempProduct : prods)
			if(tempProduct.getNo().equals(tempProduct.getNo()))
				return;
		prods.add(Product);
	}

	@Override
	public Product findWithNO(String NO) throws CodeNotFoundException {
		for(Product tempProduct : prods)
			if(tempProduct.getNo().equals(NO))
				return tempProduct;
		throw new CodeNotFoundException();
	}

	@Override
	public ArrayList<Product> OnlyBigger400Refrigerator() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		for(Product tempProduct : prods) {
			if(tempProduct instanceof Refrigerator) {
				Refrigerator tempRef = (Refrigerator) tempProduct;
				if(tempRef.getSize() > 400)
					temp.add(tempRef);
			}
		}
		if(temp.size() == 0)
			throw new ProductNotFoundException();
		else
			return temp;
	}

	@Override
	public ArrayList<Product> OnlyBigger50TV() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		for(Product tempProduct : prods) {
			if(tempProduct instanceof TV) {
				TV tempTV = (TV) tempProduct;
				if(tempTV.getInch() > 50)
					temp.add(tempTV);
			}
		}
		if(temp.size() == 0)
			throw new ProductNotFoundException();
		else
			return temp;
	}

	@Override
	public void save() {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("src/product.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(prods);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) try {fos.close();} catch(Exception e) {}
			if(oos != null) try {oos.close();} catch(Exception e) {}
		}
	}

	@Override
	public void load() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/product.dat");
			ois = new ObjectInputStream(fis);
			
			prods = (ArrayList<Product>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) try {fis.close();} catch(Exception e) {}
			if(ois != null) try {ois.close();} catch(Exception e) {}
		}
	}

	@Override
	public ArrayList<Product> printProductInfo() {
		return prods;
	}
}
