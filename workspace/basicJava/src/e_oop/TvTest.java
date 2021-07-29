package e_oop;

public class TvTest {
	public static void main(String[] args) {
		// 클래스 변수 : 클래스명.변수명
		System.out.println(Tv.color);
		
		Tv.color = "red";
		System.out.println(Tv.color);
		
		Tv.changeColor();
		System.out.println(Tv.color);
		
		Tv t = new Tv();  // 인스턴스 생성
		
		// 인스턴스 친구들 접근
		// 참조변수명.변수명
		System.out.println(t.power);
		
		t.power();
		System.out.println(t.power);
		
		// 1.tv의 채널을 15번으로 바꿔주세요.
		t.channel = 15;
		System.out.println(t.channel);
		
		// 2.tv의  채널을 하나 증가시켜주세요.
		t.channelUp();
		System.out.println(t.channel);
		
	}
}


class Tv{
	// 멤버변수(전역변수) : 클래스 변수, 인스턴스 변수
	static String color;// 색상      기본값: null     <- static 붙은 건 클래스 변수
	boolean power;// 전원    		  기본값: false
	int channel;// 채널        		  기본값: 채널
	
	// 클래스 메서드
	static void changeColor(){
		color = "black";
		
	}
	// 인스턴스 메서드
	void power(){
		power = !power;
	}
	
	void channelUp(){
		channel++;
	}
}