package com.image.api.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "image_details")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String name;
	
	private String type;
	
	@Lob
	private byte[] data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(String id, String name, String type, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", type=" + type + ", data=" + Arrays.toString(data) + "]";
	}
	
	
}
