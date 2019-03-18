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

	@Autowired
	private Nativequery nativequery;

	public void setNativequery(Nativequery nativequery) {
		this.nativequery = nativequery;
	}

	/** 部門資料表 新刪改查 START **/

	// 查詢
	@GetMapping("/findDeptdatas")
	public List<DeptdataEntity> findDeptdatas() {
		List<DeptdataEntity> deptdata = deptdataService.findDeptdatas();
		return deptdata;
	}

	// 查詢單筆
	@GetMapping("/getDeptdata/{empNo}")
	public DeptdataEntity getDeptdata(@PathVariable String deptID) {
		return deptdataService.getDeptdata(deptID);
	}

	// 新增
	@PostMapping("/saveDeptdata")
	public DeptdataEntity saveDeptdata(@RequestBody DeptdataEntity deptdataEnity) {
		deptdataService.saveDeptdata(deptdataEnity);
		
		return getDeptdata(deptdataEnity.getDeptID());
	}

	// 修改
	@PostMapping("/updateDeptdata/{empNo}")
	public void updateDeptdata(@RequestBody DeptdataEntity deptdataEnity, @PathVariable(name = "deptID") String deptID) {
		DeptdataEntity emp = deptdataService.getDeptdata(deptID);

		if (emp != null) {
			deptdataService.updateDeptdata(deptdataEnity);
		}
	}

	// 刪除
	@PostMapping("/deleteDeptdata/{empNo}")
	public void deleteDeptdata(@PathVariable(name = "deptID") String deptID) {
		deptdataService.deleteDeptdata(deptID);
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
	@GetMapping("/getMember/{empNo}")
	public MemberEntity getMember(@PathVariable String empNo) {
		return memberService.getMember(empNo);

	}


	// 動態查詢
	@PostMapping("/queryMember")
	public Page<MemberEntity> findMemberNative(@RequestBody MemberEntity memberEnity ,DeptdataEntity deptdataEnity,
			@PageableDefault(value=10)Pageable pageable) {
		
		String empNo = memberEnity.getEmpNo()!=null?memberEnity.getEmpNo():null;
		String name = memberEnity.getName()!=null?memberEnity.getName():null;
		String deptName = deptdataEnity!=null?deptdataEnity.getDeptName():null;;
		String age = memberEnity.getAge()!=null?memberEnity.getAge():null;
		return nativequery.findMemberNative(empNo, name, deptName, age ,pageable);
	}

	// 新增
	@PostMapping("/saveMember")
	public MemberEntity saveMember(@RequestBody MemberEntity memberEnity) {
		memberService.saveMember(memberEnity);
		return getMember(memberEnity.getEmpNo());
	}

	// 修改
	@PostMapping("/updateMember/{empNo}")
	public void updateMember(@RequestBody MemberEntity memberEnity, @PathVariable(name = "empNo") String empNo) {
		MemberEntity emp = memberService.getMember(empNo);
		// 防止創立時間被覆蓋
		memberEnity.setCreateDate(emp.getCreateDate());
		if (emp != null) {
			memberService.updateMember(memberEnity);
		}
	}

	// 刪除
	@PostMapping("/deleteMember/{empNo}")
	public void deleteMember(@PathVariable(name = "empNo") String empNo) {
		memberService.deleteMember(empNo);
	}
	/** 員工資料表 新刪改查 END **/
}