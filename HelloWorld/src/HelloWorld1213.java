import java.io.File;
import java.io.IOException;

import test_pkg.TestPath;

public class HelloWorld1213 {
	public void print(String str) {
		System.out.println(str);
	}
	public static void main(String args[]) {
		HelloWorld1213 hw = new HelloWorld1213();
		File directory = new File("");//参数为空 
		String courseFile ="";
		try {
			courseFile = directory.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(courseFile); 
//		/home/jst/tomcat/jst-server/             one-count-front
//		/Users/wenbren/eclipse-workspace/        HelloWorld
		
		TestPath tp = new TestPath();
		
		
		File file = new File("./test/123/345/678");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.mkdirs());
		System.out.println("1111"+file.exists());
		System.out.println("2222"+file.isDirectory());
		hw.print("Hello World !!!");
	}
}
