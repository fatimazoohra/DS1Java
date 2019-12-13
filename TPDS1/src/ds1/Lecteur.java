package ds1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Lecteur extends Thread{
	public String FileName;
	public String ThreadName;
	public static MyBuffer buff;
	private static File file;
	private BufferedInputStream bis;
	private static int n;
	public Lecteur(String threadName, String fileName, MyBuffer buff) throws FileNotFoundException {
		this.FileName = fileName;
		this.ThreadName = threadName;
		this.buff = buff;
		file = new File(fileName);	
		bis = new BufferedInputStream(new FileInputStream(file));
	}
	public synchronized String readWord() throws IOException {
		byte[] buffer = new byte[1];
		int bytes;
		String word = "";
		while((bytes = bis.read(buffer)) != -1) {
			for (int i = 0; i < bytes; i++) {
				char c = (char)buffer[i];
				if(!Character.isWhitespace(c)) {
					word+=c;
					continue;
				}
				return word;
			}
			n+=bytes;
		}
		bis.skip(n);
		return null;
	}
	public synchronized void  run() {
		try {
			while(true) {
				while(buff.size >= buff.getData().size()) {
					String word = readWord();
					System.out.println(this.ThreadName +" added \""+word+"\" to data list");
					buff.getData().add(word);
					Thread.sleep(500);
				}
			//System.out.println(this.ThreadName +": i need place ");
		Thread.sleep(500);
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}