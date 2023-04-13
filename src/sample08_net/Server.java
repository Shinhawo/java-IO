package sample08_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(3000);
		System.out.println("서버 프로그램이 시작되었음...");
		
		System.out.println("서버가 클라이언트의 접속을 기다리고 있음...");
		Socket socket = serverSocket.accept();
		System.out.println("클라이언트의 접속이 수락되었음...");
		
		BufferedReader in 
					= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("클라이언트와 데이터를 주고받을 준비가 완료되었음.");
		
		String text = in.readLine();
		System.out.println("클라이언트가 보낸 메세지 -> "+ text);
		
		out.println("메세지를 정상적으로 수신하였습니다. 수신된 메세지 -> ["+text+"]");
		
		serverSocket.close();
		System.out.println("서버 프로그램이 종료되었음...");
		
	}
}
