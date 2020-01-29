package myGameProjcet;

import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void ClientStart() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("IP를 입력해주세요.");
		String input =scan.next(); 
		
		Socket socket = null;
		try {
			
			socket = new Socket(input,9005);
			Thread th1 = new SenderThread(socket);
			Thread th2 = new ReceiverThread(socket);
			
			System.out.println("연결완료");
			
			
			
			th1.start();
			th2.start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
}
