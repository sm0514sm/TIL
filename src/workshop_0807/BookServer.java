package workshop_0807;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BookServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(5431);
			System.out.println("Book Server Start!");
			while(true) {
				Socket s = ss.accept();
				System.out.println("클라이언트 " + s.getInetAddress() + " 접속");
				ObjectInputStream  ois = null;
				try {
					ois = new ObjectInputStream(s.getInputStream());
					ArrayList<Book> Books = (ArrayList<Book>) ois.readObject();
					System.out.println("*-------------------입력 받은 데이터 출력---------------------*");
					for(Book book : Books)
						System.out.println(book);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
