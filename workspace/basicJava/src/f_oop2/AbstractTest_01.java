package f_oop2;

public class AbstractTest_01 {
	public static void main(String[] args) {
		
	}
}

abstract class Unit{
	int x;
	int y;
	
	abstract void move(int x, int y);
	
	void stop(){
		
	}
}

class Marine extends Unit{
		
	void stimPack(){
		
	}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}

class Tank extends Unit{
	
	void changeMode(){
		
	}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	
}

class Dropship extends Unit{

	void load(){
		
	}
	
	void unload(){
		
	}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}