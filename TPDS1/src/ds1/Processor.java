package ds1;

import java.util.HashMap;

public class Processor extends Thread{
	private String PName;
	//static for buff;
	private MyBuffer buff;
	public  HashMap<String,Integer> wordsCounts;
	
	public Processor(String PName, MyBuffer buff) {
		this.PName = PName; 
		this.wordsCounts = new HashMap<String,Integer>();
		this.buff = buff;
	}
	
	public HashMap<String,Integer> getWordsCounts(){
		return this.wordsCounts;
	}
	
	public void process() {
		if (buff.getData().size() == 0) return;
		else {
			for(int i=0;i<this.buff.getData().size();i++) {
				if(wordsCounts.containsKey(buff.getData().get(i))) {
					wordsCounts.replace(buff.getData().get(i),wordsCounts.get(buff.getData().get(i))+1);
				}
				else {
					wordsCounts.put(buff.getData().get(i),1);
				}
				//buff.getData().remove(i);
				System.out.println(this.PName +" removed \""+buff.getData().remove(i)+"\" from data list and add it to wordscounts");
				System.out.println(this.wordsCounts);
				System.out.println("------------------------------------------------------------------------------");
			}
		}
		//System.out.println(wordsCounts);
	}  
	
	public synchronized void run(){
		while(true) {
			try {
				Thread.sleep(3000);
				process();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
