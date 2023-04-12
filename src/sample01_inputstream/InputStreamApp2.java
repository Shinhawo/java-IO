package sample01_inputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InputStreamApp2 {
	
	public static void main(String[] args) throws Exception{

		// 원본파일을 읽어서 백업 파일을 생성하기
		String src ="src/sample01_inputstream/sample.jpg";
		String dest = "src/sample01_inputstream/sample_backup.jpg";
		FileInputStream in = new FileInputStream(src);     // 무조건 파일 필요!
		FileOutputStream out = new FileOutputStream(dest); // 파일이 없어도 됨~
		
		long startTime = System.currentTimeMillis();
		
		// 1byte씩 읽고 기록하기 
//		int value = 0;
//		while((value = in.read()) != -1) {
//			out.write(value);
//		}
		// 7.7초
		
		// byte[] 배열을 이용해서 읽고 기록하기
		byte[] buf = new byte[1024*8];
		int length = 0;
		while((length = in.read(buf)) != -1) {
			out.write(buf, 0, length);
		}
		// 거의 0초
		
		in.close();
		out.close();
		
		long endTime = System.currentTimeMillis();
	
		System.out.println("소요시간 -> "+(endTime - startTime)+"밀리초.");
	}
}
