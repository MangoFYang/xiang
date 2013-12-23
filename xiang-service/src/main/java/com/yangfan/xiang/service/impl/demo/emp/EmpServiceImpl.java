package com.yangfan.xiang.service.impl.demo.emp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.emp.Emp;
import com.yangfan.xiang.domain.demo.emp.SalGrade;
import com.yangfan.xiang.persist.repository.demo.emp.EmpRepository;
import com.yangfan.xiang.service.iface.demo.emp.EmpService;
import com.yangfan.xiang.service.iface.demo.emp.SalGradeService;

@Service
public class EmpServiceImpl extends CoreServiceSupport<Emp, String> implements EmpService {
	
	@Resource
	private EmpRepository empRepository;
	
	@Resource
	private SalGradeService salGradeService;
	
	@Override
	protected CoreRepository<Emp, String> getRepository() {
		return empRepository;
	}

	@Override
	public Emp findByEmpNo(Integer empNo) {
		Emp findByEmpNo = empRepository.findByEmpNo(empNo);
		return findByEmpNo;
	}

	@Override
	public List<Emp> findByMgrIsNull() {
		return empRepository.findByMgrIsNull();
	}

	@Override
	public List<Emp> findSubordinatesByMgr(String mgrId) {
		return empRepository.findSubordinatesById(mgrId);
	}
	
	@Override
	public List<Emp> findSubordinatesByEmpNo(Integer empNo) {
		String id = empRepository.findIdByEmpNo(empNo);
		List<Emp> findSubordinatesById = this.findSubordinatesByMgr(id);
		return findSubordinatesById;
	}

	@Override
	public SalGrade findSalGradeByEmpNo(Integer empNo) {
		Emp findByEmpNo = this.findByEmpNo(empNo);
		SalGrade findByLosalGreaterThanAndHisalLessThan = salGradeService.findByLosalGreaterThanAndHisalLessThan(findByEmpNo.getSal());
		return findByLosalGreaterThanAndHisalLessThan;
	}

	@Override
	public Integer findEmpNoById(String id) {
		return empRepository.findEmpNoById(id);
	}

}
