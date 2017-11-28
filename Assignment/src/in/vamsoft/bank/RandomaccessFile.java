package in.vamsoft.bank;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomaccessFile {
	
	public static String readRandomaccess(String str,int line) {
		
		String s=null;
		try {
			RandomAccessFile raf=new RandomAccessFile(str, "rw");
			try {
				raf.seek(line);
				s=raf.readUTF();
			} catch (IOException e) {
				
				System.out.println("no data read to pointing");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	public static void writeRandomaccess(String str,int line,String s) {
		try {
			RandomAccessFile raf=new RandomAccessFile(str, "rw");
			try {
				raf.seek(line);
				raf.writeUTF(s);
				raf.close();
			} catch (IOException e) {
				System.out.println("no data to write pointing");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		String data ="writing into random accessfile";
		writeRandomaccess("random", 100, data);
		String from=readRandomaccess("random", 100);
		System.out.println(from);
	}

}