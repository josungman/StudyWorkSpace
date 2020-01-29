package myGameProjcet;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread {
static boolean run = true;
static String Winner = null;

	// 소켓 필드 작성
	Socket socket;

	// 생성자
	public ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	// 메소드
	@Override
	public void run() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (run) {

				String str = reader.readLine(); // 데이터의 한줄

				if (str.contains("공격력/") == true) { // 상대방(서버)에서 공격 명령을 보낼때
					// 상대방 공격력 파악 후 내 캐릭터에 공격력 만큼 피해 입히기
					String[] AttNumcheck = str.split("/");

					int HPManus = RPG.User.getHP();
					HPManus -= Integer.parseInt(AttNumcheck[1]);

					RPG.User.setHP(HPManus);
					System.out.println();
					System.out.println("내 캐릭터가 (" +  RPG.User.getName() + ") " + AttNumcheck[1] + " 피해를 입었다. ");// 발신메세지 출력
					System.out.println("내 캐릭터가 현제 HP : " + RPG.User.getHP());// 발신메세지 출력
					System.out.println();
					
					if (RPG.User.getHP() <= 0) {
						System.out.println("체력이 없으므로 승부에서 졌습니다. 퇴장 됩니다.");
						RPG.Sound("Lose.wav", false);
						//System.out.println("승리");
						run = false;
						SenderThread.run = false;
						RPG.GamePage();
						
					}

				} else {

				}

				System.out.println("상대방>" + str);// 수신메세지 출력
				if (str == null) {
					run = false;
					SenderThread.run = false;
				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
