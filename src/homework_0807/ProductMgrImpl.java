package homework_0807;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
			if(tempProduct.getNo().equals(Product.getNo())) {
				return;
			}
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
	
	class MySaveThread extends Thread{
		public void run(){
			ObjectOutputStream oos = null;
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream("src/homework_0807/product.dat");
				oos = new ObjectOutputStream(fos);
				
				oos.writeObject(prods);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(fos != null) try {fos.close();} catch(Exception e) {}
				if(oos != null) try {oos.close();} catch(Exception e) {}
			}
		}
	}
	@Override
	public void save() {
		MySaveThread t1 = new MySaveThread();
		t1.start();
	}

	@Override
	public void load() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/homework_0807/product.dat");
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

	@Override
	public void send() {
		new Thread() {
			public void run() {
				Socket s = null;
				ObjectOutputStream oos = null;
				ArrayList<Product> tempTV = new ArrayList<>();
				ArrayList<Product> tempRF = new ArrayList<>();
				try {
					s = new Socket("127.0.0.1", 1234);
					oos = new ObjectOutputStream(s.getOutputStream());
					for(Product prod : prods) {
						if(prod instanceof TV)
							tempTV.add(prod);
					}
					for(Product prod : prods) {
						if(prod instanceof Refrigerator)
							tempRF.add(prod);
					}
					
					oos.writeObject(tempTV);
					oos.writeObject(tempRF);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					IOUtil.close(oos);
					IOUtil.close(s);
				}
			}
		}.start();
		
	}
}
