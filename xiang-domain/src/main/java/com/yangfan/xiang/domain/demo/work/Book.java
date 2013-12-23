package com.yangfan.xiang.domain.demo.work;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="DEMO_BOOK")
@DiscriminatorValue("B")
public class Book extends Work {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4243250646061611009L;
	
	/**
	 * 内容
	 */
	private String text;

	/**
	 * 内容
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}

	/**
	 * 内容
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [text=").append(text).append(", toString()=")
				.append(super.toString()).append("]");
		return builder.toString();
	}
	
}
