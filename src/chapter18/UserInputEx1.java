package chapter18;

import java.io.FileWriter;
import java.util.Scanner;

public class UserInputEx1 {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		FileWriter fw = new FileWriter("user.txt");

		String user = null;
		boolean run = true;
		
		while (run) {
			System.out.println("입력>");
			user = scanner.next();
			if (user.equals("exit")) {
				run = false;
				System.out.println("종료되었습니다.");
			} else {
				System.out.println("정상적으로 입력되었습니다.");
				fw.write(user);
				fw.write("\n");
			}

		}

		scanner.close();
		fw.close();
		
	}

}
