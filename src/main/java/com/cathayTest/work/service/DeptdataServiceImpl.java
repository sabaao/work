package com.cathayTest.work.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cathayTest.work.model.DeptdataEntity;
import com.cathayTest.work.respository.DeptdataRepository;

@Service
public class DeptdataServiceImpl implements DeptdataService{
	
	@Autowired
	private DeptdataRepository deptdataRepository;
	
	public void setDeptdataRepository(DeptdataRepository deptdataRepository) {
		this.deptdataRepository = deptdataRepository;
	}

	@Override
	public List<DeptdataEntity> findDeptdatas() {
		 List<DeptdataEntity> deptdata = deptdataRepository.findAll();
		 return deptdata;
	}

	@Override
	public DeptdataEntity getDeptdata(String deptID) {
		Optional<DeptdataEntity> optDep = deptdataRepository.findById(deptID);
		return optDep.get();
	}

	@Override
	public void saveDeptdata(DeptdataEntity Deptdata) {
		deptdataRepository.save(Deptdata);
		
	}
	
	@Override
	public void deleteDeptdata(String deptID) {
		deptdataRepository.deleteById(deptID);
		
	}

	@Override
	public void updateDeptdata(DeptdataEntity Deptdata) {
		deptdataRepository.save(Deptdata);
		
	}



}
