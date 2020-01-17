package chapter18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class WriterEx1 {

	public static void main(String[] args) throws Exception {

		Writer fw = new FileWriter("output.txt");

		// 세로줄 \n
		fw.write(new char[] { '한', '글', '날', '\n', '만', '세' });
		fw.close();

		Reader fr = new FileReader("output.txt");

		int i;
		while ((i = fr.read()) != -1) {
			char s = (char) i;
			System.out.println(s);
		}

		fr.close();

	}

}
