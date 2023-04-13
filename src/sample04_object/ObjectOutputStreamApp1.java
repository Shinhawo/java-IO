package sample04_object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamApp1 {

	public static void main(String[] args) throws IOException {
		
		Score score = new Score();
		score.setName("홍길동");
		score.setPassword("zxcv1234");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(80);
		score.setMath(70);
		score.setPassed(true);
		
		String path = "src/sample04_object/obj.sav";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		
		out.writeObject(score); // 객체 전체로 뭔가를 하는 것은 보안상 나쁘다 NotSerializableException
		                        // -> 직렬화 가능한 객체라고 표시해줘야 한다.
		                        // -> Score implements Serializable (직렬화 가능한 객체)
		out.close();
	}
}
