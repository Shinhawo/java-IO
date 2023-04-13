package sample05_buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferdApp1 {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		long startTime = System.currentTimeMillis();
		
		String src = "src/sample05_buffered/sample.zip";
		String dest = "src/sample05_buffered/sample_backup.zip";
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		
		int value = 0;
		while ((value = in.read()) != -1) {
			out.write(value);
		}
		
		in.close();
		out.close();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간 -> "+ (endTime - startTime) + "밀리초");
	}
}
