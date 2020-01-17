package chapter18;

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

		String user = null;
		boolean run = true;

		System.out.println("user파일 정보 읽어오기");
		
		int i;
		//ArrayList로 읽어오기
		List<String> Arrlist = new ArrayList<>();
		
		char[] s = new char[3];
		while ((i = fr.read(s)) != -1) {
			
			String data = new String(s);
			System.out.print(data);

		}

		System.out.println();
		System.out.println();

		FileWriter fw = new FileWriter("user.txt", true);
		
		
		
		
		
		while (run) {

			for (int j = 0; j <= 2; j++) {

				if (j == 0) {

					System.out.println("ID생성>");
					user = scanner.next();
					fw.write("\n");
					fw.write(user);
					fw.write("\t");
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

		fw.close();

	}

}
