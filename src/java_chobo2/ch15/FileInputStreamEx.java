package java_chobo2.ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		FileInputStreamEx();
		File file = new File("mysql-connector-java-5.1.49.jar");
		try(FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis, 8192);
				FileOutputStream fos = new FileOutputStream("mysql_lib.jar");
				BufferedOutputStream bos = new BufferedOutputStream(fos, 8192)){
			int data = 0;
			while((data = bis.read())!=-1) {
				bos.write(data);
			}
			
		}

	}

	public static void FileInputStreamEx() {
		try {
			FileInputStream fis = new FileInputStream("output.txt");
			int data = 0;
			try {
				while((data = fis.read())!= -1) {
					System.out.println((char)data);
				}
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
