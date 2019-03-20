package com.cathayTest.work.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cathayTest.work.model.DeptdataEntity;
import com.cathayTest.work.model.MemberEntity;
import com.cathayTest.work.respository.Nativequery;
import com.cathayTest.work.service.DeptdataService;
import com.cathayTest.work.service.MemberService;

//@Controller // 測JSP用
@RestController // 測API用
public class MainController {

	@Autowired
	private DeptdataService deptdataService;

	public void setDeptdataService(DeptdataService DeptdataService) {
		this.deptdataService = DeptdataService;
	}

	@Autowired
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}



	/** 部門資料表 新刪改查 START **/

	// 查詢
	@GetMapping("/findDeptdatas")
	public List<DeptdataEntity> findDeptdatas() {
		List<DeptdataEntity> deptdata = deptdataService.findDeptdatas();
		return deptdata;
	}

	// 查詢單筆
	@GetMapping("/getDeptdata")
	public DeptdataEntity getDeptdata(@RequestBody DeptdataEntity deptdataEnity) {
		return deptdataService.getDeptdata(deptdataEnity.getDeptID());
	}

	// 新增
	@PostMapping("/saveDeptdata")
	public DeptdataEntity saveDeptdata(@RequestBody DeptdataEntity deptdataEnity) {
		deptdataService.saveDeptdata(deptdataEnity);
		
		return getDeptdata(deptdataEnity);
	}

	// 修改
	@PostMapping("/updateDeptdata/")
	public DeptdataEntity updateDeptdata(@RequestBody DeptdataEntity deptdataEnity) {
		DeptdataEntity emp = deptdataService.getDeptdata(deptdataEnity.getDeptID());
		if (emp != null) {
			deptdataService.updateDeptdata(deptdataEnity);
		}
		return getDeptdata(deptdataEnity);
		
	}

	// 刪除
	@GetMapping("/deleteDeptdata")
	public String deleteDeptdata(@RequestBody DeptdataEntity deptdataEnity) {
		String deldatId = deptdataEnity.getDeptID();
		deptdataService.deleteDeptdata(deptdataEnity.getDeptID());
		return "delete 部門代號為 :"+deldatId+" scusses !";
	}

	/** 部門資料表 新刪改查 END **/

	/** 員工資料表 新刪改查 START **/
	// 查詢
	@GetMapping("/findMember")
	public List<MemberEntity> findMember() {
		List<MemberEntity> member = memberService.findMember();
		return member;
	}

	// 查詢單筆
	@GetMapping("/getMember")
	public MemberEntity getMember(@RequestBody MemberEntity memberEnity) {
		return memberService.getMember(memberEnity.getEmpNo());

	}


	// 動態查詢
	@PostMapping("/queryMember")
	public Page<MemberEntity> findMemberNative(@RequestBody MemberEntity memberEnity ) {
		return memberService.findMemberNative(memberEnity);
	}
	

	// 新增
	@PostMapping("/saveMember")
	public MemberEntity saveMember(@RequestBody MemberEntity memberEnity) {
		memberService.saveMember(memberEnity);
		return getMember(memberEnity);
	}

	// 修改
	@PostMapping("/updateMember")
	public MemberEntity updateMember(@RequestBody MemberEntity memberEnity) {
		MemberEntity emp = memberService.getMember(memberEnity.getEmpNo());
		// 防止創立時間被覆蓋
		memberEnity.setCreateDate(emp.getCreateDate());
		if (emp != null) {
			memberService.updateMember(memberEnity);
		}
		return memberService.getMember(memberEnity.getEmpNo());
	}

	// 刪除
	@PostMapping("/deleteMember")
	public String deleteMember(@RequestBody MemberEntity memberEnity) {
		String empno = memberEnity.getEmpNo();
		memberService.deleteMember(memberEnity.getEmpNo());
		return "delete 刪除員工編號為 :"+empno+" scusses !";
	}
	/** 員工資料表 新刪改查 END **/
}