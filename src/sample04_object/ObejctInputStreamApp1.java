package sample04_object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import java.io.IOException;


public class ObejctInputStreamApp1  {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = "src/sample04_object/obj.sav";
		ObjectInputStream in = new ObjectInputStream (new FileInputStream(path));
		
//		Object object = in.readObject();
//		System.out.println("복원된 객체 -> "+object);
//		
//		in.close();
		
		Score score = (Score)in.readObject();
		System.out.println("이름 : "+score.getName());
		System.out.println("비밀번호 :" + score.getPassword());
		System.out.println("학년 : "+score.getGrade());
		System.out.println("국어 : "+score.getKor());
		System.out.println("영어 : "+score.getEng());
		System.out.println("수학 : "+score.getMath());
		System.out.println("합격여부 : "+score.isPassed());
		
		in.close();
	}
}
