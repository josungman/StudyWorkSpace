package chapter18.network;

import java.net.InetAddress;

//이것이 자바다 1056p IPAddress 검색 예제
public class InetAddressExample {

	public static void main(String[] args) {
		
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내컴퓨터 IP주소:" + local.getHostAddress());
			
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				
				System.out.println("www.naver.com IP주소 : " + remote.getHostAddress());
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
