package com.cathayTest.work.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cathayTest.work.model.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity,String>{

}
