package myGameProjcet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputEx1 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		Reader fr = new FileReader("user.txt");
		List<GameAccount> accountlist = new ArrayList<>();
		
		String user = null;
		boolean run = true;

		System.out.println("user파일 정보 읽어오기");
		
	
//문자 배열로 추출시		
//		char[] s = new char[3];
//		int i = fr.read(s);
		
		String str = null;
		//BufferedReader 클래스를 사용하면 readLine메서드로 한줄씩 읽어올 수 있다.
		//BufferedReader 클래스 알아보기
		BufferedReader br=new BufferedReader(new FileReader(new File("user.txt")));  
		
		//readline 메서드를 바깥에서 한번 진행
		str = br.readLine();
		
		
		while(str != null) {
			
			//,로 쪼개기
			String account[] =  str.split(",");
			// ,기준 왼쪽 문자열 accountlist배열에 add시키기
			accountlist.add(new GameAccount(account[0],account[0]));
			str = br.readLine(); //null일때까지 계속 읽어오기
		
		}

		
		System.out.println(accountlist.size());
		System.out.println(accountlist.get(accountlist)); //ID만 뽑아오기
		
		
		//read메서드로 리턴값이 -1이 나올때까지 루핑
		//int i;
		//while ((i = fr.read()) != -1) {
			
			//String data = new String(s);
			//System.out.print((char) i );
		//}

		System.out.println();
		System.out.println();

		FileWriter fw = new FileWriter("user.txt", true);
		
		
		//user파일 입력 , 로 구분
		while (run) {

			for (int j = 0; j <= 2; j++) {

				if (j == 0) {

					System.out.println("ID생성>");
					user = scanner.next();
					fw.write("\n");
					fw.write(user);
					fw.write(",");
				} else if (j == 1) {
					System.out.println("비밀번호생성>");
					user = scanner.next();
					fw.write(user);

				} else {
					run = false;
					System.out.println("입력완료");
				}

			}

//			System.out.println("ID입력>");
//			user = scanner.next();
//
//			if (user.equals("exit")) {
//				run = false;
//				System.out.println("종료되었습니다.");
//			} else {
//				fw.write(user);
//				fw.write("\t");
//			}

		}

		scanner.close();
		fw.flush();
		fw.close();

	}

}
