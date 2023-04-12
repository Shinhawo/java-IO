package sample02_outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamApp1 {

	public static void main(String[] args) throws IOException {
		FileOutputStream out 
			= new FileOutputStream("src/sample02_outputstream/sample.txt");
		
		// 문자열을 직접 기록은 불가능 : text 전용이 아니라서 / 정수 혹은 문자 혹은 byte[]
//		out.write(65);      // 'A'가 기록된다.
//		out.write(66);      // 'B'가 기록된다.
//		out.write(67);      // 'C'가 기록된다.
//		out.write('a');     // 'a'가 기록된다.
//		out.write('b');     // 'b'가 기록된다.
//		out.write('c');     // 'c'가 기록된다.
//		out.write('d');     // 'd'가 기록된다.
//		out.write('가');  // 글자가 제대로 기록되지 않는다.
//		out.write('나');  // 글자가 제대로 기록되지 않는다.
//		out.write('다');  // 글자가 제대로 기록되지 않는다.
		// ABCabcd?? -> 영문자가 아닌 것은 깨진다.
		
		String text = "안녕하세요, 반갑습니다.";
		byte[] bytes = text.getBytes();
		out.write(bytes); // 안녕하세요, 반갑습니다.
		
		
		out.close();
	}
}
