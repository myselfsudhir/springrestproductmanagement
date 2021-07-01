package com.te.products.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@XmlRootElement(name="response")
@JsonRootName("productResponse")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable{
	
	
	@XmlElement
	@JsonProperty
	private int statusCode;
	

	@XmlElement
	@JsonProperty
	private String msg;
	

	@XmlElement
	@JsonProperty
	private String description;
	
	@XmlElement
	@JsonProperty
	private Products product;
	
	@XmlElement
	@JsonProperty
	List<Products> products;

}
