package burger_VO;

public class QnAVO {
	
	private int seq;
	private String title;
	private String date;
	private String content;
	private String comment;
	private String user_id;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Override
	public String toString() {
		return "[질문 번호 : " + seq + "]\n"
				+ "제목 : " + title + "\n"
				+ "아이디 : " + user_id + "\n"
				+ "날짜 : " + date + "\n"
				+ "내용 : " + content + "\n";
//				+ "답변 : " + comment + "\n";
	}
	
	
}
