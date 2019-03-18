package com.cathayTest.work.respository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cathayTest.work.model.MemberEntity;

@Repository
public interface  Nativequery extends JpaRepository<MemberEntity,Long> {

	@Query(value = " SELECT MEMBER.EMP_NO,MEMBER.NAME,MEMBER.DEPT_ID,DEPT_DATA.DEPT_NAME,MEMBER.SEX,MEMBER.PHONE_NUMBER,MEMBER.ADDRESS,MEMBER.AGE,MEMBER.CREATE_DATE,MEMBER.MOD_DATE"+
			" FROM MEMBER , DEPT_DATA "+
			" WHERE 1=1 "+
			" AND MEMBER.DEPT_ID =  DEPT_DATA.DEPT_ID"+
			" AND CASE WHEN ?1 IS NULL THEN 1=1 ELSE MEMBER.EMP_NO=?1 END "+
			" AND CASE WHEN ?2 IS NULL THEN 1=1 ELSE MEMBER.NAME=?2 END "+
			" AND CASE WHEN ?3 IS NULL THEN 1=1 ELSE DEPT_DATA.DEPT_NAME=?3 END "+
			" AND CASE WHEN ?4 IS NULL THEN 1=1 ELSE MEMBER.AGE=?4 END "+
			" ORDER BY MEMBER.EMP_NO  ",
			countQuery = " SELECT count(MEMBER.EMP_NO)"+
					" FROM MEMBER , DEPT_DATA "+
							" WHERE 1=1 "+
							" AND MEMBER.DEPT_ID =  DEPT_DATA.DEPT_ID"+
							" AND CASE WHEN ?1 IS NULL THEN 1=1 ELSE MEMBER.EMP_NO=?1 END "+
							" AND CASE WHEN ?2 IS NULL THEN 1=1 ELSE MEMBER.NAME=?2 END "+
							" AND CASE WHEN ?3 IS NULL THEN 1=1 ELSE DEPT_DATA.DEPT_NAME=?3 END "+
							" AND CASE WHEN ?4 IS NULL THEN 1=1 ELSE MEMBER.AGE=?4 END "+
							" GROUP BY MEMBER.EMP_NO  ",nativeQuery = true)
	Page<MemberEntity> findMemberNative(String empNo , String name , String deptName , String age,Pageable pageable); 

}
