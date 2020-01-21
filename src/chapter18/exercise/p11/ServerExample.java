package chapter18.exercise.p11;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("211.183.2.21", 5001));
		
		//파일 전송 소켓 통신
		System.out.println("[서버 시작]");
		
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				
				InputStream is = socket.getInputStream();
				
				byte[] bytes = new byte[1000];
				int readByteCount = -1;
				is.read(bytes, 0, 100);
				String fileName = new String(bytes, 0, 100);
				fileName = fileName.trim();
				
				System.out.println("[파일 받기 시작] " + fileName);
				//
				FileOutputStream fos = new FileOutputStream(fileName);
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					fos.write(bytes, 0, len);
				}
				
				System.out.println("[파일 받기 완료]");
				
				fos.close();
				is.close();
				socket.close();
				
				
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		
		serverSocket.close();
		System.out.println("[서버 종료]");
	}
}
