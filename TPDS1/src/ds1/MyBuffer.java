package ds1;

import java.util.LinkedList;

public final class MyBuffer {
	private LinkedList<String> data;
	public int size;
	public MyBuffer(int size) {
		size = size;
		data = new LinkedList<String>();
	}
	
	public LinkedList<String> getData() {
		return data;
	}
	
	public void addWord(String word) {
		this.data.add(word);
	}
	
	/*public boolean emptyPlace() {
		return (this.size > this.data.size());
	}*/

}
