package com.cathayTest.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cathayTest.work.model.MemberEntity;
import com.cathayTest.work.respository.Nativequery;

@Controller
public class PageController {

	@Autowired
	private Nativequery nativequery;

	public void setNativequery(Nativequery nativequery) {
		this.nativequery = nativequery;
	}
	
	@RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
	public String notesList(Model model,MemberEntity data,
			HttpServletRequest request) {
		model.addAttribute("Form", data);
		String name = (data.getName()==null||data.getName()=="")?null:data.getName();
		String empNo = (data.getEmpNo()==null||data.getEmpNo()=="")?null:data.getEmpNo();
		String deptname = (data.getDeptName()==null||data.getDeptName()=="")?null:data.getDeptName();
		String age = (data.getAge()==null||data.getAge()=="")?null:data.getAge();
		
		int page = 0;
        int size = 10; 
        System.out.println(request.getParameter("page"));
        System.out.println(request.getParameter("size"));
        
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        Page<MemberEntity> result = nativequery.findMemberNative(empNo, name, deptname, age, PageRequest.of(page, size));
        System.out.println(page);
		model.addAttribute("List", result);
		return "notesList";
	}
	

}
