package workshop_0801;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookMgrImpl implements IBookMgr {
	ArrayList<Book> books = new ArrayList<Book>();
	
	public BookMgrImpl(){
		open();
	}
	
	@Override
	public void add(Book book) {
		if (book == null)
			return;
		for(Book tempBook : books)
			if(tempBook.getIsbn().equals(book.getIsbn()))
				return;
		books.add(book);
	}

	@Override
	public List<Book> search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		Book targetBook = null;
		for(Book tempBook : books)
			if(tempBook.getIsbn().equals(isbn)) 
				targetBook = tempBook;
		if(targetBook == null)
			throw new ISBNNotFoundException("찾을 수 없는 도서 번호입니당");
		if(targetBook.getQuantity() == quantity) {
			books.remove(targetBook);
		}
		if(targetBook.getQuantity() - quantity < 0)
			throw new QuantityException("판매할 수 있는 개수가 초과댐!");
		targetBook.setQuantity(targetBook.getQuantity() - quantity);
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book targetBook = null;
		for(Book tempBook : books)
			if(tempBook.getIsbn().equals(isbn)) 
				targetBook = tempBook;
		if(targetBook == null)
			throw new ISBNNotFoundException("찾을 수 없는 도서 번호입니당");

		targetBook.setQuantity(targetBook.getQuantity() + quantity);
	}

	@Override
	public int getTotalAmount() {
		int total = 0;
		for(Book tempBook : books) {
			total += tempBook.getPrice() * tempBook.getQuantity();
		}
		return total;
	}

	@Override
	public void open() {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/workshop_0801/book.dat");
			ois = new ObjectInputStream(fis);
			
			books = (ArrayList<Book>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) try {fis.close();} catch(Exception e) {}
			if(ois != null) try {ois.close();} catch(Exception e) {}
		}
	}
	
	@Override
	public void close() {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("src/workshop_0801/book.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(books);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fos != null) try {fos.close();} catch(Exception e) {}
			if(oos != null) try {oos.close();} catch(Exception e) {}
		}
	}

}
