package f_oop2;

public class OverTest {
	public static void main(String[] args) {
		OverGo og = new OverGo();
		String result = og.upMethod();

		System.out.println(result);
		
		String re = og.overGoUpMethod();
		System.out.println(re);
				
		
	}
}

class OverUp{
	String upMethod(){
		return "OverUpMethod";
	}
}

class OverGo extends OverUp{
	
	@Override
	String upMethod(){
		return "OverGoMethod";
	}
	
	String upMethod(int a){
		return a + "OverGo";
	}
	
	String overGoUpMethod(){
		String re = super.upMethod();
		return re;
	}
}