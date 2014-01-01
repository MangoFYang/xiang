package com.yangfan.xiang.model.po.demo.work;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="DEMO_SONG")
@DiscriminatorValue("S")
public class Song extends Work {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7766984483032573882L;
	
	/**
	 * 节拍
	 */
	private String tempo;
	
	/**
	 * 流派
	 */
	private String genre;

	/**
	 * 节拍
	 * 
	 * @return
	 */
	public String getTempo() {
		return tempo;
	}

	/**
	 * 节拍
	 * 
	 * @param tempo
	 */
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	/**
	 * 流派
	 * 
	 * @return
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 流派
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Song [tempo=").append(tempo).append(", genre=")
				.append(genre).append(", toString()=").append(super.toString())
				.append("]");
		return builder.toString();
	}

}
