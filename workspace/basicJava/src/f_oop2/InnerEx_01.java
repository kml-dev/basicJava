package f_oop2;

public class InnerEx_01 {
	public static void main(String[] args) {
		System.out.println(InnerEx_01.StaticInner.cv);
		
		InnerEx_01.StaticInner sc = new InnerEx_01.StaticInner();
		InnerEx_01 ie = new InnerEx_01();
		InnerEx_01.InstanceInner ii = ie.new InstanceInner();
		
	}
	
	static class StaticInner{
		int iv = 200;
		static int cv = 300;
	}
	
	class InstanceInner{
		int iv = 50;
//		static int cv = 70;
		static final int CCC = 90;
	}
	
	void method(){
		class LocalInner{
			int iv = 20;
//			static int cv = 60;
		}
	}
}


