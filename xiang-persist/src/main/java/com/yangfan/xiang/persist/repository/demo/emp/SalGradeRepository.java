package com.yangfan.xiang.persist.repository.demo.emp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.domain.demo.emp.SalGrade;

public interface SalGradeRepository extends CoreRepository<SalGrade, Integer> {
	
	@Query("select sg from DEMO_SALGRADE sg where sg.losal <= :sal and sg.hisal >= :sal")
	SalGrade findByLosalGreaterThanAndHisalLessThan(@Param("sal") Double sal);
	
}
