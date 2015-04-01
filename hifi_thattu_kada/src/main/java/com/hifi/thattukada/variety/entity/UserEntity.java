package com.hifi.thattukada.variety.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="tbl_user", schema="admn")
// (hidden after adding mysql)  @SequenceGenerator(name="userEntity_Seq", sequenceName="admn.tbl_user_pki_user_id_seq", schema="admn")
public class UserEntity implements java.io.Serializable{

	@Id	
// (hidden after adding mysql)	@GeneratedValue(strategy = GenerationcType.SEQUENCE,generator="userEntity_Seq")
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="pki_user_id")
	private int pki_user_id;
	
	@Column
	private String uvc_user_name;
	
	//@Column(name="uvc_email")
	private String uvc_email;
	
	//@Column(name="vc_passwd")
	private String vc_passwd;
	
	private boolean b_send_updates;
		
	public UserEntity(){		
		System.out.println("\n\n ENTITY ACTIVATED \n\n");
	}
	
	public boolean isB_send_updates() {
		return b_send_updates;
	}


	public void setB_send_updates(boolean b_send_updates) {
		this.b_send_updates = b_send_updates;
	}


	public int getPki_user_id() {
		return pki_user_id;
	}

	public void setPki_user_id(int pki_user_id) {
		this.pki_user_id = pki_user_id;
	}
	public String getUvc_user_name() {
		return uvc_user_name;
	}

	public void setUvc_user_name(String uvc_user_name) {
		this.uvc_user_name = uvc_user_name;
	}

	public String getUvc_email() {
		return uvc_email;
	}

	public void setUvc_email(String uvc_email) {
		this.uvc_email = uvc_email;
	}

	public String getVc_passwd() {
		return vc_passwd;
	}

	public void setVc_passwd(String vc_passwd) {
		this.vc_passwd = vc_passwd;
	}
	
	
			
}
