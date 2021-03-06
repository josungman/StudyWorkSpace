package myGameProjcet;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static void Serverstart() throws Exception {
		
		//내 자신 IP
		InetAddress myip = InetAddress.getLocalHost();
		System.out.println("연결기다림... 현제 사용자 IP는 : " + myip.getHostAddress());
		//소켓 생성
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
		
			 serverSocket = new ServerSocket(9005); //포트번호 9005로 서버소켓 생성
			socket = serverSocket.accept(); //소켓 생성 메소드 
		
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			if(serverSocket !=null) {System.out.println("상대방 접속확인 : (" + isa.getAddress() + ")");}
			
			Thread th1 = new SenderThread(socket); //수신
			Thread th2 = new ReceiverThread(socket); //발신
		
			th1.start();
			th2.start();
			
			
			while(true) {
				
				
				
				
			}
			
			
			
		} catch (Exception e) {
			
		} finally {//서버 종료시 소켓을 해제
			try {
				serverSocket.close();
			} catch (Exception e2) {}
		}
		
		
	}
	
	
}
