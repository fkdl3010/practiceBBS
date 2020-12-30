package dto;

import java.sql.Date;

public class GilDto {
	
	private int gil_no;
	private String gil_writer;
	private String gil_title;
	private String gil_content;
	private String gil_pw;
	private int gil_hit;
	private String gil_ip;
	private Date gil_date;
	
	public int getgil_no() {
		return gil_no;
	}
	public void setgil_no(int gil_no) {
		this.gil_no = gil_no;
	}
	public String getgil_writer() {
		return gil_writer;
	}
	public void setgil_writer(String gil_writer) {
		this.gil_writer = gil_writer;
	}
	public String getgil_title() {
		return gil_title;
	}
	public void setgil_title(String gil_title) {
		this.gil_title = gil_title;
	}
	public String getgil_content() {
		return gil_content;
	}
	public void setgil_content(String gil_content) {
		this.gil_content = gil_content;
	}
	public String getgil_pw() {
		return gil_pw;
	}
	public void setgil_pw(String gil_pw) {
		this.gil_pw = gil_pw;
	}
	public int getgil_hit() {
		return gil_hit;
	}
	public void setgil_hit(int gil_hit) {
		this.gil_hit = gil_hit;
	}
	public String getgil_ip() {
		return gil_ip;
	}
	public void setgil_ip(String gil_ip) {
		this.gil_ip = gil_ip;
	}
	public Date getgil_date() {
		return gil_date;
	}
	public void setgil_date(Date gil_date) {
		this.gil_date = gil_date;
	}
}
