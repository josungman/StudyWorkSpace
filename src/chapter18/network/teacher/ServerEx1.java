package chapter18.network.teacher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(InetAddress.getLocalHost(), 9000));
		System.out.println("연결 기다림");

		while (true) {

			Socket socket = server.accept();
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println(isa.getAddress() + "와 ");
			System.out.println("연결 완료");

			Runnable r = new Runnable() {

				@Override
				public void run() {
					try (InputStream is = socket.getInputStream();
							InputStreamReader isr = new InputStreamReader(is);
							BufferedReader br = new BufferedReader(isr);) {

						String line = null;

						while (!(line = br.readLine()).equals("exit")) {
							System.out.println("수신]" + line);
						}

						br.close();
						if (!socket.isClosed()) {
							socket.close();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			};
			
			new Thread(r).start();

		}
	}
}
