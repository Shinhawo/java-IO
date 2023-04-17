package sample09;

import java.util.Date;
import java.util.List;
import java.util.Map;
import util.DateUtils;

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
			System.out.println("1.상품조회 2.주문하기 3.주문내역 4.내정보 5.로그아웃 0.종료");			
			System.out.println("----------------------------------------------------------");
			System.out.println("["+loginedUser.getName()+"]님 환영합니다.");
		}
		System.out.println();
		
		System.out.println("### 매뉴선택 :");
		int menuNo = reader.readInt();
		System.out.println();
		
		// 로그인/비로그인 상관없이 사용가능한 기능
		// try문을 쓰지 않으면 로그인 실패시 menu()메서드가 아예 끝나버림
		try { 
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
				} else if(menuNo == 5) {
					로그아웃 ();
				}
			}
		}catch (RuntimeException ex) {
			System.out.println(" ### 오류발생 : " + ex.getMessage());
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
	
	private void 로그아웃() {
		System.out.println("<< 로그아웃 >>");
		loginedUser = null;
		
		System.out.println("### 로그아웃이 완료되었습니다.");
	}
	
	private void 주문하기() {
		// 몇번 상품을 몇개 구매?
		System.out.println("<< 주문하기 >>");
		System.out.println("### 상품번호, 구매수량을 입력하세요.");
		
		System.out.println("### 상품번호를 입력하세요 : ");
		int productNo = reader.readInt();
		System.out.println("### 구매수량을 입력하세요. : ");
		int quantity = reader.readInt();
		
		service.order(productNo, quantity, loginedUser.getId());
		
		System.out.println("### 주문이 완료되었습니다.");
	}
	
	
	private void 주문내역조회() {
		System.out.println("<< 주문 내역 조회 >>");
		System.out.println("### 주문내역을 확인하세요.");
		
		List<Map<String, Object>> myOrders = service.getMyOrders(loginedUser.getId());
		
		if(myOrders.isEmpty()) {
			System.out.println("### 주문내역이 존재하지 않습니다.");
		} else {
			System.out.println("------------------------------------------------------");
			System.out.println("주문번호\t주문날짜\t\t상품이름\t구매수량\t구매금액\t적립포인트");
			System.out.println("------------------------------------------------------");
			
			// Map이 여러개 들어있는 List인 myordes에서 Map 하나씩 꺼내기
			// Object로 담겨있는걸 꺼내니까 형변환 필수
			for(Map<String, Object> item : myOrders) {
				int orderNo = (Integer) item.get("OrderNo");
				Date orderDate = (Date)  item.get("OrderDate");
				String productName = (String) item.get("ProductName");
				int orderQuantity = (Integer) item.get("OrderQuantity");
				int orderPrice = (Integer) item.get("OrderPrice");
				int depositPoint = (Integer) item.get("depositPoint");
				
				System.out.print(orderNo+ "\t");
				System.out.print(DateUtils.toText(orderDate) + "\t");
				System.out.print(productName + "\t");
				System.out.print(orderQuantity + "\t");
				System.out.print(orderPrice + "\t");
				System.out.println(depositPoint + "\t");
			}
			System.out.println("------------------------------------------------------");
		}
	}
	
	
	private void 내정보보기() {
		System.out.println("<< 내 정보 조회 >>");
		System.out.println("### 내 정보를 확인하세요.");
		
		System.out.println("-----------------------------------------------");
		System.out.println("사용자 아이디 : "+loginedUser.getId());
		System.out.println("사용자 이름 : "+ loginedUser.getName());
		System.out.println("적립 포인트 : "+loginedUser.getPoint());
		System.out.println("-----------------------------------------------");
	}
	
	
	private void 프로그램종료() {
		System.out.println("<< 프로그램 종료 >>");
		service.save();
		System.exit(0);
	}
	
}
