package com.rvy.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDesc implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;
	private String size;

}
