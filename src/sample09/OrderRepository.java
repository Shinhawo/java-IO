package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 주문정보
public class OrderRepository {

	private List<Order> orders = new ArrayList<>();
	
	public OrderRepository(){
		try {
			String path = "src/sample09/orders.txt";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while((text = in.readLine()) != null) {
				
				if (text.isBlank()) {
					break;
				}
				
				Order order = Order.createOrder(text);
				orders.add(order);
			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("orders.txt 읽기 오류" ,ex);
		}
		
	}
	
	public int getOrderNo() {
		return orders.get(orders.size()-1).getNo() + 1;
	}
	
	/*
	 * 
	 * 반환타입 : void
	 * 메서드명 : insertOrder
	 * 매개변수 : Order order
	 */
	public void insertOrder(Order order) {
		orders.add(order);
	}
	
	public List<Order> getOrdersByUserId(String userId){
		List<Order> result = new ArrayList<>();
		
		for(Order order: orders) {
			if(order.getUserId().equals(userId)) {
				result.add(order);
			}
		}
		
		return result;
	}
	
	
	public void save() {
		try {
			String path = "src/sample09/orders.txt";
			PrintWriter out = new PrintWriter(path);
			
			for(Order order : orders) {
				String text = order.generateText();
				out.println(text);
			}
			out.close();
			
		}catch (IOException ex) {
			throw new RuntimeException("orders.txt 파일 쓰기 오류", ex);
		}
	}
	
	
}
