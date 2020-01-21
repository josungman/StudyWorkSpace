package chapter18.exercise.p11;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("211.183.2.21", 5001);
		OutputStream os = socket.getOutputStream();
		
		String filePath = "src/chapter18/exercise/p11/ClientExample.java";
		File file = new File(filePath);
		
		String fileName = file.getName();
		byte[] b = new byte[100];
		fileName.getBytes(0, fileName.length(), b, 0);
		os.write(b, 0, 100);
		
		System.out.println("[파일 보내기 시작]" + fileName);
		FileInputStream fis = new FileInputStream(file);
		int byteCnt = 0;
		while ((byteCnt = fis.read(b)) != -1) {
			os.write(b, 0, byteCnt);
		}
		
		os.flush();
		System.out.println("[파일 보내기 완료]");
		
		fis.close();
		os.close();
		socket.close();
		
		
	}
}
