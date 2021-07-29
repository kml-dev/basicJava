package burger_VO;

public class OrderVO {
	private int seq;
	private String date;
	private String user_id;
		
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
