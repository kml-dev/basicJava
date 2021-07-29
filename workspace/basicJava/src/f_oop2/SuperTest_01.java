package f_oop2;

public class SuperTest_01 {
	public static void main(String[] args) {
		
	}
}

class Parent2{
	int x = 10;
	int y = 20;
	
	int getAdd(){
		return x + y;
	}
}

class Child2 extends Parent2{
	int x = 30;
	int z = 40;
	
	int getAdd(int x){
		System.out.println(x);
		System.out.println(this.x);  // 30 
		System.out.println(super.x); // 10
		return super.getAdd();
	}
	
	
}