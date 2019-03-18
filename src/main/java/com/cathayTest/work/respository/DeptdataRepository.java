package com.cathayTest.work.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cathayTest.work.model.DeptdataEntity;

@Repository
public interface DeptdataRepository extends JpaRepository<DeptdataEntity,String>{

}
