package chapter18;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class OutputStreamWriterEx1 {

	public static void main(String[] args) throws Exception {
		

		FileOutputStream fos = new FileOutputStream("out3.txt");
		//바위트 단위를 문자 단위로 쓸수 있는 보조 Stream;
		OutputStreamWriter osr = new OutputStreamWriter(fos);
	
		
		osr.write("문자단위로 작성 함");
	
		osr.close();
	}
	
	
	
	
}
