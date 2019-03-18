package com.cathayTest.work.model;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "MEMBER")
@EntityListeners(AuditingEntityListener.class)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //員工編號
  	private String empNo;
    //姓名
    @Column(name = "NAME")
  	private String name;
  	//部門ID
    @Column(name = "DEPT_ID")
  	private long deptID;
  	//性別
    @Column(name = "SEX")
  	private String sex;
  	//電話
    @Column(name = "PHONE_NUMBER")
  	private String phoneNumber;
  	//地址
    @Column(name = "ADDRESS")
  	private String address;
  	//年齡
    @Column(name = "AGE")
  	private String age;
  	//建立時間
    @Column(name = "CREATE_DATE")
    @CreatedDate
  	private Date createDate;
  	//最後一次修改時間
    @LastModifiedDate
    @Column(name = "MOD_DATE") 
  	private Date modDate;
  	
    private String deptName;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDeptID() {
		return deptID;
	}
	public void setDeptID(long deptID) {
		this.deptID = deptID;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
