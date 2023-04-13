package sample06_character;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import sample04_object.Score;

public class WriterApp {

	public static void main(String[] args) throws IndexOutOfBoundsException, FileNotFoundException {
		
		String path = "src/sample06_character/score.txt";
		PrintWriter out = new PrintWriter(path); // 파일에 기록되게 할래잉
		
		Score score = new Score();
		score.setName("홍길동");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(80);
		score.setMath(80);
		score.setPassed(true);
		
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(score.getName())
			.add(String.valueOf(score.getGrade()))
			.add(String.valueOf(score.getKor()))
			.add(String.valueOf(score.getEng()))
			.add(String.valueOf(score.getMath()))
			.add(String.valueOf(score.isPassed()));
		
		String text = joiner.toString();
		
		out.println(text);
		out.println(text);
		out.println(text);
		out.println(text);
		
		out.close();
		
	}
}
