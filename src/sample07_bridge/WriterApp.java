package sample07_bridge;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriterApp {

	public static void main(String[] args) throws IOException {
		
		String path = "src/sample07_bridge/sample.txt";
		
		FileOutputStream fos = new FileOutputStream(path);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		PrintWriter writer = new PrintWriter(osw);
		
		writer.println("브릿지 스트림 연습");
		
		writer.close();
	}
}
