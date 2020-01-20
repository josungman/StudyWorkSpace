package chapter18.network;

import java.net.InetAddress;

public class IPAddressEx1 {

		public static void main(String[] args) throws Exception {
			
			//내 자신 IP
			InetAddress myip = InetAddress.getLocalHost();
			System.out.println(myip.getHostAddress());
			
			
			//내 주소를 열어놓고 기다리는 코드
			
			
		}
	
}
