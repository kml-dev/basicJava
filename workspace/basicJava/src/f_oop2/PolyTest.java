package f_oop2;

public class PolyTest {
	public static void main(String[] args) {
		// 1. SmartTv 2대 저장해주세요
		SmartTv st1 = new SmartTv();
		SmartTv st2 = new SmartTv();
		SmartTv[] stv = new SmartTv[2];
		
		stv[0] = st1;
		stv[1] = st2;
//		SmartTv[] stv = {st1, st2};
		
		// 2. AfreecaTv 3대 저장해주세요
		AfreecaTv at1 = new AfreecaTv();
		AfreecaTv at2 = new AfreecaTv();
		AfreecaTv at3 = new AfreecaTv();
		AfreecaTv[] atv = new AfreecaTv[3];
		
		atv[0] = at1;
		atv[1] = at1;
		atv[2] = at1;
		
		// 3. ThreeDTv 4대 저장해주세요
		ThreeDTv tt1 = new ThreeDTv();
		ThreeDTv tt2 = new ThreeDTv();
		ThreeDTv tt3 = new ThreeDTv();
		ThreeDTv tt4 = new ThreeDTv();
		ThreeDTv[]  ttv = new ThreeDTv[4];
		
		ttv[0] = tt1;
		ttv[1] = tt2;
		ttv[2] = tt3;
		ttv[3] = tt4;
		
		Tv[] t = new Tv[9];
		t[0] = st1;
		t[1] = st2;
		
		t[2] = at1;
		t[3] = at2;
		t[4] = at3;
		
		t[5] = tt1;
		t[6] = tt2;
		t[7] = tt3;
		t[8] = tt4;
		
		AfreecaTv a = (AfreecaTv) t[3];
		a.starBalloon();
	}
}

class Tv{
	boolean power;
	int channel;
	
	void power(){
		power = !power;
	}
	
	void channelUp(){
		channel++;
	}
	
	void channelDown(){
		channel--;
	}
}

class SmartTv extends Tv{
	void internet(){
		
	}
}

class AfreecaTv extends Tv{
	void starBalloon(){
		
	}
}

class ThreeDTv extends Tv{
	void auziruwo(){
		
	}
}
