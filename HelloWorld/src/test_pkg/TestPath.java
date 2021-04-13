package test_pkg;

import java.io.File;
import java.io.IOException;

public class TestPath {

	public TestPath() {
		// TODO Auto-generated constructor stub
		File directory = new File("");//参数为空 
		String courseFile ="";
		try {
			courseFile = directory.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(courseFile); 
	}

}
