package com.cathayTest.work.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.cathayTest.work.model.MemberEntity;

@Service
public interface  MemberService {

	 public List<MemberEntity> findMember();
	 
	 public Page<MemberEntity> findMemberNative(MemberEntity Member , Pageable pageable);
	 
	 public MemberEntity getMember(String empNo);
	  
	 public void saveMember(MemberEntity Member );
	  
	 public void deleteMember(String empNo);
	  
	 public void updateMember(MemberEntity Member);
}
