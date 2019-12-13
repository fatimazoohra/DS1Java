package ds1;

import java.io.IOException;
import java.nio.Buffer;

public class Test {
	public static void main(String[] args) throws IOException {
		MyBuffer buf = new MyBuffer(100);
		Lecteur l1 = new Lecteur("lecteur1", "fichier1.txt" ,buf);
		Lecteur l2 = new Lecteur("lecteur2", "fichier2.txt",buf);
		
		Processor p1 = new Processor("processor1",buf);
		Processor p2 = new Processor("processor2",buf);
		
		l1.start();
		l2.start();
		
		p1.start();
		//p2.start();
	}

}
