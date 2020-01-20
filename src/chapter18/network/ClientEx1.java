package chapter18.network;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket(); // 소캣은 서버 클라이언트 모두 필요
		System.out.println("연결요청");
		socket.connect(new InetSocketAddress("211.183.2.21",9000));
		System.out.println("연결완료");
		
		
		Scanner scanner = new Scanner(System.in);
		
		OutputStream os =  socket.getOutputStream();
		PrintStream ps = new PrintStream(os);
		
		String message = null;
		while(!(message = scanner.nextLine()).equals("exit")){
			
			ps.println("발신]" + message);
			
		}
		ps.println("종료");
		
		
		
		ps.close();
		if(!socket.isClosed()) {
			socket.close();
		}
		
	}

}
