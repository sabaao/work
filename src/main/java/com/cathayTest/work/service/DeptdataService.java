package com.cathayTest.work.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cathayTest.work.model.DeptdataEntity;

@Service
public interface  DeptdataService {

	 public List<DeptdataEntity> findDeptdatas();
	  
	 public DeptdataEntity getDeptdata(String deptID);
	  
	 public void saveDeptdata(DeptdataEntity Deptdata);
	  
	 public void deleteDeptdata(String deptID);
	  
	 public void updateDeptdata(DeptdataEntity Deptdata);
}
