package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// 상품정보
public class ProductRepository {

	private List<Product> products = new ArrayList<>();
	
	public ProductRepository() {
		try {
			String path = "src/sample09/products.txt";
			BufferedReader in = new BufferedReader(new FileReader(path));
			String text = null;
			while((text = in.readLine()) != null ) {
				
				if (text.isBlank()) {
					break;
				}
				
				Product product = Product.createProduct(text);
				products.add(product);
			}
			in.close();
		} catch (IOException ex) {
			throw new RuntimeException("products.txt 읽기 오류", ex);
		}
	}
	
	/*
	 * 모든 상품정보를 반환한다.
	 * 반환타입 : List<Product>
	 * 메서드명 : getProducts
	 * 매개변수 : 없음
	 */
	public List<Product> getProducts() {
		return products;
	}
	
	
	/*
	 * 상품번호를 전달받아서 상품번호와 일치하는 상품정보를 반환한다.
	 * 반환타입 : Product
	 * 메사드명 : getProductByNo
	 * 매개변수 : int no
	 */
	public Product getProductByNo (int no) {
		
		for(Product product : products) {
			if(product.getNo() == no) {
				return product;
			} 
		}
		return null; // 같은 번호 없을 때의 경우 
	}
	
	public void save() {
		try {
			String path = "src/sample09/products.txt";
			PrintWriter out = new PrintWriter(path);
			
			for(Product product : products) {
				String text = product.generateText();
				out.println(text);
			}
			out.close();
			
		}catch (IOException ex) {
			throw new RuntimeException("products.txt 파일 쓰기 오류", ex);
		}
	}
	
}

