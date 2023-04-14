package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}
