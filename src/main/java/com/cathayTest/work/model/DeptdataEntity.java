package com.cathayTest.work.model;

import javax.persistence.*;

@Entity
@Table(name = "DEPT_DATA")
public class DeptdataEntity {
	

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	//部門ID
	@Column(name = "DEPT_ID")
	private String deptID;
	//部門名稱
	@Column(name = "DEPT_NAME")
	private String deptName;



	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptID() {
		return deptID;
	}
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

}
