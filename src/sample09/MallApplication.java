package sample09;

import java.util.List;

import util.KeyboardReader;
public class MallApplication {

	
	// 키보드 입력을 읽어서 변환하는 객체
	private KeyboardReader reader = new KeyboardReader();
	// 쇼핑몰관련 서비스를 제공하는 서비스 객체
	// 로그인, 상품조회, 주문하기, 주문내역조회하기, 내정보 보기
	private MallService service = new MallService();
	
	// 로그인 : 서버 어딘가에 인증된 사용자정보를 저장한다. (로그인된 사용자정보를 저장한다.) 
	private User loginedUser;
	
	public static void main(String[] args) {
		MallApplication application = new MallApplication();
		application.menu();
	}
	
	public void menu() {
		if(loginedUser == null) {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.상품조회 2.로그인 0.종료");
			System.out.println("----------------------------------------------------------");
		} else {
			System.out.println("----------------------------------------------------------");
			System.out.println("1.상품조회 2.주문하기 3.주문내역 4.내정보 0.종료");			
			System.out.println("----------------------------------------------------------");
		}
		System.out.println();
		
		System.out.println("### 매뉴선택 :");
		int menuNo = reader.readInt();
		System.out.println();
		
		// 로그인/비로그인 상관없이 사용가능한 기능
		if(menuNo == 1) {
			상품조회();
		} else if(menuNo == 0){
			프로그램종료();
		}
		
		
		if(loginedUser == null) {
			// 비로그인 상태에서만 사용가능한 기능
			if(menuNo == 2) {
				로그인();
			}
		} else {
			// 로그인 상태에서만 사용가능한 기능
			if(menuNo == 2) {
				주문하기();
			} else if(menuNo == 3) {
				주문내역조회();
			} else if(menuNo == 4) {
				내정보보기();
			}
		}
		
		System.out.println();
		System.out.println();
		menu();
		
	} // menu() 끝
	
	private void 상품조회() {
		System.out.println("<< 모든 상품 조회 >>");
		System.out.println("### 모든 상품목록을 확인하세요.");
		
		List<Product> prpductList = service.getAllProducts();
		System.out.println("----------------------------------------------------");
		System.out.println("번호\t상품이름\t제조사\t가격\t재고수량");
		for (Product product : prpductList) {
			System.out.print(product.getNo()+"\t");
			System.out.print(product.getName()+"\t");
			System.out.print(product.getMaker()+"\t");
			System.out.print(product.getPrice()+"\t");
			System.out.println(product.getStock());
		}
		System.out.println("----------------------------------------------------");
	}
	
	
	private void 로그인() {
		System.out.println("<< 로그인 >>");
		System.out.println("### 아이디와 비밀번호를 입력하세요.");
		
		System.out.println("### 아이디 : ");
		String id = reader.readString();
		System.out.println("### 비밀번호 : ");
		String password = reader.readString();
		
		User user = service.login(id, password);
		loginedUser = user;
		System.out.println("### 로그인이 완료되었습니다.");
		
	}
	
	
	private void 주문하기() {
		System.out.println("<< 주문하기 >>");
		
	}
	
	
	private void 주문내역조회() {
		System.out.println("<< 주문 내역 조회 >>");
		
	}
	
	
	private void 내정보보기() {
		System.out.println("<< 내 정보 조회 >>");
		
	}
	
	
	private void 프로그램종료() {
		System.out.println("<< 프로그램 종료 >>");
		System.exit(0);
	}
	
}
