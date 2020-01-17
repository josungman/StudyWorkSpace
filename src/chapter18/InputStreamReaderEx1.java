package chapter18;

import java.io.InputStreamReader;
import java.io.Reader;
//보조 스트림
//바이트단위 입력 스트림에서 문자단위로 변환 하는 스트림 InputStreamReader
public class InputStreamReaderEx1 {

	public static void main(String[] args) throws Exception {
		
		Reader isr = new InputStreamReader(System.in);
		
		
		System.out.println("입력>");
		
		
		int i = 0;
		while((i = isr.read()) !=-1) {
			
			//char c = (char) isr.read();	
			System.out.print((char)i);
		}
		
		
		
		
		
		isr.close();
	}

}
