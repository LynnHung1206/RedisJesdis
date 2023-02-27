package json_base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class TestBase64 {
	
	public static void main(String[] args) throws IOException {
//		相對路徑,指專案下的圖片檔
		File file = new File("FC_Bayern.png");
		FileInputStream fis = new FileInputStream(file);
		byte[] pic = new byte[fis.available()];
		fis.read(pic);
		fis.close();
		
		// Base64 encodes 3 bytes to 4 characters.
		
		// encode
		String base64str = Base64.getEncoder().encodeToString(pic);
		System.out.println(base64str);
		
		// decode
		byte[] fromBase64str = Base64.getDecoder().decode(base64str);
		FileOutputStream fos = new FileOutputStream("fromBase64str.png");
		fos.write(fromBase64str);
		fos.flush();
		fos.close();
		
	}
}
