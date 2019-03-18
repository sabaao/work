package com.cathayTest.work;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cathayTest.work.model.DeptdataEntity;
import com.cathayTest.work.respository.DeptdataRepository;
import com.cathayTest.work.service.DeptdataServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class WorkApplicationTests {

	@Before
	public void setup(){
			  depdataService.setDeptdataRepository(depdataRepository);		
	}
	private DeptdataServiceImpl depdataService = new DeptdataServiceImpl();
	private DeptdataRepository depdataRepository = mock(DeptdataRepository.class);

//	// 查詢全部
//	@Test
//	public void findDeptdatas() {
//		List<DeptdataEntity> DeptdataList = new ArrayList<DeptdataEntity>();
//		DeptdataEntity enity = new DeptdataEntity();
//		enity.setDeptID(100);
//		enity.setDeptName("A_DEPT");
//		DeptdataList.add(enity);
//		when(depdataRepository.findAll()).thenReturn(DeptdataList);
//		List<DeptdataEntity> result = depdataService.findDeptdatas();
//		assertEquals(1, result.size());
//	}
//	
//	// 查詢單筆
//	@Test
//	public void getDeptdata() {
//		DeptdataEntity enity = new DeptdataEntity();
//		enity.setDeptID(100);
//		enity.setDeptName("A_DEPT");	
//		DeptdataEntity resultenity = new DeptdataEntity(); 
//		long id = 100;
//		when(depdataRepository.findById(id)).thenReturn(Optional.of(resultenity));
////		assertEquals(id,resultenity.getDeptID());
//	}
	
}
