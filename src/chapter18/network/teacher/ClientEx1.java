package chapter18.network.teacher;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx1 {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket();
		System.out.println("연결 요청");
		socket.connect(new InetSocketAddress("211.183.2.21", 9000));
		System.out.println("연결 성공");

		Scanner scanner = new Scanner(System.in);
		OutputStream os = socket.getOutputStream();
		PrintStream ps = new PrintStream(os);
		
		String message = null;
		while (!(message = scanner.nextLine()).equals("exit")) {
//			System.out.println(message);
			ps.println(message);
		}
		ps.println(message);
		
		ps.close();
		if (!socket.isClosed()) {
			socket.close();
		}

	}
}




