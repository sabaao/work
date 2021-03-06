package com.cathayTest.work.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.cathayTest.work.model.DeptdataEntity;
import com.cathayTest.work.model.MemberEntity;
import com.cathayTest.work.respository.MemberRepository;
import com.cathayTest.work.respository.Nativequery;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	public void setmemberRepository(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	
	@Autowired
	private Nativequery nativequery;
	
	public void setNativequery(Nativequery nativequery) {
		this.nativequery = nativequery;
	}
	
	@Override
	public List<MemberEntity> findMember() {
		 List<MemberEntity> Member = memberRepository.findAll();
		 return Member;
	}
	public Page<MemberEntity> findMemberNative(MemberEntity member) {
	    return nativequery.findMemberNative(member.getEmpNo(), member.getName(), member.getDeptName(), member.getAge(), PageRequest.of(0, 10));
	}
	@Override
	public MemberEntity getMember(String empNo) {
		Optional<MemberEntity> optMeb = memberRepository.findById(empNo);
		return optMeb.get();
	}

	@Override
	public void saveMember(MemberEntity Member) {
		memberRepository.save(Member);
		
	}

	@Override
	public void deleteMember(String empNo) {
		memberRepository.deleteById(empNo);
		
	}

	@Override
	public void updateMember(MemberEntity Member) {
		memberRepository.save(Member);
		
	}

}
