package myGameProjcet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread {

	//소켓 필드 작성
	Socket socket;
	
	//생성자
	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}
	
	//메소드
	@Override
	public void run() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				
				String str = reader.readLine(); //데이터의 한줄
				System.out.println("수신>"+str);//수신메세지 출력
				if(str==null) {break;}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
}
