package homework_0807;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProductServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(1234);
			System.out.println("Product Server Start!");
			while(true) {
				Socket s = ss.accept();
				System.out.println("\n클라이언트 " + s.getInetAddress() + " 접속");
				ObjectInputStream  ois = null;
				try {
					ois = new ObjectInputStream(s.getInputStream());
					ArrayList<TV> TVs = (ArrayList<TV>) ois.readObject();
					ArrayList<Refrigerator> RFs = (ArrayList<Refrigerator>) ois.readObject();
					System.out.println("*-------------------입력 받은 TV 데이터 출력---------------------*");
					for(TV tv : TVs)
						System.out.println(tv);
					System.out.println("*-------------------입력 받은 냉장고 데이터 출력---------------------*");
					for(Refrigerator rf : RFs)
						System.out.println(rf);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
