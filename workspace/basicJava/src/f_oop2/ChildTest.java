package f_oop2;

public class ChildTest {
	public static void main(String[] args) {
		Child ch = new Child();
		
		ch.volume = 10;
		System.out.println(ch.volume); //10
		
		ch.volumeUp();
		System.out.println(ch.volume); //11
		
		ch.channel = 15;
		System.out.println(ch.channel); //15
		
		ch.channelUp();
		System.out.println(ch.channel); //16 
		
	}
}

class Parent{
	int channel;
	
	void channelUp(){
		channel++;
	}
}

class Child extends Parent{
	int volume;
	int channel;
	
	void volumeUp(){
		volume++;
	}
}