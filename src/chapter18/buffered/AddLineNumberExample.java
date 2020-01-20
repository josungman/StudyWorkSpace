package chapter18.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//이것이 자바다 확인문제 7번 1093 (BufferedReader 확인문제)
public class AddLineNumberExample {

	public static void main(String[] args) throws Exception {
		
		String filePath="C:\\Users\\USER\\Desktop\\BufferdInputStreamEx1.java";
		
		FileInputStream fis = new FileInputStream(filePath);
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis));
		
		
		int count=0;
		while((bf.read()) != -1) {
			count++;
			System.out.println(count + " : " + bf.readLine()); 
		}
		
		
		
	}
	
	
}
