package myGameProjcet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//송신 thread 객체

public class SenderThread extends Thread {

	// 필드
	Socket socket;

	public SenderThread(Socket socket) {
		this.socket = socket;

	}

	@Override
	public void run() {
	
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); //출력스트림
			
		while(true) {
			
			String str = reader.readLine();
			
			writer.println(str); //println으로 해야 상대방에서 정상 출력 됨.
			writer.flush();
			
			if(str.equals("bye")) {break;}
			
			
		}
			
			
		}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}finally {
		try { //클라이언트 종료시는 반드시 소켓도 닫아주기
			socket.close();
		}catch(Exception e) {}
		
		
	}

}

}
