package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

// 사용자 정보
public class UserRepository {

	// users.txt파일에 기록된 사용자 정보가 저장되는 객체다.
	private List<User> users = new ArrayList<>();
	
	// UserRepository 객체가 만들어지자 마자 User파일을 읽어오게 할 것이야
	public UserRepository() {
		
		try {
			String path = "src/sample09/users.txt";
			// 파일을 한줄씩 읽어오기          한줄씩              path 파일을
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while ((text = in.readLine()) != null) {
				
				if (text.isBlank()) {
					break;
				}
				
				// text를 전달해 줬더니 User 탄생
				User user = User.createUser(text);
				// 그 User를 ArrayList인 users에 담앗
				users.add(user); 
 			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("user.txt 파일 읽기 오류", ex);
		}
		
	}
	
	/*
	 * 아아디를 전달받아서 아이디에 해당하는 사용자정보를 반환한다.
	 * 반환타입 : User
	 * 메서드명 : getUserById
	 * 매개변수 : String id
	 */
	public User getUserById(String id) {
		for(User user : users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
}
