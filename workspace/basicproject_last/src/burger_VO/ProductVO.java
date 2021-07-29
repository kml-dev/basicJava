package burger_VO;

public class ProductVO {
	
	private int seq;
	private String name;
	private int price;
	private int stock;
	private boolean isActivate = true;
	private String kind_name;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getKind_name() {
		return kind_name;
	}
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
	public boolean isActivate() {
		return isActivate;
	}
	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}
	
	@Override
	public String toString() {
		return "(물품 번호 : " + seq + ")\n"
				+ "[물품 이름 : " + name + "]\n"
				+ "[물품 가격 : " + price + "]\n"
				+ "[물품 수량 : " + stock + "]\n"
				+ "[물품 분류 : " + kind_name + "]\n"
				+ " 상태 :" + isActivate;
	}
	
	

}
