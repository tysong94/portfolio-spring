package kr.ac.kopo.board.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@TableGenerator(name="user", table="SEQUENCES", allocationSize=1)
@Table(name="user")

public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	@XmlElement
	private int id;
	
	@Column
	@XmlElement
	private String userid;
	
	@Column
	@XmlElement
	private String password;
	
	@Column
	@XmlElement
	private String name;
	
	@Column
	@XmlElement
	private String address;
	
	@Column
	@XmlElement
	private String telnum;
	
	@Column
	@XmlElement
	private String auth;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Reservation> ReservationList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public Set<Reservation> getReservationList() {
		return ReservationList;
	}

	public void setReservationList(Set<Reservation> reservationList) {
		ReservationList = reservationList;
	}
	
}
