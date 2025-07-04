package kr.ac.kopo.board.vo;

import kr.ac.kopo.board.domain.Reservation;

public class ReservationVO {
	
	private String date;
	private Reservation vip;
	private Reservation common;
	private Reservation reasonable;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Reservation getVip() {
		return vip;
	}
	public void setVip(Reservation vip) {
		this.vip = vip;
	}
	public Reservation getCommon() {
		return common;
	}
	public void setCommon(Reservation common) {
		this.common = common;
	}
	public Reservation getReasonable() {
		return reasonable;
	}
	public void setReasonable(Reservation reasonable) {
		this.reasonable = reasonable;
	}
	
}
