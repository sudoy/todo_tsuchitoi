package todo.beans;

import java.sql.Date;

public class Todo {
	private int id;
	private String title;
	private String detail;
	private int importance;
	private Date limitDate;
	public Todo(int id, String title, String detail, int importance, Date limitDate) {
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
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public Date getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

}
