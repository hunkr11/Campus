package com.erp.campus.packages.entity.academic.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_admission_type",schema="academic")
@SequenceGenerator(name="common_entity_sqnce",sequenceName="academic.tbl_admission_type_i_admission_type_id_seq",schema="academic")
public class AdmissionTypeEntity implements Serializable{

	/** Serializable is used to store current state of a class. it internally states the compiler, that the class could be serialized and de-serialized successfully on the basis of serialVersionUID. 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="common_entity_sqnce")
	@Column(name="i_admission_type_id")
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="uvc_admission_type_code")
	private String code;
	
	@Column(name="uvc_admission_type_name")
	private String name;
	
	@Column(name="txt_remarks")
	private String remarks;
	

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
