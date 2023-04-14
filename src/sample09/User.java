package sample09;

import java.text.MessageFormat;

public class User {
	
	private String id;
	private String password;
	private String name;
	private int point;
	
	public User() {}

	public User(String id, String password, String name, int point) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	// 이 메서드를 사용할때는 문자열을 User로 바꾸고 싶은거니까 User는 아직 안만들어짐 User.cre -> 유저만들어짐
	public static User createUser(String text) {
		// text -> "hong,zxcv1234,홍길동,10000"
		// values -> {"hong", "zxcv1234", "홍길동", "10000"}
		
		String[] values = text.split(",");
		String id = values[0];
		String password = values[1];
		String name = values[2];
		int point = Integer.parseInt(values[3]);
		
		return new User(id, password, name, point);
	}
	
	// User안에 들어있는 값을 가지고 만드는 메서드니까 멤버 메서드닷!
	public String generateText() {
		
		return MessageFormat.format("{0},{1},{2},{3}", 
										id, password, name, point);
	}
}
