package e_oop;

public class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car("auto");
		Car c3 = new Car("skyblue","auto");
		Car c4 = new Car("blue","auto",2);
		
		System.out.print("c3 : ");
		System.out.print(c3.color + " ");
		System.out.print(c3.gearType + " ");
		System.out.println(c3.door);
		
		System.out.print("c4 : ");
		System.out.print(c4.color + " ");
		System.out.print(c4.gearType + " ");
		System.out.println(c4.door);
		
	}
}

class Car{
	String color;
	String gearType;
	int door;
	
	Car(){
		color = "black";
		gearType = "stick";
		door = 4;
	}
	
	
	Car(String gearType){
		this();
		this.gearType = gearType;
	}
	
	Car(String color, String gearType){
		this();
		this.color = color;
		this.gearType = gearType;
	}

	Car(String color, String gearType,int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}