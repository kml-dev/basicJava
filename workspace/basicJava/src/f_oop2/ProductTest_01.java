package f_oop2;

import java.util.Vector;

public class ProductTest_01 {
	public static void main(String[] args) {
		Computer cp1 = new Computer(200, "삼보");
		HandPhone hp1 = new HandPhone(100, "갤럭시");
		Styler st1 = new Styler(400, "LG");

		Buyer b1 = new Buyer("이경민", 10000000);
		Buyer b2 = new Buyer("이경민2", 10000000);
		Buyer b3 = new Buyer("이경민3", 10000000);
		DBClass db = new DBClass();
		boolean result = db.addBuyer(b1);
		
		b1.buy(cp1, 1);
		b1.buy(hp1, 1);
		b1.buy(st1, 4);
	
		b1.buy(st1, 5);

		b2.buy(st1, 6);
		b1.summary();	
		System.out.println();
		b1.refund(st1);
		b1.refund(st1);
		
		System.out.println(Buyer.bList);
		System.out.println();
		System.out.println(Product.pList);
	}
}

class Product{
	int price;
	int mileage;
	String name;
	
	public Product(int price, String name){
		this.price = price;
		this.name = name;
		mileage = price / 20; 
	}
}

class Computer extends Product{
	public Computer(int price, String name){
		super(price, name);
	}

	@Override
	public String toString() {
		return "삼보";
	}
}

class HandPhone extends Product{
	public HandPhone(int price, String name){
		super(price, name);
	}	
	
	@Override
	public String toString() {
		return "갤럭시";
	}
}

class Styler extends Product{
	public Styler(int price, String name){
		super(price, name);
	}

	@Override
	public String toString() {
		return "LG";
	}
}

class Buyer{
	String name;
	int money;
	int mileage;
	
	Vector item = new Vector();
	
	public Buyer(String name, int money){
		this.name = name;
		this.money = money;
	}
	void buy(Product p, int num){
		// 1. 구매할 여력이 있는지 확인
		if(money < p.price * num){
			// 1.1 나가
			System.out.println("돈 들고 다시 오세요");
			return;
		}
		// 1.2 판매 진행
		// 돈 -> 줄어든다
		money -= p.price * num;
		// 마일리지 -> 늘어난다.
		this.mileage += p.mileage * num;
		// 구매내역 추가
		for(int i = 0; i < num; i++){
			item.add(p);
		}
		// ~상품을 구매하셨습니다. 감사합니다.
		System.out.println(p.name +" 상품을 구매하셨습니다. 감사합니다.");
	}
	
	// summary()
	/*
	 	영	수	증
	 	
	 구매내역
	 	Styler		400만원
	 	Styler		400만원
	 	Handphone 	100만원
	 	Computer 	200만원
	 	
	 	합계			1000만원
	 	
	 	xx 고객님의 남은 돈은 xx이고 마일리지는 xx입니다.
	 	호갱님 감사합니다.
	 */
	void summary(){
		System.out.println("	영	수	증	");
		System.out.println();
		System.out.println("구매내역");
		
		if(item.isEmpty()){
			System.out.println("구매내역이 없습니다.");
			return;
		}
		int num = 0;
		for(int i = 0; i < item.size(); i++){
			Product pd = (Product)item.get(i);
			num += pd.price;
			System.out.println("\t"+ pd.name + "\t" + pd.price + "만원");				
		}
		System.out.println();
		System.out.println("\t합계\t" + num + "만원");
		System.out.println();
		System.out.println(name + " 고객님의 남은 돈은 "+ money+ "만원이고 마일리지는 "+mileage+"만원입니다.");
		System.out.println("호갱님 감사합니다.");
	}
	
	//반품 refund
	/*
	 1. 물건을 구매한 적이 없는 경우
	 2. 자신이 구매한 물건일 때만 반품이 가능해야 한다.
	 */
	void refund(Product p){
		if(item.isEmpty()){
			System.out.println("사기치지 마3");
			return;
		}
		if(item.remove(p)){
			money += p.price;
			mileage -= p.mileage;
			System.out.println(p.name + "상품이 반품되었습니다.");
		}else{
			System.out.println("저희 매장에서 구매한 물품이 아닙니다.");
		}
	}
	
	@Override
	public String toString() {
		return "이름 = " + name + ", 소지금 = " + money + ", 마일리지 = "
				+ mileage + "\n";
	}
	
}

// 1. 물건의 수량을 관리할 수 있도록 해주세요

// 2. 여러사람을 관리할 수 있도록 해주세요

// 3. 구매내역..
class Sale{
	static int seq = 1;
	int mount;
	String date;
	String mem_name;
	String pro_name;	
}

class DBClass{
	// 1. 사람들
	Vector<Buyer> buyers = new Vector<>();
	
	// 2. 물건들
	Vector<Product> product = new Vector<>();
	
	// 3. 구매내역
	Vector<Sale> sale = new Vector<>();
	
	public boolean addBuyer(Buyer b){
		boolean result = buyers.add(b);
		return result;
	}
}
	
