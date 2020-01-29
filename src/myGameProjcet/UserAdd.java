package myGameProjcet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class UserAdd {

	public static void account() throws Exception {
		Scanner scanner = new Scanner(System.in);
		Reader fr = new FileReader("user.txt");
		// Map을 이용하여 ID,비밀번호값 임시저장하기
		Map<String, String> accountlist = new HashMap<>();

		String user = null;
		boolean run = true;
		String str = null;

		// BufferedReader 클래스를 사용하면 readLine메서드로 한줄씩 읽어올 수 있다.
		// BufferedReader 클래스 알아보기
		//BufferedReader br = new BufferedReader(new FileReader(new File("user.txt")));

		File file    =  new File("user.txt");
		BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		
		// readline 메서드를 바깥에서 한번 진행
		// 첫번째값은 무조건 있어야됨
		str = br.readLine();
		while (str != null) {

			// ,로 자르기
			String account[] = str.split(",");
			// ,기준 왼쪽 문자열 accountlist배열에 add시키기
			accountlist.put(account[0], account[1]);

			str = br.readLine(); // null일때까지 계속 읽어오기

		}
		int Usercnt = accountlist.size();
		System.out.println("(현제 회원 수는 " + (Usercnt) + "명 이며 사용할 ID,PW를 입력하세요.)");

		// Map.Entry로 ID,비번 나누기 (getKey,getValue)
		Set<Map.Entry<String, String>> entries = accountlist.entrySet();

		System.out.println();
		System.out.println();

		// Writer로 user.txt에 이어쓰기
		//FileWriter fw = new FileWriter("user.txt", true);

		FileOutputStream fos = new FileOutputStream("user.txt",true);
		OutputStreamWriter ows = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter fw = new BufferedWriter(ows);
//		Writer fw = new BufferedWriter(new OutputStreamWriter(
//			    new FileOutputStream("user.txt",true), "UTF-8"));
			try {
			    
			} finally {
			    
			}
		
		boolean IDcheck = false;

		System.out.print("1.사용하실 ID를 입력해주세요▶");
		user = scanner.next();
		// ID 입력후 MAP에 있는지 체크
		for (Entry<String, String> entry : entries) {

			if (entry.getKey().equals(user)) {
				IDcheck = true;
			}

		}
		if (IDcheck == true) {
			System.out.println();
			System.out.println("!!이미 사용인 ID 입니다!!");
			System.out.println();
			RPG.page1();
		}

		else if (IDcheck == false) {
			RPG.ID = user; // RPG 클래스 ID 클래스 인스턴스에 유저 ID 저장
			fw.write("\r");
			fw.write(user);
			fw.write(",");

			System.out.print("2.사용하실 PW를 입력해주세요▶");
			user = scanner.next();
			fw.write(user);
			RPG.PW = user;
			System.out.println();
			System.out.println("◈계정 생성이 완료 되었습니다◈");
			System.out.println();
			
			RPG.Sound("UserLogin.wav", false); //로그인 사운드
			
			// 기본 능력치 User파일에 입력
			String AddUserInfo = "";
			AddUserInfo = "," + RPG.User.getName() + "," + RPG.User.getHP() + "," + RPG.User.getPower() + ","
					+ RPG.User.getIntt() + "," + RPG.User.getDex() + "," + RPG.User.getMoney();

			// 공백제거
			fw.write(AddUserInfo.trim());

			fw.flush();
			fw.close();

			RPG.GamePage(); // 가입 완료후 이동
		}

	}

}
