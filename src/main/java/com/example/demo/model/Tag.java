package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	

	@Column (name="type")
	private String type;
	
	@Column (name="x") 
	private double x;
	
	@Column (name="y")
	private double y;
	@Column (name="z")
	private double z; 
	
	@Column (name="quality")
	private Long quality; 
	
	@Column (name="superFrameNumber")
	private Long superFrameNumber; 
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getQuality() {
		return quality;
	}

	public void setQuality(Long quality) {
		this.quality = quality;
	}

	public Long getSuperFrameNumber() {
		return superFrameNumber;
	}

	public void setSuperFrameNumber(Long superFrameNumber) {
		this.superFrameNumber = superFrameNumber;
	}

	public Tag(Long id, String type, double x, double y, double z, Long quality, Long superFrameNumber) {
		super();
		this.id = id;
		this.type = type;
		this.x = x;
		this.y = y;
		this.z = z;
		this.quality = quality;
		this.superFrameNumber = superFrameNumber;
	}

	public Tag() {
		super();
	}

	

//
//	public static int getId(Tag tag, Tag tag1) {
//		tag.getId()-tag1.getId();
//	}
}