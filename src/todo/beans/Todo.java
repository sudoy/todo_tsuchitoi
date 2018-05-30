package todo.beans;

public class Todo {
	private int id;
	private String title;
	private String detail;
	private String importance;
	private String limitDate;
	public Todo(int id, String title, String detail, String importance, String limitDate) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.limitDate = limitDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImportance() {
		return importance;
	}
	public void setImportance(String importance) {
		this.importance = importance;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}

}
