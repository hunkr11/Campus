package com.erp.campus.packages.entity.ehr.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_department_master",schema="ehr")

public class DeptMasterEntity implements Serializable{
	/**
	 * public String code;
	public String name;
	public String remarks;
	public int id;
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pki_dept_mas_id")
//	@GeneratedValue(strategy= GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="uvc_dept_code",unique=true)
	private String code;
	
	@Column(name="uvc_dept_name",unique=true)
	private String name;
	
	@Column(name="uvc_description")
	private String remarks;
	
//	@Column(name="is_active",columnDefinition="boolean default false",nullable=false)
//	private boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	

}
