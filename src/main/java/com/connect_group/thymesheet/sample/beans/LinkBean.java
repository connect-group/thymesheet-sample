package com.connect_group.thymesheet.sample.beans;

public class LinkBean {
	private String url;
	private String text;
	
	public LinkBean(String url, String text) {
		this.setUrl(url);
		this.setText(text);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
