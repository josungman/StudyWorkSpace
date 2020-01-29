package myGameProjcet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//송신 thread 객체

public class SenderThread extends Thread {

	static boolean run = true;
	// 필드
	Socket socket;

	public SenderThread(Socket socket) {
		this.socket = socket;

	}

	// println으로 해야 상대방에서 정상 출력 됨.
	@Override
	public void run() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); // 출력스트림

			System.out.println();
			System.out.println("명령어 : (공격, 퇴장) 외 일반 채팅 가능");
			System.out.println("네트워크대전시 패시브 및 (특수 공격)은 사용 불가 합니다.");
			System.out.println();

			while (run) {

				String str = reader.readLine();

				if (str.equals("공격")) { //특수 단어
					writer.println("======== 상대방이 공격 합니다 ========");

					if (RPG.User.getName() == "전사") {
						str = Integer.toString(RPG.User.getPower()) + "/휘두르기";
						RPG.Sound("Attack.wav", false);
					} else if (RPG.User.getName() == "법사") {
						str = Integer.toString(RPG.User.getIntt()) + "/매직클로";
						RPG.Sound("WizardAtt.wav", false);
					} else if (RPG.User.getName() == "도적") {
						str = Integer.toString(RPG.User.getDex()) + "/더블어택";
						System.out.println("도적");
						RPG.Sound("ThiefAttack.wav", false);
					}

					
					writer.println("공격력/" + str);
					System.out.println("공격 명령어 동작");
					
					
					
				} else {
					writer.println(str); // println으로 해야 상대방에서 정상 출력 됨.
					//일반 채팅
				}

				
				
				
				
				writer.flush();
				
				if (str.equals("퇴장")) {
					System.out.println("방을 나갑니다.");
					run = false;
					ReceiverThread.run = false;
					RPG.GamePage();
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try { // 클라이언트 종료시는 반드시 소켓도 닫아주기
				socket.close();
			} catch (Exception e) {
			}

		}

	}

}
