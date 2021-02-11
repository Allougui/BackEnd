package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column (name="x") 
	private long x;
	
	@Column (name="y")
	private long y;
	@Column (name="z")
	private long z; 
	
	@Column (name="speed")
	private int speed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public long getZ() {
		return z;
	}

	public void setZ(long z) {
		this.z = z;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Tag(Long id, long x, long y, long z, int speed) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
		this.speed = speed;
	}

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}