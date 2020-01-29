package myGameProjcet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserSave {

	public static void account() throws Exception {
		Scanner scanner = new Scanner(System.in);
		Reader fr = new FileReader("user.txt");
		// Map을 이용하여 ID,비밀번호값 임시저장하기
		Map<String, String> accountlist = new HashMap<>();

		String user = null;
		// boolean run = true;
		String str = null;

		// BufferedReader 클래스를 사용하면 readLine메서드로 한줄씩 읽어올 수 있다.
		// BufferedReader 클래스 알아보기
		 
		//BufferedReader br = new BufferedReader(new FileReader(new File("user.txt"),"euc-kr"));

		File file    =  new File("user.txt");
		BufferedReader br  =  new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		// readline 메서드를 바깥에서 한번 진행
		// 첫번째값은 무조건 있어야됨

		str = br.readLine();
		String TempUserInfo = "";

		String UserInfo = "";
		while (str != null) {

			// 읽어들인 User파일 임시 변수에 담기
			TempUserInfo += (str + "\r\n");

			str = br.readLine(); // null일때까지 계속 읽어오기

		}

		// replace로 접속된 ID만 찾아 능력치 및 정보로 바꿔준다.
		UserInfo += (TempUserInfo.replace(RPG.ID + "," + RPG.PW,
				RPG.ID + "," + RPG.PW + "," + RPG.User.getName() + "," + RPG.User.getHP() + "," + RPG.User.getPower()
						+ "," + RPG.User.getIntt() + "," + RPG.User.getDex() + "," + RPG.User.getMoney())
				+ "\r\n");

		//User파일에 들어갈 text 미리보기 
		//FileWriter fw = new FileWriter("user.txt");
		// 데이터 덮어쓰면서 밀려날시 공백제거
		//fw.write(UserInfo.trim());
		//fw.flush();
		
		
		//커맨드로 실행시 한글깨짐 현상 해결 (UTF-8)
		FileOutputStream fos = new FileOutputStream("user.txt");
		OutputStreamWriter ows = new OutputStreamWriter(fos,"UTF-8");
		BufferedWriter out = new BufferedWriter(ows);
		
//		Writer out = new BufferedWriter(new OutputStreamWriter(
//			    new FileOutputStream("user.txt"),"UTF_8"));
			try {
			    out.write(UserInfo.trim());
			    out.flush();
			} finally {
			    out.close();
			}
		
		System.out.println();
		System.out.println("◈현제까지의 진행상황을 일기에 기록 하였습니다◈");
		System.out.println();
	
		
		
		
	}

}
