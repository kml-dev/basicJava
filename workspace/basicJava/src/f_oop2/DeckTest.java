package f_oop2;

import java.util.Arrays;

public class DeckTest {
	public static void main(String[] args) {
		
		// 8. 카드 한벌을 만들어주세요 d
		Deck d = new Deck();
		System.out.println(Arrays.toString(d.c));  // 모든 카드가 출력되어야함
		
		// 9. d에서 0번째 카드를 가져오세요. - 메서드
		Card pick1 = d.pick(0);
		System.out.println(pick1);
		
		// 10. d에서 임의의 카드를 한장 꺼내주세요. - 메서드
		Card pick2 = d.pick();
		System.out.println(pick2);
		
		// 11. d를 섞어주세요.
		d.shuffle();
		System.out.println(Arrays.toString(d.c));
		
		// 12. d를 1000번 섞어주세요.
		d.shuffle(1000);
		System.out.println(Arrays.toString(d.c));
		
		// 12.5 d에서 0번째 카드를 가져오세요 - 메서드
		Card pick3 = d.pick(0);
		System.out.println(pick3);
		
		// 13. JVM그려주세요.
		
	}
}


class Card{
	static final int KIND_MAX = 4; // 카드 무늬수
	static final int NUM_MAX = 13; // 무늬별 카드수
	
	static final int SPADE = 1;
	static final int DIAMOND = 2;
	static final int HERAT = 3;
	static final int CLOVER = 4;
	
	int kind;
	int number;
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	Card(){
		this(SPADE, 1);
	}
	
	@Override
	public String toString(){
		String kind = "";
		String number = "";
		
		switch(this.kind){
			case 1:
				kind = "SPADE";
				break;
		
			case 2:
				kind = "DIAMOND";
				break;
				
			case 3:
				kind = "HEART";
				break;
				
			default:
				kind = "CLOVER";
				break;		
		}
		
		switch(this.number){
			case 1:
				number = "A";
				break;
				
			case 11:
				number = "J";
				break;
				
			case 12:
				number = "Q";
				break;
				
			case 13:
				number = "K";
				break;
				
			default:
				number += this.number;
				break;		
		}
				
		return kind + " : " + number;
	}
}

class Deck{
	// 1. 카드의 수량을 저장할 수 있는 변수 CARD_NUM을 Card클래스의 상수를 이용하여 초기화해주세요.
	static final int CARD_NUM = Card.KIND_MAX * Card.NUM_MAX;
			
	// 2. 카드를 CARD_NUM만큼 저장해주세요 변수명 : c
	Card[] c = new Card[CARD_NUM];
	
	
	// 3. 기본생성자를 만들어 주세요.
	// 단, 기본생성자 내에서 c의 모든 방을 카드로 채워주세요 1,1 -> 4,13
	Deck(){
		int a = 0;
		for(int i = 1; i < Card.KIND_MAX+1; i++){
			for(int j = 1; j < Card.NUM_MAX+1; j++){
				c[a++] = new Card(i,j);
//				switch(i){
//					case 1:
//						c[j-1] = new Card(i, j);
//						break;
//					case 2:
//						c[j-1+Card.NUM_MAX] = new Card(i,j);
//						break;
//					case 3:
//						c[j-1+Card.NUM_MAX*2] = new Card(i,j);
//						break;
//					default:
//						c[j-1+Card.NUM_MAX*3] = new Card(i,j); 	
//				}
			
			}
		}
	}
	
	
	// 4. c에서 인자값으로 받은 번째방의 카드 한장을 반환해주세요 pick
	Card pick(int p){
		return c[p];
	}
	
	// 5. c에서 임의의 방번째 카드 한장을 반환해주세요 pick
	// 단, 4번의 pick 메서드를 활용해주세요.
	Card pick(){
		int rand = (int)(Math.random()*CARD_NUM);
		return pick(rand);
	}
	
	// 6. 카드를 섞어주세요 shuffle
	// 단, 연습문제 5-6번을 활용해주세요.
	void shuffle(){
		for(int i = 0; i < c.length; i++){
			Card temp = c[i];
		 	int rand = (int)(Math.random()*c.length);
		 	c[i]  = c[rand];
		 	c[rand] = temp;
		 }
	}
	
	// 7. 카드를 섞어주세요 shuffle
	// 인자값으로 받은 횟수만큼 반복
	// 임의의 방의 카드와 또다른 임의의 방의 카드를 바꿔주세요
	
	void shuffle(int num){
		int cnt = 1;
		while(cnt < num+1){
			int rand1 = (int)(Math.random()*c.length);
			int rand2 = (int)(Math.random()*c.length);
			Card temp = c[rand1];
			c[rand1]  = c[rand2];
			c[rand2] = temp;
			cnt++;
		}
	}
	
}
	
	
	
	
	
	
	
	
	
	
