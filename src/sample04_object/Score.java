package sample04_object;

import java.io.Serializable;

public class Score implements Serializable {
	
	private static final long serialVersionUID = 458734078915182485L;
	private String name;
	private transient String password;
	private int grade;
	private int kor;
	private int eng;
	private int math;
	private boolean passed;
	
	public Score() {}
	
	public Score(String name, String password, int grade, int kor, int eng, int math, boolean passed) {
		super();
		this.name = name;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.passed = passed;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
	
	
}
