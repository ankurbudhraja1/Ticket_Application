package com.virtusa.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dataset")
public class Dataset implements Serializable {

	private String dataset_name;
	private String domain;
	private String description;
	private String analytics_model;
	private String url;
	private String schema;
	
	
	public String getDataset_name() {
		return dataset_name;
	}
	
	@XmlElement
	public void setDataset_name(String dataset_name) {
		this.dataset_name = dataset_name;
	}
	
	public String getDomain() {
		return domain;
	}
	
	@XmlElement
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAnalytics_model() {
		return analytics_model;
	}
	
	@XmlElement
	public void setAnalytics_model(String analytics_model) {
		this.analytics_model = analytics_model;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public Dataset(String dataset_name, String domain, String description,
			String analytics_model, String url, String schema) {
		super();
		this.dataset_name = dataset_name;
		this.domain = domain;
		this.description = description;
		this.analytics_model = analytics_model;
		this.url = url;
		this.schema = schema;
	}

	public Dataset() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Dataset [dataset_name=" + dataset_name + ", domain=" + domain
				+ ", description=" + description + ", analytics_model="
				+ analytics_model + ", url=" + url + ", schema=" + schema + "]";
	}

	
	

	
	
	
}
