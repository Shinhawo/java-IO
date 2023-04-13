package sample03_data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp1 {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		// DataOutputStream writeInt() 데이터의 타입과 값이 같이 기록된다.
		// DataInputStream readInt() 데이터의 타입과 값을 같이 읽어온다.
		
		String name = "홍길동";
		int grade = 3;
		int kor =100;
		int eng =100;
		int math =80;
		boolean passed = true;
		
		String path = "src/sample03_data/sample.sav";
		// 스트림 연결
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		
		out.writeUTF(name);
		out.writeInt(grade);
		out.writeInt(kor);
		out.writeInt(eng);
		out.writeInt(math);
		out.writeBoolean(passed);
		
		out.close();
	}
}
