package com.yangfan.xiang.model.po.demo.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.yangfan.xiang.core.po.CorePo;

/**
 * 字典
 * 
 * @author 杨帆
 *
 */
@Entity
@Table(
	name="DEMO_DICT", 
	uniqueConstraints={@UniqueConstraint(name="code_dictType", columnNames={"code", "dictType"})
})
public class Dict extends CorePo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -45427844173797425L;
	
	/**
	 * 代码
	 */
	@Column(nullable=false, length=60)
	private String code;

	/**
	 * 字典名
	 */
	@Column(nullable=false, length=100)
	private String label;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 字典类型
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dictType", nullable=false)
	private DictType dictType; 

	/**
	 * 代码
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 代码
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 字典名
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 字典名
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 字典类型
	 * @return
	 */
	public DictType getDictType() {
		return dictType;
	}

	/**
	 * 字典类型
	 * @param dictType
	 */
	public void setDictType(DictType dictType) {
		this.dictType = dictType;
	}

}
