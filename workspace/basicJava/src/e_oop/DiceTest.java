package e_oop;

public class DiceTest {
	public static void main(String[] args) {
		// 2. throwDice메서드를 호출
		DoubleDice dd = new DoubleDice();
		int res = dd.throwDice();
		
		System.out.print("주사위의 합: ");
		System.out.print(res);
		// 3. JVM 3-3, 4-4, 3-1의 전제하에
	}
}


class DoubleDice{
	
	// 1. 주사위 두개를 던지는 그 합을 반환하는 throwDice 메서드를 만들어 주세요.
	  // 단, 두개의 주사위가 같으면 한번 더 던진다.
		int throwDice(){
			int firstDice = (int)(Math.random()*6+1);
			System.out.println("첫번째 주사위 : " + firstDice);
			
			int secondDice = (int)(Math.random()*6+1);
			System.out.println("두번째 주사위 : " + secondDice);
			
			int result = firstDice + secondDice;
			
			if(firstDice == secondDice){
				result += throwDice();
			}	
			return result;
		}
}