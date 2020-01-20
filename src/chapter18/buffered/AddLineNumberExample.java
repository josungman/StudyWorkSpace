package chapter18.buffered;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

//이것이 자바다 확인문제 7번 1093 (BufferedReader 확인문제)
public class AddLineNumberExample {

	public static void main(String[] args) throws Exception {
		
		String filePath="C:\\Users\\USER\\Desktop\\BufferdInputStreamEx1.java";
		
		FileReader fis = new FileReader(filePath);
		BufferedReader bf = new BufferedReader(fis);
		
		
		int count=0;
		while((bf.readLine()) != null) {
			count++;
			System.out.println(count + " : " + bf.readLine()); 
		}
		
		
		
	}
	
	
}
