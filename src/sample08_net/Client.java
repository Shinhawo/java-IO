package sample08_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException{
		
		System.out.println("클라이언트 프로그램이 시작됨...");

		BufferedReader keyboard 
					= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("서버로 접속요청을 보냈음...");
		Socket socket = new Socket("192.168.0.7", 3000);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("서버와 데이터를 주고받을 준비가 되었음...");
		
		System.out.print("내용을 입력하세요 : ");
		String text = keyboard.readLine();
		
		out.println(text);
		System.out.println("서버로 메세지를 전송함...");
		
		String receiveText = in.readLine();
		System.out.println("서버의 응답메세지 : "+ receiveText);
		
		socket.close();
		System.out.println("클라이언트 프로그램이 종료됨...");
	}

}
