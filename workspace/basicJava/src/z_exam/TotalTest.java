package z_exam;

public class TotalTest {		
	// 클래스 TotalTest가 메서드 영역에 로드되며, 클래스 변수는 없고, 클래스 메서드인 main()메서드가 같이 로드된다.
	// static이 붙었기 때문에 클래스 메서드이다
	public static void main(String[] args) {				
	// void가 있기 때문에 return이 없는 메서드이다.
	// TotalTest의 클래스 메소드 main()메소드가 콜 스택에 호출된다.

		TvMaker.color = "Blue"; 						
		// 대입연산자가 있기 때문에 왼쪽부터 확인하여 TvMaker라는 클래스가 M.A에 로드되며, 클래스 변수인 color, inch가 함께 로드된다, 클래스 메서드는 없음 
		// 클래스와 클래스 변수가 M.A로드 되었고 그 중 클래스 변수인 color의 String타입의 초기값인 null을 "blue"로 다시 초기화 했음 
		
		TvMaker tm = new TvMaker();				
		// 인스턴스화 과정
		// TvMaker가 이미 메소드 영역에 로드되었기 때문에 콜스택의 main()메서드에 tm이라는 지역변수 생성
		// new를 통해 tm의 주소가 생성되고 인스턴스이기 때문에 인스턴스 변수인 name, age와 생성자인 TvMaker(),TvMaker(String, int) 가 함께 생성된다.
		// 같은 이름의 메서드가 두개이지만 매개변수 타입과 개수가 달라 해당하는 메서드가 호출된다 (메서드 오버로딩)
		// 콜스택에 TvMaker()가 호출된다
		// 생성자 TvMaker()에 가보면 매개변수가 없고 다음줄에 바로 this("man",25)가 있기 때문에 해당하는 객체의 메서드의 생성자중 String과 int를 받는 TvMaker(String, int)생성자가 
		// 콜스택에 호출되며 tm의 주소에 있는 인스턴스 변수 name의  ""가 man으로 바뀌고 age는 초기화를 안 해주었기 때문에 초기값인 0이 25로 바뀐다. 그 다음 호출이 종료된다.
		// return이 없는 메서드이기 때문에 }를 만나 호출이 종료된다.
		// 인스턴스화 완료
		
		tm.age = 30; //
		// 인스턴스인 tm의 age를 30으로 초기화하는 과정으로 생성자로 초기화된 tm의 age값인 25가 30으로 바뀐다.
		
		
		// 3. 메서드 호출
		// 3.1
		System.out.println(TvControll.channel);  // println() 출력과 동시에 줄바꿈. print()줄 안 바꿈
		// println()메서드를 통해 TvControll.channel을 출력하는데 아직 로드되지 않았기 때문에 클래스인 TvControll과 함께
		// 클래스 상수인 max_channel(기본값 50),min_channel(1)(final이 붙어서 상수), 클래스 변수인 channel, 클래스 메서드인 volumedown()이 메서드 영역에 로드된다.
		// 다음 클래스 변수인 channel의 초기값인 15가 출력된다.
		
		TvControll.volumeDown();
	
		// TvControll클래스의 volumeDown()메서드가 콜스택에 호출되며 현재 channel값인 15가 MAX_CHANNEL값인 50보다 작기때문에 else문이 실행되어 channel값은 16이 된다
		// if문을 빠져나오면 바로 return문을 만나기 때문에 정수형 값인 16을 volumeDown()메서드가 정수형으로 받아와서 리턴한다.
		
		System.out.println(TvControll.channel);
		// 위의 volumeDown()메서드에서 channel이 16으로 바뀌었기 때문에 16이 println()을 통해 출력된다.

		// 3.2
		TvControll tc; //
		// TvControll이 이미 메서드 영역에 로드 되어있기 때문에 바로 호출스택의 main()메서드에 tc라는 지역변수 생성
		
		tc = new TvControll(); // 편의상 변수명 줄여서 쓰겠음
		// new로 만들어진 tc의 주소에 인스턴스 상수(max_v=100, min_v=0), 인스턴스 변수(volume), 인스턴스 메서드(volumeup())가 생성됨
		// 생성자를 따로 만들지 않았기 때문에 시스템에서 TvControll()이라는 생성자를 자동으로 만들어 호출스택에 호출하여 인스턴스화한 다음 tc에 tc의 주소를 대입함.
		
		System.out.println(tc.volume);
		// 인스턴스인 tc의 volume의 초기값인 99출력
		tc.volumeUp();

		// 호출스택에 volumeup()이 호출됨 
		// vu()은 매개변수를 받지 않는 정수형 메서드이기 때문에 다음줄
		// 현재 vol = 99이기 때문에 max_v인 100이 아니라서 else문 실행, volume을 하나 증가 시키는 연산자인 ++를 만나 volume이 100이 됨
		// 100이된 volume을 return하고 호출 종료
		
		System.out.println(tc.volume);
		// tc인스턴스의 인스턴스 변수 volume = 100 이 출력됨
		
		tc.volumeUp();
		//// 호출스택에 volumeup()이 호출됨 
		// vu()은 매개변수를 받지 않는 정수형 메서드이기 때문에 다음줄
		// 현재 vol = 100이기 때문에 max_v인 100과 같아서 min_v = 0 과 같아짐
		// 0이된 volume을 return하고 호출 종료
		
		System.out.println(tc.volume);
		// 0이된 volume 출력
		
		//
		Calc cc = new Calc();
		// Calc라는 클래스가 메서드영역에 로드됨 콜스택의 main()에 cc라는 지역변수 생성
		// new를 통해 cc
		System.out.println(cc.add(Integer.MAX_VALUE, 4));
		System.out.println(cc.add(3L, Integer.MAX_VALUE));

	}
}

class TvMaker {
	// 1.
	// 1.1
	static String color;
	static int inch;
	// 1.2
	String name = "";
	int age;

	// 2.
	// 2.1
	TvMaker() {
		this("man", 25);
	}

	// 2.2
	TvMaker(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class TvControll {
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	static final int MAX_CHANNEL = 50;
	static final int MIN_CHANNEL = 1;

	static int channel = 15;
	int volume = 99;

	// 4. return문
	int volumeUp() {
		if (volume == MAX_VOLUME) {
			volume = MIN_VOLUME;
		} else {
			volume++;
		}

		return volume;
	}

	static int volumeDown() {
		if (channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		} else {
			channel++;
		}
		return channel;
	}
}

class Calc {
	// 5.
	int add(int a, int b) {
		return a + b;
	}

	long add(long a, int b) {
		return a + b;
	}

	int minus(int a, int b) {
		return a + b;
	}
}