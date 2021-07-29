package burger_VO;

import java.util.List;
import java.util.Map;

public class OrderDetailsVO {
	private int seq;
	private int order_seq;
	private int totalPrice;
	private int userStock;
	private int product_seq;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getOrder_seq() {
		return order_seq;
	}
	public void setOrder_seq(int order_seq) {
		this.order_seq = order_seq;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getUserStock() {
		return userStock;
	}
	public void setUserStock(int userStock) {
		this.userStock = userStock;
	}

	public int getProduct_seq() {
		return product_seq;
	}
	public void setProduct_seq(int product_seq) {
		this.product_seq = product_seq;
	}
	@Override
	public String toString() {
		return "[주문 상세 번호 :" + seq + "]\n"
				+ "주문 번호 : " + order_seq + "\n"
				+ "주문 개수 : " + userStock + "\n"
				+ "총 가격 :" + totalPrice + "\n"
				+ "상품 번호 : " + product_seq;
	}
	
	
	
	


	
	
	

	
	
}
