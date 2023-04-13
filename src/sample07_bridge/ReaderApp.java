package sample07_bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderApp {

	public static void main(String[] args) throws IOException{
		
		// 키보도 입력을 한 줄씩 읽어오기
		
		// 1. 키보드와 연결된 스트림객체를 획득하기 (System.in)
		InputStream inputStream = System.in;        // 1byte씩 읽어오는 스트림이다.
		
		// 2. 키보드와 연결된 스트림을(inputStream) Reader와 연결하기
		InputStreamReader isr = new InputStreamReader(inputStream); // 1글자씩
		
		// 3. BufferedReader 스트림과 연결하기 -> 한줄씩 읽기 가능
		BufferedReader br = new BufferedReader(isr); // 1라인씩 읽어오는 스트림이다.
		
		// 4. 키보드 입력을 읽어오기
		System.out.println("내용을 입력하세요 : ");
		String text = br.readLine();
		
		// 5. 키보드 입력내용을 출력해보기
		System.out.println("입력내용 : "+ text);
	}
}
