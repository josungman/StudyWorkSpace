package chapter18.network;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {
	//서버 소켓(기다리는 쪽)
	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket();
	
		//서버 소켓의 현제 주소 (주소는 IPAddress까지)
		server.bind(new InetSocketAddress( InetAddress.getLocalHost(),9000)); //포트번호 1~65535까지이나 1000번대까지는 예약 된 상태
	
		System.out.println("연결 기다림");
		Socket socket = server.accept();
		
	
		
		// 클라이언트로 부터 라인 단위 (BufferedReader) 받는다.
		
		InputStream is  = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		
		String line = null;
		
		for (int i = 0; i< 10 ; i++) {
			line = br.readLine();
			System.out.println("[수신]" + line);
			
		}
		
		
		
		br.close();
		
		if (!server.isClosed()) {
			server.close();
		}
		
		
	}
	
	
	
	
}
