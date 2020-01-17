package chapter18;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderExample {

	public static void main(String[] args) throws Exception {
		// 바이트 입력스트림을 문자 스트림으로 변환 (InputStream 보조 스트림)
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);

		int readCharNo;

		char[] cbuf = new char[1];
		while ((readCharNo = reader.read(cbuf)) != -1) {

			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);

		}

		reader.close();
	}

}
