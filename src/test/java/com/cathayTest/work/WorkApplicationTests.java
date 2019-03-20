package com.cathayTest.work;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.cathayTest.work.model.DeptdataEntity;
import com.cathayTest.work.service.DeptdataServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class WorkApplicationTests {

	private DeptdataServiceImpl depdataService = mock(DeptdataServiceImpl.class);

	// 查詢全部
	@Test
	public void findDeptdatas() {
		List<DeptdataEntity> DeptdataList = new ArrayList<DeptdataEntity>();
		DeptdataEntity enity = new DeptdataEntity("100","A部門");
		DeptdataList.add(enity);
		when(depdataService.findDeptdatas()).thenReturn(DeptdataList);
		List<DeptdataEntity> result = depdataService.findDeptdatas();
		assertEquals(1, result.size());
	}
	
	// 部門編號查單筆
	@Test
	public void getDeptdata() {
		when(depdataService.getDeptdata("100")).thenReturn(new DeptdataEntity("100","A部門"));
		DeptdataEntity result = depdataService.getDeptdata("100");
		assertEquals("A部門", result.getDeptName());
	}

	
}
