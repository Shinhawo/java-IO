package sample03_data;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamApp1 {

	public static void main(String[] args) throws IOException{
		
		String path = "src/sample03_data/sample.sav";
		DataInputStream in = new DataInputStream( new FileInputStream(path) );
		
		String name = in.readUTF();
		int grade = in.readInt();
		int kor = in.readInt();
		int eng = in.readInt();
		int math = in.readInt();
		boolean passed = in.readBoolean();
		
		in.close();
		
		System.out.println("이름 : "+name);
		System.out.println("학년 : "+grade);
		System.out.println("국어 : "+kor);
		System.out.println("영어 : "+eng);
		System.out.println("수학 : "+math);
		System.out.println("합격여부 : "+passed);
				
	}
}
