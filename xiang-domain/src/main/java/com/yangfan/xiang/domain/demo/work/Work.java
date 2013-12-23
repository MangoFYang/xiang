package com.yangfan.xiang.domain.demo.work;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.yangfan.xiang.core.domain.CoreDomain;

/**
 * 作品
 * 
 * @author 杨帆
 *
 */
@Entity(name="DEMO_WORK")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", length=1)
public class Work extends CoreDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4511740185342070906L;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 作者
	 * 
	 * 未设置mappedBy属性，说明Work需要维护和Author直接的关系，
	 * 反应到数据库层面就是需要操作他俩的关联表。
	 * 双向关系一定要设置mappedBy属性
	 */
	@ManyToMany(fetch=FetchType.LAZY, targetEntity=Author.class)
	@JoinTable(name="DEMO_AUTHOR_WORK", joinColumns={
			@JoinColumn(name="work_id")
	}, inverseJoinColumns={
			@JoinColumn(name="author_id")
	})
	private Set<Author> authors = new HashSet<Author>();

	/**
	 * 标题
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 标题
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 作者
	 * 
	 * @return
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * 作者
	 * 
	 * @param authors
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Work [title=").append(title).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
