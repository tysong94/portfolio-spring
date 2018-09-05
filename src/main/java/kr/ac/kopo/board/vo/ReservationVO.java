package kr.ac.kopo.board.vo;

import java.util.Date;

public class ReservationVO {
	
	private String date;
	private String vip;
	private String common;
	private String reasonable;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getReasonable() {
		return reasonable;
	}

	public void setReasonable(String reasonable) {
		this.reasonable = reasonable;
	}
	
}
