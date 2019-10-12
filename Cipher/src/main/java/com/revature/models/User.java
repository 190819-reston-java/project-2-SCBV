package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="users")
public class User implements Serializable, IUser {


	private static final long serialVersionUID = -4553508689874995351L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userid;
	
	@Column(name="user_lastname")
	private String userlastname;
	
	
	@Column(name="user_firstname")
	private String userfirstname;
	
	@Column(name="user_email")
	private String useremail;
	
	@Column(name="user_password")
	private String userpassword;
	
	@Column(name="streetaddress")
	private String userstreetaddress;
	
	@Column(name="user_city")
	private String usercity;
	
	@Column(name="user_state")
	private String userstate;
	
	@Autowired
	@OneToMany( mappedBy="user")
	private List<Forums> forums;
	
	@Autowired
	@OneToMany( mappedBy="user")
	private List<Portfolios> portfolios;
	
	// Generated by Source menu - empty constructor for jackson
	public User() {
		super();
	}
	
	// Autowired Constructor
	public User(List<Forums> forums) {
		super();
		this.forums = forums;
	}

	public User(long userid, String userlastname, String userfirstname, String useremail, String userpassword,
			String userstreetaddress, String usercity, String userstate, List<Forums> forums,
			List<Portfolios> portfolios) {
		super();
		this.userid = userid;
		this.userlastname = userlastname;
		this.userfirstname = userfirstname;
		this.useremail = useremail;
		this.userpassword = userpassword;
		this.userstreetaddress = userstreetaddress;
		this.usercity = usercity;
		this.userstate = userstate;
		this.forums = forums;
		this.portfolios = portfolios;
	}

	@Override
	public long getUserid() {
		return userid;
	}

	@Override
	public void setUserid(long userid) {
		this.userid = userid;
	}

	@Override
	public String getUserlastname() {
		return userlastname;
	}

	@Override
	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	@Override
	public String getUserfirstname() {
		return userfirstname;
	}

	@Override
	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	@Override
	public String getUseremail() {
		return useremail;
	}

	@Override
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	@Override
	public String getUserpassword() {
		return userpassword;
	}

	@Override
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String getUserstreetaddress() {
		return userstreetaddress;
	}

	@Override
	public void setUserstreetaddress(String userstreetaddress) {
		this.userstreetaddress = userstreetaddress;
	}

	@Override
	public String getUsercity() {
		return usercity;
	}

	@Override
	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}

	@Override
	public String getUserstate() {
		return userstate;
	}

	@Override
	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	@Override
	public List<Forums> getForums() {
		return forums;
	}

	@Override
	public void setForums(List<Forums> forums) {
		this.forums = forums;
	}

	@Override
	public List<Portfolios> getPortfolios() {
		return portfolios;
	}

	@Override
	public void setPortfolios(List<Portfolios> portfolios) {
		this.portfolios = portfolios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(forums, portfolios, usercity, useremail, userfirstname, userid, userlastname, userpassword,
				userstate, userstreetaddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(forums, other.forums) && Objects.equals(portfolios, other.portfolios)
				&& Objects.equals(usercity, other.usercity) && Objects.equals(useremail, other.useremail)
				&& Objects.equals(userfirstname, other.userfirstname) && userid == other.userid
				&& Objects.equals(userlastname, other.userlastname) && Objects.equals(userpassword, other.userpassword)
				&& Objects.equals(userstate, other.userstate)
				&& Objects.equals(userstreetaddress, other.userstreetaddress);
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userlastname=" + userlastname + ", userfirstname=" + userfirstname
				+ ", useremail=" + useremail + ", userpassword=" + userpassword + ", userstreetaddress="
				+ userstreetaddress + ", usercity=" + usercity + ", userstate=" + userstate + ", forums=" + forums
				+ ", portfolios=" + portfolios + "]";
	}




//class closed
}
