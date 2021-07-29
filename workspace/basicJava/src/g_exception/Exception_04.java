package g_exception;

public class Exception_04 {
	public static void main(String[] args) {
		
		Exception ee = new Exception("23");
		
		try {
			throw ee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
		
		RuntimeException re = new RuntimeException("aa");
		
		try{
			throw re;
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		
		// 컴파일러가 예외처리를 강제하지 않는 경우
		// 1. 에러의 경우
		// 2. RuntimeException클래스들
		// 이런것들을 'unChecked예외'라고 한다.
		
	}
}
