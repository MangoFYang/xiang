package com.yangfan.xiang.model.po.demo.emp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 薪资等级
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(name="DEMO_SALGRADE")
public class SalGrade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 907294142004670281L;

	/**
	 * 等级
	 */
	@Id
	private Integer grade;
	
	/**
	 * 最低工资
	 */
	private Double losal;
	
	/**
	 * 最高工资
	 */
	private Double hisal;

	/**
	 * 等级
	 * 
	 * @return
	 */
	public Integer getGrade() {
		return grade;
	}

	/**
	 * 等级
	 * 
	 * @param grade
	 */
	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	/**
	 * 最低工资
	 * 
	 * @return
	 */
	public Double getLosal() {
		return losal;
	}

	/**
	 * 最低工资
	 * 
	 * @param losal
	 */
	public void setLosal(Double losal) {
		this.losal = losal;
	}

	/**
	 * 最高工资
	 * 
	 * @return
	 */
	public Double getHisal() {
		return hisal;
	}

	/**
	 * 最高工资
	 * 
	 * @param hisal
	 */
	public void setHisal(Double hisal) {
		this.hisal = hisal;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalGrade [grade=").append(grade).append(", losal=")
				.append(losal).append(", hisal=").append(hisal)
				.append(", toString()=").append(super.toString()).append("]");
		return builder.toString();
	}

}
